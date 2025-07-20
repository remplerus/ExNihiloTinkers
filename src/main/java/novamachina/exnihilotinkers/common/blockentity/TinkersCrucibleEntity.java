package novamachina.exnihilotinkers.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.world.level.block.entity.WoodCrucibleBlockEntity;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlockEntites;

public class TinkersCrucibleEntity extends WoodCrucibleBlockEntity {

  public TinkersCrucibleEntity(BlockEntityType<? extends TinkersCrucibleEntity> be, BlockPos pos, BlockState state) {
    super(be, pos, state);
  }
}
