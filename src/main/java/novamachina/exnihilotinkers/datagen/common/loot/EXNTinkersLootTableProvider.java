package novamachina.exnihilotinkers.datagen.common.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import novamachina.exnihilotinkers.datagen.common.loot.table.EXNTinkersBlockLootTable;
import novamachina.novacore.data.loot.LootProvider;

import java.util.List;

public class EXNTinkersLootTableProvider extends LootProvider {
    public EXNTinkersLootTableProvider(PackOutput output) {
        super(output, List.of(new LootTableProvider.SubProviderEntry(EXNTinkersBlockLootTable::new, LootContextParamSets.BLOCK)));
    }
}
