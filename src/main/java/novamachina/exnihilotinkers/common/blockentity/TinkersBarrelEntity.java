package novamachina.exnihilotinkers.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.world.level.block.entity.WoodBarrelBlockEntity;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlockEntites;

public class TinkersBarrelEntity extends WoodBarrelBlockEntity {

  public TinkersBarrelEntity(BlockPos pos, BlockState state) {
    super(EXNTinkersBlockEntites.TINKERS_BARRELS.get(), pos, state);
  }
}
