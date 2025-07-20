package novamachina.exnihilotinkers.common.init;

import net.minecraft.world.level.block.entity.BlockEntity;
import novamachina.exnihilotinkers.common.blockentity.TinkersBarrelEntity;
import novamachina.exnihilotinkers.common.blockentity.TinkersCrucibleEntity;
import novamachina.exnihilotinkers.common.blockentity.TinkersSieveEntity;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.registries.BlockEntityTypeRegistry;
import novamachina.novacore.world.level.block.BlockEntityTypeDefinition;

import java.util.List;

public class EXNTinkersBlockEntites {
  private static final BlockEntityTypeRegistry BLOCK_ENTITIES =
      new BlockEntityTypeRegistry(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);

  public static List<BlockEntityTypeDefinition<? extends BlockEntity>> getDefinitions() {
    return BLOCK_ENTITIES.getRegistry();
  }

  public static final BlockEntityTypeDefinition<TinkersSieveEntity> TINKERS_SIEVES =
      BLOCK_ENTITIES.create(
          "tinkers_sieves",
                  TinkersSieveEntity::new,
                  EXNTinkersBlocks.BLOODSHROOM_SIEVE,
                  EXNTinkersBlocks.ENDERBARK_SIEVE,
                  EXNTinkersBlocks.GREENHEART_SIEVE,
                  EXNTinkersBlocks.SKYROOT_SIEVE);
  public static final BlockEntityTypeDefinition<TinkersCrucibleEntity> TINKERS_CRUCIBLES =
      BLOCK_ENTITIES.create(
          "tinkers_crucibles",
                  TinkersCrucibleEntity::new,
                  EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE,
                  EXNTinkersBlocks.ENDERBARK_CRUCIBLE,
                  EXNTinkersBlocks.GREENHEART_CRUCIBLE,
                  EXNTinkersBlocks.SKYROOT_CRUCIBLE);
  public static final BlockEntityTypeDefinition<TinkersBarrelEntity> TINKERS_BARRELS =
      BLOCK_ENTITIES.create(
          "tinkers_barrels",
                  TinkersBarrelEntity::new,
                  EXNTinkersBlocks.BLOODSHROOM_BARREL,
                  EXNTinkersBlocks.ENDERBARK_BARREL,
                  EXNTinkersBlocks.GREENHEART_BARREL,
                  EXNTinkersBlocks.SKYROOT_BARREL);
}
