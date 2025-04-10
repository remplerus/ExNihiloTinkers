package novamachina.exnihilotinkers.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.data.AbstractBlockStateGenerator;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;

public class EXNTinkersBlockStates extends AbstractBlockStateGenerator {

  public EXNTinkersBlockStates(PackOutput gen, ExistingFileHelper exFileHelper) {
    super(gen, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS, exFileHelper);
  }

  public ResourceLocation tinkersLoc(String string) {
    return new ResourceLocation(EXNTinkersConstants.ModIds.TINKERS_MOD, "block/wood/" + string);
  }

  private void registerBarrels() {
    createBarrel(EXNTinkersBlocks.BLOODSHROOM_BARREL.block(), tinkersLoc("bloodshroom/planks"));
    createBarrel(EXNTinkersBlocks.ENDERBARK_BARREL.block(), tinkersLoc("enderbark/planks"));
    createBarrel(EXNTinkersBlocks.GREENHEART_BARREL.block(), tinkersLoc("greenheart/planks"));
    createBarrel(EXNTinkersBlocks.SKYROOT_BARREL.block(), tinkersLoc("skyroot/planks"));
  }

  private void registerSieves() {
    createSieve(EXNTinkersBlocks.BLOODSHROOM_SIEVE.block(),
            tinkersLoc("bloodshroom/stripped_log"));
    createSieve(EXNTinkersBlocks.ENDERBARK_SIEVE.block(),
            tinkersLoc("enderbark/stripped_log"));
    createSieve(EXNTinkersBlocks.GREENHEART_SIEVE.block(),
            tinkersLoc("greenheart/stripped_log"));
    createSieve(EXNTinkersBlocks.SKYROOT_SIEVE.block(),
            tinkersLoc("skyroot/stripped_log"));
  }

  private void registerCrucibles() {
    createCrucible(EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE.block(),
            tinkersLoc("bloodshroom/log"));
    createCrucible(EXNTinkersBlocks.ENDERBARK_CRUCIBLE.block(),
            tinkersLoc("bloodshroom/log"));
    createCrucible(EXNTinkersBlocks.GREENHEART_CRUCIBLE.block(),
            tinkersLoc("greenheart/log"));
    createCrucible(EXNTinkersBlocks.SKYROOT_CRUCIBLE.block(),
            tinkersLoc("skyroot/log"));
  }

  @Override
  protected void registerStatesAndModels() {
    registerSieves();
    registerBarrels();
    registerCrucibles();
  }

  private void createCrucible(Block block, ResourceLocation texture) {
    createCrucible(block, texture, texture);
  }
  private void createSieve(Block block, ResourceLocation texture) {
    createSieve(block, texture, texture);
  }
  private void createBarrel(Block block, ResourceLocation texture) {
    createBarrel(block, texture, texture);
  }
}
