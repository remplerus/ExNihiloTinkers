package novamachina.exnihilotinkers.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.world.level.block.entity.SieveBlockEntity;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlockEntites;

public class TinkersSieveEntity extends SieveBlockEntity {

  public TinkersSieveEntity(BlockPos pos, BlockState state) {
    super(EXNTinkersBlockEntites.TINKERS_SIEVES.get(), pos, state);
  }
}
