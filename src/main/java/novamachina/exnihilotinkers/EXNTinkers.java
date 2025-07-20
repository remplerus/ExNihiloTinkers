package novamachina.exnihilotinkers;

import com.mojang.logging.LogUtils;
import java.io.File;
import java.nio.file.Path;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.RegisterEvent;
import novamachina.exnihilotinkers.client.ClientSetup;
import novamachina.exnihilotinkers.common.init.EXNTinkersInit;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConfig;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.novacore.bootstrap.ForgeBlockEntityTypeRegistry;
import novamachina.novacore.bootstrap.ForgeBlockRegistry;
import novamachina.novacore.bootstrap.ForgeCreativeModeTabRegistry;
import novamachina.novacore.bootstrap.ForgeItemRegistry;
import org.slf4j.Logger;

@Mod(EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS)
public class EXNTinkers {

  private static final Logger logger = LogUtils.getLogger();

  Path path = FMLPaths.CONFIGDIR.get().resolve("exnihilo-addons");
  File pathString = new File(path.toString());

  public EXNTinkers() {
    logger.debug("Starting Ex Nihilo: Sequentia - Tinkers Addon");
    if (!pathString.exists()) {
      pathString.mkdir();
    }
    EXNTinkersConfig.loadConfig(
        EXNTinkersConfig.COMMON_CONFIG, path.resolve("exntinkers-common.toml"));
    FMLJavaModLoadingContext.get().getModEventBus()
      .addListener(
        (RegisterEvent event) -> {
          if (event.getRegistryKey().equals(BuiltInRegistries.BLOCK.key())) {
            EXNTinkersInit.initBlocks(new ForgeBlockRegistry());
          }
          if (event.getRegistryKey().equals(BuiltInRegistries.BLOCK_ENTITY_TYPE.key())) {
              EXNTinkersInit.initEntities(new ForgeBlockEntityTypeRegistry());
          }
          if (event.getRegistryKey().equals(BuiltInRegistries.ITEM.key())) {
            EXNTinkersInit.initItems(new ForgeItemRegistry());
          }
          if (event.getRegistryKey().equals(BuiltInRegistries.CREATIVE_MODE_TAB.key())) {
            EXNTinkersInit.initCreative(new ForgeCreativeModeTabRegistry());
          }
        }
      );
    EXNTinkersInit.init(FMLJavaModLoadingContext.get().getModEventBus());
    FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
  }
}
