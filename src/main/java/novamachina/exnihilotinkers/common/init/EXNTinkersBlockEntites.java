package novamachina.exnihilotinkers.common.init;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilotinkers.common.blockentity.TinkersBarrelEntity;
import novamachina.exnihilotinkers.common.blockentity.TinkersCrucibleEntity;
import novamachina.exnihilotinkers.common.blockentity.TinkersSieveEntity;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import org.slf4j.Logger;

public class EXNTinkersBlockEntites {

  private static final Logger logger = LogUtils.getLogger();
  private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(
          ForgeRegistries.BLOCK_ENTITY_TYPES, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);

  public static void init(IEventBus eventBus) {
    logger.debug("Register Block Entities");
    BLOCK_ENTITIES.register(eventBus);
  }

  public static final RegistryObject<BlockEntityType<TinkersSieveEntity>> TINKERS_SIEVES =
      BLOCK_ENTITIES.register(
          "tinkers_sieves",
          () ->
              BlockEntityType.Builder.of(
                      TinkersSieveEntity::new,
                              EXNTinkersBlocks.BLOODSHROOM_SIEVE.block(),
                              EXNTinkersBlocks.ENDERBARK_SIEVE.block(),
                      EXNTinkersBlocks.GREENHEART_SIEVE.block(),
                      EXNTinkersBlocks.SKYROOT_SIEVE.block())
                  .build(null));
  public static final RegistryObject<BlockEntityType<TinkersCrucibleEntity>> TINKERS_CRUCIBLES =
      BLOCK_ENTITIES.register(
          "tinkers_crucibles",
          () ->
              BlockEntityType.Builder.of(
                      TinkersCrucibleEntity::new,
                              EXNTinkersBlocks.BLOODSHROOM_CRUCIBLE.block(),
                              EXNTinkersBlocks.ENDERBARK_CRUCIBLE.block(),
                      EXNTinkersBlocks.GREENHEART_CRUCIBLE.block(),
                      EXNTinkersBlocks.SKYROOT_CRUCIBLE.block())
                  .build(null));
  public static final RegistryObject<BlockEntityType<TinkersBarrelEntity>> TINKERS_BARRELS =
      BLOCK_ENTITIES.register(
          "tinkers_barrels",
          () ->
              BlockEntityType.Builder.of(
                      TinkersBarrelEntity::new,
                              EXNTinkersBlocks.BLOODSHROOM_BARREL.block(),
                              EXNTinkersBlocks.ENDERBARK_BARREL.block(),
                      EXNTinkersBlocks.GREENHEART_BARREL.block(),
                      EXNTinkersBlocks.SKYROOT_BARREL.block())
                  .build(null));
}
