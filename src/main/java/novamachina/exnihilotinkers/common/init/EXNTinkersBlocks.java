package novamachina.exnihilotinkers.common.init;

import net.minecraft.world.level.block.Block;
import novamachina.exnihilotinkers.common.block.TinkersBarrelBlock;
import novamachina.exnihilotinkers.common.block.TinkersCrucibleBlock;
import novamachina.exnihilotinkers.common.block.TinkersSieveBlock;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.registries.BlockRegistry;
import novamachina.novacore.world.level.block.BlockDefinition;

import java.util.List;

public class EXNTinkersBlocks {

  private static final BlockRegistry BLOCKS =
        new BlockRegistry(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);

  public static final BlockDefinition<TinkersBarrelBlock> BLOODSHROOM_BARREL =
          BLOCKS.block("Bloodshroom Barrel", "bloodshroom_barrel", TinkersBarrelBlock::new);
  public static final BlockDefinition<TinkersBarrelBlock> ENDERBARK_BARREL =
          BLOCKS.block("Enderbark Barrel", "enderbark_barrel", TinkersBarrelBlock::new);
  public static final BlockDefinition<TinkersBarrelBlock> GREENHEART_BARREL =
          BLOCKS.block("Greenheart Barrel", "greenheart_barrel", TinkersBarrelBlock::new);
  public static final BlockDefinition<TinkersBarrelBlock> SKYROOT_BARREL =
          BLOCKS.block("Skyroot Barrel", "skyroot_barrel", TinkersBarrelBlock::new);
  public static final BlockDefinition<TinkersCrucibleBlock> BLOODSHROOM_CRUCIBLE =
          BLOCKS.block("Bloodshroom Crucible", "bloodshroom_crucible", TinkersCrucibleBlock::new);
  public static final BlockDefinition<TinkersCrucibleBlock> ENDERBARK_CRUCIBLE =
          BLOCKS.block("Enderbark Crucible", "enderbark_crucible", TinkersCrucibleBlock::new);
  public static final BlockDefinition<TinkersCrucibleBlock> GREENHEART_CRUCIBLE =
          BLOCKS.block("Greenheart Crucible", "greenheart_crucible", TinkersCrucibleBlock::new);
  public static final BlockDefinition<TinkersCrucibleBlock> SKYROOT_CRUCIBLE =
          BLOCKS.block("Skyroot Crucible", "skyroot_crucible", TinkersCrucibleBlock::new);
  public static final BlockDefinition<TinkersSieveBlock> BLOODSHROOM_SIEVE =
          BLOCKS.block("Bloodshroom Sieve", "bloodshroom_sieve", TinkersSieveBlock::new);
  public static final BlockDefinition<TinkersSieveBlock> ENDERBARK_SIEVE =
          BLOCKS.block("Enderbark Sieve", "enderbark_sieve", TinkersSieveBlock::new);
  public static final BlockDefinition<TinkersSieveBlock> GREENHEART_SIEVE =
          BLOCKS.block("Greenheart Sieve", "greenheart_sieve", TinkersSieveBlock::new);
  public static final BlockDefinition<TinkersSieveBlock> SKYROOT_SIEVE =
          BLOCKS.block("Skyroot Sieve", "skyroot_sieve", TinkersSieveBlock::new);

  public static List<BlockDefinition<? extends Block>> getDefinitions() {
    return BLOCKS.getRegistry();
  }
}
