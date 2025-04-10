package novamachina.exnihilotinkers.datagen.common;

import java.util.function.Consumer;
import javax.annotation.Nonnull;

import com.mojang.datafixers.util.Either;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.data.recipes.PrecipitateRecipeBuilder;
import novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities;
import novamachina.exnihilosequentia.data.recipes.SiftingRecipeBuilder;
import novamachina.exnihilosequentia.world.item.MeshType;
import novamachina.exnihilosequentia.world.item.Ore;
import novamachina.exnihilosequentia.world.item.OreItem;
import novamachina.exnihilosequentia.world.item.crafting.MeshWithChance;
import novamachina.exnihilosequentia.world.level.block.BarrelBlock;
import novamachina.exnihilosequentia.world.level.block.CrucibleBlock;
import novamachina.exnihilosequentia.world.level.block.EXNBlocks;
import novamachina.exnihilosequentia.world.level.block.SieveBlock;
import novamachina.exnihilosequentia.world.level.material.EXNFluids;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.exnihilotinkers.common.init.EXNTinkersItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.data.recipes.RecipeProvider;
import novamachina.novacore.world.item.ItemDefinition;
import novamachina.novacore.world.level.block.BlockDefinition;
import slimeknights.mantle.recipe.ingredient.FluidIngredient;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.block.SlimeType;
import slimeknights.tconstruct.world.TinkerWorld;
import slimeknights.tconstruct.world.block.DirtType;
import slimeknights.tconstruct.world.block.FoliageType;

public class EXNTinkersRecipes extends RecipeProvider {

  public EXNTinkersRecipes(PackOutput generator, ExistingFileHelper fileHelper) {
    super(generator, fileHelper, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);
  }

  private ResourceLocation tinkersLoc(String id) {
    return new ResourceLocation(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS,
        "tinkers/casting_" + id);
  }

  @Override
  protected void addRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
    createOre(EXNTinkersItems.COBALT, consumer);
    registerSieve(consumer);
    registerFluidItem(consumer);
    registerTConstructAdditions(consumer);
    registerBlockRecipes(consumer);
  }

    private void registerBlockRecipes(Consumer<FinishedRecipe> consumer) {
        //barrels
        createBarrel(consumer, EXNTinkersBlocks.SKYROOT_BARREL, TinkerWorld.skyroot.get().asItem(), TinkerWorld.skyroot.getSlab().asItem());
        createBarrel(consumer, EXNTinkersBlocks.BLOODSHROOM_BARREL, TinkerWorld.bloodshroom.get().asItem(), TinkerWorld.bloodshroom.getSlab().asItem());
        createBarrel(consumer, EXNTinkersBlocks.GREENHEART_BARREL, TinkerWorld.greenheart.get().asItem(), TinkerWorld.greenheart.getSlab().asItem());
        createBarrel(consumer, EXNTinkersBlocks.ENDERBARK_BARREL, TinkerWorld.enderbark.get().asItem(), TinkerWorld.enderbark.getSlab().asItem());
        //crucibles
        createCrucible(consumer, EXNTinkersBlocks.SKYROOT_CRUCIBLE, TinkerWorld.skyroot.getLog().asItem(), TinkerWorld.skyroot.getSlab().asItem());
        createCrucible(consumer, EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE, TinkerWorld.bloodshroom.getLog().asItem(), TinkerWorld.bloodshroom.getSlab().asItem());
        createCrucible(consumer, EXNTinkersBlocks.GREENHEART_CRUCIBLE, TinkerWorld.greenheart.getLog().asItem(), TinkerWorld.greenheart.getSlab().asItem());
        createCrucible(consumer, EXNTinkersBlocks.ENDERBARK_CRUCIBLE, TinkerWorld.enderbark.getLog().asItem(), TinkerWorld.enderbark.getSlab().asItem());
        //sieves
        createSieve(consumer, EXNTinkersBlocks.SKYROOT_SIEVE, TinkerWorld.skyroot.get().asItem(), TinkerWorld.skyroot.getSlab().asItem());
        createSieve(consumer, EXNTinkersBlocks.BLOODSHROOM_SIEVE, TinkerWorld.bloodshroom.get().asItem(), TinkerWorld.bloodshroom.getSlab().asItem());
        createSieve(consumer, EXNTinkersBlocks.GREENHEART_SIEVE, TinkerWorld.greenheart.get().asItem(), TinkerWorld.greenheart.getSlab().asItem());
        createSieve(consumer, EXNTinkersBlocks.ENDERBARK_SIEVE, TinkerWorld.enderbark.get().asItem(), TinkerWorld.enderbark.getSlab().asItem());
    }

    private void registerFluidItem(Consumer<FinishedRecipe> consumer) {
        PrecipitateRecipeBuilder.precipitate(new FluidStack(EXNFluids.WITCH_WATER.getStillFluid(), 1000)
                        , Items.BONE_MEAL, Blocks.SLIME_BLOCK)
                .build(consumer, new ResourceLocation(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS, "slime_block"));
    }

    private void registerTConstructAdditions(Consumer<FinishedRecipe> consumer) {
        ItemCastingRecipeBuilder.basinRecipe(TinkerWorld.slimeDirt.get(DirtType.SKY)).setCast(Items.DIRT, true)
                .setFluid(FluidIngredient.of(TinkerFluids.skySlime.get(), 1000))
                .setCoolingTime(40).save(consumer, tinkersLoc("sky_slime_dirt"));
        ItemCastingRecipeBuilder.basinRecipe(TinkerWorld.slimeDirt.get(DirtType.EARTH)).setCast(Items.DIRT, true)
                .setFluid(FluidIngredient.of(TinkerFluids.earthSlime.get(), 1000))
                .setCoolingTime(40).save(consumer, tinkersLoc("earth_slime_dirt"));
        ItemCastingRecipeBuilder.basinRecipe(TinkerWorld.slimeDirt.get(DirtType.ICHOR)).setCast(Items.DIRT, true)
                .setFluid(FluidIngredient.of(TinkerFluids.magma.get(), 1000))
                .setCoolingTime(40).save(consumer, tinkersLoc("ichor_slime_dirt"));
        ItemCastingRecipeBuilder.basinRecipe(TinkerWorld.slimeDirt.get(DirtType.ENDER)).setCast(Items.DIRT, true)
                .setFluid(FluidIngredient.of(TinkerFluids.enderSlime.get(), 1000))
                .setCoolingTime(40).save(consumer, tinkersLoc("ender_slime_dirt"));
    }

    private void registerSieve(Consumer<FinishedRecipe> consumer) {
        //Crushed netherrack to...
        //Cobalt pieces
        //assert EXNTinkersItems.COBALT.getPieceItem() != null;
        //SiftingRecipeBuilder.sifting(EXNBlocks.CRUSHED_NETHERRACK,
        //    EXNTinkersItems.COBALT.getPieceItem(),
        //    new MeshWithChance(MeshType.IRON, 0.05F),
        //    new MeshWithChance(MeshType.DIAMOND, 0.1F));

        //Earth Slime Dirt to...
        //Sky Slime Sapling
        createSlimeSaplings(DirtType.EARTH, FoliageType.SKY);
        //Sky Slime Ball
        createSlimeBalls(DirtType.EARTH, FoliageType.SKY);
        //Slime Ball
        createManySlimeBalls(DirtType.EARTH, Items.SLIME_BALL);

        //Sky Slime Dirt to...
        //Blood Slime Sapling
        createSlimeSaplings(DirtType.SKY, FoliageType.BLOOD);
        //Sky Slime Grass Seeds
        createSlimeSeeds(DirtType.SKY, FoliageType.SKY);
        //Sky Slime Ball
        createManySlimeBalls(DirtType.SKY, FoliageType.SKY);
        //Blood Slime Ball
        createSlimeBalls(DirtType.SKY, FoliageType.BLOOD);

        //IChor Slime Dirt to...
        //IChor Slime Grass Seeds
        createSlimeSeeds(DirtType.ICHOR, FoliageType.ICHOR);
        //Blood Slime Ball
        createManySlimeBalls(DirtType.ICHOR, FoliageType.BLOOD);
        //Ender Slime Ball
        createSlimeBalls(DirtType.ICHOR, FoliageType.ENDER);

        //Ender Slime Dirt to...
        //Ender Slime Sapling
        createSlimeSaplings(DirtType.ENDER, FoliageType.ENDER);
        //Ender Slime Grass Seeds
        createSlimeSeeds(DirtType.ENDER, FoliageType.ENDER);
        //Ender Slime Ball
        createManySlimeBalls(DirtType.ENDER, FoliageType.ENDER);
    }

    private SiftingRecipeBuilder createManySlimeBalls(Object input, Object output) {
        Block input1;
        if (input instanceof SlimeType) {
            input1 = TinkerWorld.slimeDirt.get((DirtType) input);
        } else {
            input1 = Blocks.DIRT;
        }

        Item output1;
        if (output instanceof SlimeType) {
            output1 = TinkerCommons.slimeball.get((SlimeType) output);
        } else {
            output1 = Items.SLIME_BALL;
        }

        return SiftingRecipeBuilder.sifting(Ingredient.of(input1),
                output1,
                new MeshWithChance(MeshType.STRING, 0.75F),
                new MeshWithChance(MeshType.STRING, 0.5F),
                new MeshWithChance(MeshType.STRING, 0.25F));
    }

    private SiftingRecipeBuilder createSlimeBalls(Object input, Object output) {
        Block input1;
        if (input instanceof SlimeType) {
            input1 = TinkerWorld.slimeDirt.get((DirtType) input);
        } else {
            input1 = Blocks.DIRT;
        }

        Item output1;
        if (output instanceof SlimeType) {
            output1 = TinkerCommons.slimeball.get((SlimeType) output);
        } else {
            output1 = Items.SLIME_BALL;
        }

        return SiftingRecipeBuilder.sifting(Ingredient.of(input1),
                output1,
                new MeshWithChance(MeshType.STRING, 0.5F),
                new MeshWithChance(MeshType.STRING, 0.25F));
    }

    private SiftingRecipeBuilder createSlimeSeeds(DirtType input, FoliageType output) {
        return SiftingRecipeBuilder.sifting(Ingredient.of(TinkerWorld.slimeDirt.get(input)),
                TinkerWorld.slimeGrassSeeds.get(output),
                new MeshWithChance(MeshType.STRING, 0.25F));
    }

    private SiftingRecipeBuilder createSlimeSaplings(DirtType input, FoliageType output) {
        return SiftingRecipeBuilder.sifting(Ingredient.of(TinkerWorld.slimeDirt.get(input)),
                TinkerWorld.slimeSapling.get(output),
                new MeshWithChance(MeshType.STRING, 0.25F));
    }

    private void createBarrel(Consumer<FinishedRecipe> consumer, BlockDefinition<?> barrel, Item block, Item slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, barrel).pattern("x x").pattern("x x").pattern("x-x").define('x', block).define('-', slab).group("exnihilosequentia").unlockedBy("has_walls", InventoryChangeTrigger.TriggerInstance.hasItems(block)).unlockedBy("has_base", InventoryChangeTrigger.TriggerInstance.hasItems(slab)).save(consumer, RecipeProviderUtilities.createSaveLocation(barrel.getId()));
    }

    private void createCrucible(Consumer<FinishedRecipe> consumer, BlockDefinition<?> crucible, Item block, Item slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, crucible).pattern("c c").pattern("clc").pattern("s s").define('c', block).define('l', slab).define('s', Tags.Items.RODS_WOODEN).group("exnihilosequentia").unlockedBy("has_logs", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{block})).save(consumer, RecipeProviderUtilities.createSaveLocation(crucible.getId()));
    }

    private void createSieve(Consumer<FinishedRecipe> consumer, BlockDefinition<?> sieve, Item block, Item slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sieve).pattern("p p").pattern("plp").pattern("s s").define('p', block).define('l', slab).define('s', Tags.Items.RODS_WOODEN).unlockedBy("has_plank", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{block})).save(consumer, RecipeProviderUtilities.createSaveLocation(sieve.getId()));
    }

    private void createOre(Ore ore, Consumer<FinishedRecipe> consumer) {
        this.createRawRecipe(ore, consumer);
        this.createNuggetRecipes(ore, consumer);
    }

    private void createRawRecipe(Ore ore, Consumer<FinishedRecipe> consumer) {
        Item piece = ore.getPieceItem();
        Either<ItemDefinition<OreItem>, Item> rawEither = ore.getRawOreItem();
        Item rawOre = rawEither.left().isPresent() ? ((ItemDefinition)rawEither.left().get()).asItem() : (Item)rawEither.right().get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rawOre).pattern("xx").pattern("xx").define('x', piece).group("exnihilosequentia").unlockedBy("has_piece", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{piece})).save(consumer, new ResourceLocation("exnihilotinkers", RecipeProviderUtilities.prependRecipePrefix(ForgeRegistries.ITEMS.getKey(rawOre).getPath())));
    }

    private void createNuggetRecipes(Ore ore, Consumer<FinishedRecipe> consumer) {
        if (ore.getNuggetItem().left().isPresent()) {
            Either<ItemDefinition<OreItem>, Item> eitherIngot = ore.getIngotItem();
            Item ingot = eitherIngot.left().isPresent() ? ((ItemDefinition)eitherIngot.left().get()).asItem() : (Item)eitherIngot.right().get();
            Item nugget = ((ItemDefinition)ore.getNuggetItem().left().get()).asItem();
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot).pattern("xxx").pattern("xxx").pattern("xxx").define('x', nugget).group("exnihilosequentia").unlockedBy("has_nugget", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{nugget})).save(consumer, new ResourceLocation("exnihilotinkers", RecipeProviderUtilities.prependRecipePrefix(ForgeRegistries.ITEMS.getKey(ingot).getPath() + "_from_nugget")));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot).unlockedBy("has_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{ingot})).save(consumer, RecipeProviderUtilities.createSaveLocation(ForgeRegistries.ITEMS.getKey(nugget)));
        }

    }
}
