package novamachina.exnihilotinkers.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihilotinkers.datagen.client.EXNTinkersBlockStates;
import novamachina.exnihilotinkers.datagen.client.EXNTinkersLang;
import novamachina.exnihilotinkers.datagen.client.EXNTinkersOreItems;
import novamachina.exnihilotinkers.datagen.common.EXNTinkersItemTags;
import novamachina.exnihilotinkers.datagen.common.EXNTinkersRecipes;
import novamachina.exnihilotinkers.datagen.common.loot.EXNTinkersLootTableProvider;
import novamachina.exnihilotinkers.datagen.tinkers.EXNTinkersPartSprites;
import novamachina.exnihilotinkers.datagen.tinkers.EXNTinkersStationSlotLayout;
import novamachina.exnihilotinkers.datagen.tinkers.EXNTinkersToolDefinitions;
import novamachina.exnihilotinkers.datagen.tinkers.EXNTinkersToolRecipes;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EXNTinkersDataGenerators {

  private EXNTinkersDataGenerators() {}

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    ExistingFileHelper fileHelper = event.getExistingFileHelper();

    if (event.includeServer()) {
      // Recipes
      generator.addProvider(true, new EXNTinkersRecipes(output, fileHelper));
      // Tags
      generator.addProvider(true,
          new EXNTinkersItemTags(output, event.getLookupProvider(), fileHelper));
      // LootTables
      generator.addProvider(true, new EXNTinkersLootTableProvider(output));
      // Tinkers Tool Recipe
      generator.addProvider(true, new EXNTinkersToolRecipes(output));
      // Tinkers Tool Definition
      generator.addProvider(true, new EXNTinkersToolDefinitions(output));
      // Tinkers Station Slot Layout
      generator.addProvider(true, new EXNTinkersStationSlotLayout(output));
    }
    if (event.includeClient()) {
      // Lang
      generator.addProvider(true, new EXNTinkersLang(output, "en_us"));
      // BlockStates
      generator.addProvider(true, new EXNTinkersBlockStates(output, fileHelper));
      // Items
      generator.addProvider(true, new EXNTinkersOreItems(output, fileHelper));
        TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
      generator.addProvider(true, new MaterialPartTextureGenerator(output, fileHelper,
        new EXNTinkersPartSprites(), materialSprites));
    }
  }
}
