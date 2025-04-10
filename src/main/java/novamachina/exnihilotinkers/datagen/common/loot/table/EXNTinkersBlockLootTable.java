package novamachina.exnihilotinkers.datagen.common.loot.table;

import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.novacore.data.loot.table.BlockLootTables;

public class EXNTinkersBlockLootTable extends BlockLootTables {
    @Override
    protected void generate() {
        add(
            this::createSingleItemTable,
            EXNTinkersBlocks.BLOODSHROOM_BARREL,
            EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE,
            EXNTinkersBlocks.BLOODSHROOM_SIEVE,
            EXNTinkersBlocks.ENDERBARK_BARREL,
            EXNTinkersBlocks.ENDERBARK_CRUCIBLE,
            EXNTinkersBlocks.ENDERBARK_SIEVE,
            EXNTinkersBlocks.GREENHEART_BARREL,
            EXNTinkersBlocks.GREENHEART_CRUCIBLE,
            EXNTinkersBlocks.GREENHEART_SIEVE,
            EXNTinkersBlocks.SKYROOT_BARREL,
            EXNTinkersBlocks.SKYROOT_CRUCIBLE,
            EXNTinkersBlocks.SKYROOT_SIEVE
        );
    }
}
