package novamachina.exnihilotinkers.datagen.tinkers;

import net.minecraft.data.PackOutput;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.data.StationSlotLayoutProvider;

import javax.annotation.Nonnull;

public class EXNTinkersStationSlotLayout extends StationSlotLayoutProvider {

    public EXNTinkersStationSlotLayout(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void addLayouts() {
        defineModifiable(EXNTinkersTinkerItems.exnCrook)
                .sortIndex(SORT_HARVEST)
                .addInputItem(EXNTinkersTinkerItems.crookHead, 44, 28)
                .addInputItem(TinkerToolParts.toolHandle, 22, 52)
                .build();
        defineModifiable(EXNTinkersTinkerItems.exnHammer)
                .sortIndex(SORT_HARVEST)
                .addInputItem(TinkerToolParts.hammerHead, 44, 28)
                .addInputItem(TinkerToolParts.toolHandle, 22, 52)
                .build();
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Station Slot Layout for Ex Nihilo";
    }

}
