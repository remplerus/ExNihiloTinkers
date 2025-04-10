package novamachina.exnihilotinkers.common.init;

import java.util.List;
import java.util.Optional;

import net.minecraft.world.item.Item;
import novamachina.exnihilosequentia.world.item.Ore;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.core.registries.ItemRegistry;
import novamachina.novacore.world.item.ItemDefinition;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.world.TinkerWorld;

public class EXNTinkersItems {

  private static final ItemRegistry ITEMS = new ItemRegistry(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);
    public static final Ore COBALT =
            new Ore("cobalt", true,
                    Optional.of(TinkerWorld.rawCobalt.asItem()),
                    Optional.of(TinkerMaterials.cobalt.getIngot()),
                    Optional.of(TinkerMaterials.cobalt.getNugget()),
                    ITEMS);
  public static List<ItemDefinition<? extends Item>> getDefinitions() {
    return ITEMS.getRegistry();
  }
}
