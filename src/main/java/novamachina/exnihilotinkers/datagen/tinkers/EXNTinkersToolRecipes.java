package novamachina.exnihilotinkers.datagen.tinkers;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class EXNTinkersToolRecipes extends RecipeProvider implements IConditionBuilder, IRecipeHelper, IMaterialRecipeHelper, IToolRecipeHelper {
    public EXNTinkersToolRecipes(PackOutput generator) {
        super(generator);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tool Recipes for Ex Nihilo";
    }

    @Override
    protected void buildRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        this.addEXNToolBuildingRecipes(consumer);
        this.addEXNPartRecipes(consumer);
    }

    @Nonnull
    @Override
    public String getModId() {
        return EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS;
    }

    private void addEXNToolBuildingRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/building/";

        toolBuilding(consumer, EXNTinkersTinkerItems.exnHammer, folder);
        toolBuilding(consumer, EXNTinkersTinkerItems.exnCrook, folder);
    }

    private void addEXNPartRecipes(Consumer<FinishedRecipe> consumer) {
        String partFolder = "smeltery/tools/parts/";
        String castFolder = "smeltery/parts/";

        partRecipes(consumer, EXNTinkersTinkerItems.crookHead, EXNTinkersTinkerItems.crookHeadCast, 3, partFolder, castFolder);
    }

}
