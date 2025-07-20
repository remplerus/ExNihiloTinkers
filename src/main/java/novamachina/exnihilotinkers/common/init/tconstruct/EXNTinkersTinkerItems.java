package novamachina.exnihilotinkers.common.init.tconstruct;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import novamachina.exnihilotinkers.common.tinkers.ToolDefinitions;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import org.slf4j.Logger;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.TinkerModule;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import java.util.function.Supplier;

public class EXNTinkersTinkerItems extends TinkerModule {
    private static final Logger logger = LogUtils.getLogger();
    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);
    private static final Item.Properties PART_PROPERTIES = new Item.Properties();
    private static final Item.Properties SMELTERY_PROPERTIES = new Item.Properties();
    private static final Supplier<Item.Properties> TOOL = Item.Properties::new;

    public static final ItemObject<ModifiableItem> exnCrook = ITEMS.register("exn_crook", () -> new ModifiableItem(TOOL.get(), ToolDefinitions.exnCrook));
    public static final ItemObject<ModifiableItem> exnHammer = ITEMS.register("exn_hammer", () -> new ModifiableItem(TOOL.get(), ToolDefinitions.exnHammer));
    public static final ItemObject<ToolPartItem> crookHead = ITEMS.register("crook_head", () -> new ToolPartItem(PART_PROPERTIES, HeadMaterialStats.ID));
    public static final CastItemObject crookHeadCast = ITEMS.registerCast("crook_head", SMELTERY_PROPERTIES);

    public static void init(IEventBus modEventBus) {
        logger.debug("Register Ex Nihilo Tools to Tinkers");
        ITEMS.register(modEventBus);
    }

}
