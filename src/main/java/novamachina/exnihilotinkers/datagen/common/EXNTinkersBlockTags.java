package novamachina.exnihilotinkers.datagen.common;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class EXNTinkersBlockTags extends BlockTagsProvider {
  public EXNTinkersBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookup, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    tag(BlockTags.MINEABLE_WITH_AXE)
        .add(EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE.block(),
            EXNTinkersBlocks.BLOODSHROOM_BARREL.block(),
            EXNTinkersBlocks.BLOODSHROOM_SIEVE.block(),
            EXNTinkersBlocks.ENDERBARK_BARREL.block(),
            EXNTinkersBlocks.ENDERBARK_CRUCIBLE.block(),
            EXNTinkersBlocks.ENDERBARK_SIEVE.block(),
            EXNTinkersBlocks.GREENHEART_BARREL.block(),
            EXNTinkersBlocks.GREENHEART_CRUCIBLE.block(),
            EXNTinkersBlocks.GREENHEART_SIEVE.block(),
            EXNTinkersBlocks.SKYROOT_BARREL.block(),
            EXNTinkersBlocks.SKYROOT_CRUCIBLE.block(),
            EXNTinkersBlocks.SKYROOT_SIEVE.block());
  }
}