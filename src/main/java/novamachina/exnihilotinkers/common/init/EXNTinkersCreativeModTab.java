package novamachina.exnihilotinkers.common.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.registries.CreativeModeTabRegistry;
import novamachina.novacore.world.item.CreativeModeTabDefinition;
import slimeknights.tconstruct.common.registration.CastItemObject;

import java.util.List;
import java.util.function.Function;

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
                                    (parameters, output) -> {
                                        EXNTinkersItems.getDefinitions().forEach(output::accept);
                                        EXNTinkersBlocks.getDefinitions().forEach(output::accept);
                                        output.accept(EXNTinkersTinkerItems.exnCrook);
                                        output.accept(EXNTinkersTinkerItems.exnHammer);
                                        output.accept(EXNTinkersTinkerItems.crookHead);
                                        addCasts(output, CastItemObject::get);
                                        addCasts(output, CastItemObject::getSand);
                                        addCasts(output, CastItemObject::getRedSand);
                                    }
                            )
            .build());

    private static void addCasts(CreativeModeTab.Output output, Function<CastItemObject, ItemLike> getter) {
        accept(output, getter, EXNTinkersTinkerItems.crookHeadCast);
    }

    private static void accept(CreativeModeTab.Output output, Function<CastItemObject, ItemLike> getter, CastItemObject cast) {
        output.accept(getter.apply(cast));
    }
}
