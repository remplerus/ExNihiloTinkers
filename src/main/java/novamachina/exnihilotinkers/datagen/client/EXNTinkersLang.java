package novamachina.exnihilotinkers.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.exnihilotinkers.common.init.EXNTinkersItems;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.data.AbstractLangGenerator;

public class EXNTinkersLang extends AbstractLangGenerator {
  public EXNTinkersLang(PackOutput gen, String locale) {
    super(gen, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS, locale);
  }

  @Override
  protected void addTranslations() {
    for (int i = 0; i < EXNTinkersBlocks.getDefinitions().size(); i++) {
      Block block = EXNTinkersBlocks.getDefinitions().stream().toList().get(i).block();
      add(
          "block."
              + EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS
              + "."
              + ForgeRegistries.BLOCKS.getKey(block).getPath(),
          properNaming(ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    String ITEM_STRING = "item." + EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS + ".";
    for (int i = 0; i < EXNTinkersItems.getDefinitions().size(); i++) {
      Item item = EXNTinkersItems.getDefinitions().stream().toList().get(i).itemStack().getItem();
      String resourcePath = ForgeRegistries.ITEMS.getKey(item).getPath();
      add(ITEM_STRING + resourcePath, properNaming(resourcePath));
    }
        add(ITEM_STRING + EXNTinkersTinkerItems.exnCrook.asItem(),
     properNaming(EXNTinkersTinkerItems.exnCrook.getId().getPath().replace("exn_", "")));
        add(ITEM_STRING + EXNTinkersTinkerItems.exnHammer.asItem(),
     properNaming(EXNTinkersTinkerItems.exnHammer.getId().getPath().replace("exn_", "Nihilo ")));
        add(ITEM_STRING + EXNTinkersTinkerItems.crookHead.asItem(),
     properNaming(EXNTinkersTinkerItems.crookHead.getId().getPath()));
        add(ITEM_STRING + EXNTinkersTinkerItems.crookHeadCast.asItem(),
     properNaming(EXNTinkersTinkerItems.crookHeadCast.getId().getPath().replace("_cast", "_gold_cast")));
        add(ITEM_STRING + EXNTinkersTinkerItems.crookHeadCast.getRedSand().asItem(),
     properNaming(EXNTinkersTinkerItems.crookHeadCast.getRedSand().getDescriptionId().replace("item.exnihilotinkers.", "")));
        add(ITEM_STRING + EXNTinkersTinkerItems.crookHeadCast.getSand().asItem(),
     properNaming(EXNTinkersTinkerItems.crookHeadCast.getSand().getDescriptionId().replace("item.exnihilotinkers.", "")));
        add(ITEM_STRING + EXNTinkersTinkerItems.exnCrook.asItem() + ".description",
                "The Crook is a precision leaf cutting tool, breaking leaves and harvesting silkworms, strings and saplings.");
        add(ITEM_STRING + EXNTinkersTinkerItems.exnHammer.asItem() + ".description",
                "The Ex Nihilo Hammer is a crushing tool, effective on stones, sand and gravel. It crushes blocks down to dust.");
        add("pattern.exnihilotinkers.crook_head", "Crook Head");
  }
}
