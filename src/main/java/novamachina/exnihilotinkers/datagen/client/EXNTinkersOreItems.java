package novamachina.exnihilotinkers.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilotinkers.common.init.EXNTinkersItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;

public class EXNTinkersOreItems extends ItemModelProvider {

  public EXNTinkersOreItems(PackOutput generator, ExistingFileHelper existingFileHelper) {
    super(generator, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.singleTexture(EXNTinkersItems.COBALT.getPieceId(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(this.modid, "item/" + EXNTinkersItems.COBALT.getPieceId()));
  }
}
