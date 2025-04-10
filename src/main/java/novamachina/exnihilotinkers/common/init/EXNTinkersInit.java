package novamachina.exnihilotinkers.common.init;

import com.mojang.logging.LogUtils;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihilosequentia.common.Config;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConfig;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.IRegistry;
import novamachina.novacore.world.item.CreativeModeTabDefinition;
import novamachina.novacore.world.item.ItemDefinition;
import novamachina.novacore.world.level.block.BlockDefinition;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(
    modid = EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EXNTinkersInit {

  private static final Logger logger = LogUtils.getLogger();

  private EXNTinkersInit() {}

  public static void init(IEventBus eventBus) {
    EXNTinkersBlockEntites.init(eventBus);
    EXNTinkersTinkerItems.init(eventBus);
  }

  public static void initItems(IRegistry<ItemDefinition<?>> registry) {
    for (ItemDefinition<?> definition : EXNTinkersItems.getDefinitions()) {
      registry.register(definition);
    }
  }

  public static void initCreative(IRegistry<CreativeModeTabDefinition> registry) {
    for (CreativeModeTabDefinition definition : EXNTinkersCreativeModTab.getDefinitions()) {
      registry.register(definition);
    }
  }

  public static void initBlocks(IRegistry<BlockDefinition<?>> registry) {
    for (BlockDefinition<?> definition : EXNTinkersBlocks.getDefinitions()) {
      registry.register(definition);
    }
  }

  @SubscribeEvent
  public static void onServerStart(ServerStartingEvent event) {
    logger.debug("Fired FMLServerStartingEvent");
    overrideOres();
  }

  private static void overrideOres() {
    if (Config.enableOreOverride()) {
      EXNTinkersItems.COBALT.setEnabled(EXNTinkersConfig.enableCobalt());
    }
  }
}
