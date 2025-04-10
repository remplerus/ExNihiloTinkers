package novamachina.exnihilotinkers.common.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.registries.CreativeModeTabRegistry;
import novamachina.novacore.world.item.CreativeModeTabDefinition;

import java.util.List;

public class EXNTinkersCreativeModTab {
    private static final CreativeModeTabRegistry CREATIVE_MODE_TABS =
            new CreativeModeTabRegistry(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);

    public static List<CreativeModeTabDefinition> getDefinitions() {
        return CREATIVE_MODE_TABS.getRegistry();
    }

    public static final CreativeModeTabDefinition TINKERS =
            CREATIVE_MODE_TABS.creativeModeTab(
                    "exnihilotinkers_tab",
                    CreativeModeTab.builder()
                            .icon(() -> EXNTinkersItems.COBALT.getPieceItem().getDefaultInstance())
                            .title(Component.literal("Ex Nihilo: Tinkers"))
                            .displayItems(
                                    (parameters, outout) -> {
                                        EXNTinkersItems.getDefinitions().forEach(outout::accept);
                                        EXNTinkersBlocks.getDefinitions().forEach(outout::accept);
                                    }
                            )
            .build());
}
