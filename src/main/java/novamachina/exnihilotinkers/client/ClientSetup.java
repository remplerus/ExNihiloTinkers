package novamachina.exnihilotinkers.client;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import novamachina.exnihilosequentia.client.render.BarrelRender;
import novamachina.exnihilosequentia.client.render.CrucibleRender;
import novamachina.exnihilosequentia.client.render.SieveRender;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlockEntites;
import novamachina.exnihilotinkers.common.init.EXNTinkersBlocks;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(
    modid = EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS,
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

  public static final Logger logger = LogUtils.getLogger();

  private ClientSetup() {}

  public static void init(final FMLClientSetupEvent event) {
    logger.debug("Initializing client renderers");

    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.BLOODSHROOM_SIEVE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.ENDERBARK_SIEVE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.GREENHEART_SIEVE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.SKYROOT_SIEVE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //        EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //        EXNTinkersBlocks.ENDERBARK_CRUCIBLE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.GREENHEART_CRUCIBLE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.SKYROOT_CRUCIBLE.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //        EXNTinkersBlocks.BLOODSHROOM_BARREL.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //        EXNTinkersBlocks.ENDERBARK_BARREL.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.GREENHEART_BARREL.block(), RenderType.cutoutMipped());
    //ItemBlockRenderTypes.setRenderLayer(
    //    EXNTinkersBlocks.SKYROOT_BARREL.block(), RenderType.cutoutMipped());

    SieveRender.register(EXNTinkersBlockEntites.TINKERS_SIEVES.get());
    BarrelRender.register(EXNTinkersBlockEntites.TINKERS_BARRELS.get());
    CrucibleRender.register(EXNTinkersBlockEntites.TINKERS_CRUCIBLES.get());
  }
}
