package novamachina.exnihilotinkers.common.block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.world.level.block.CrucibleBlock;
import novamachina.exnihilotinkers.common.blockentity.TinkersCrucibleEntity;

public class TinkersCrucibleBlock extends CrucibleBlock implements EntityBlock {

  public TinkersCrucibleBlock() {
    super(BlockBehaviour.Properties.of().strength(.75F)
            .sound(SoundType.STONE).noOcclusion());
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
    return new TinkersCrucibleEntity(pos, state);
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level,
      @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
    if (!level.isClientSide) {
      return (level1, blockPos, blockState, t) -> {
        if (t instanceof TinkersCrucibleEntity tile) {
          tile.tickServer();
        }
      };
    }
    return null;
  }
}
