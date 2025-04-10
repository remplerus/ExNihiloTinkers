package novamachina.exnihilotinkers.datagen.tinkers;

import net.minecraft.data.PackOutput;
import novamachina.exnihilosequentia.tags.ExNihiloTags;
import novamachina.exnihilotinkers.common.tinkers.ToolDefinitions;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.definition.module.build.MultiplyStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.IsEffectiveModule;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

import static novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems.crookHead;
import static slimeknights.tconstruct.tools.TinkerToolParts.toolHandle;
import static slimeknights.tconstruct.tools.TinkerToolParts.hammerHead;

public class EXNTinkersToolDefinitions extends AbstractToolDefinitionDataProvider {
  public EXNTinkersToolDefinitions(PackOutput generator) {
      super(generator, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS);
  }

  @Nonnull
  @Override
  public String getName() {
      return "Tool Definitions for Ex Nihilo";
  }

  @Override
  protected void addToolDefinitions() {
      DefaultMaterialsModule defaultTwoParts = DefaultMaterialsModule.builder().material(RandomMaterial.random().tier(1).build(), RandomMaterial.random().tier(1).build()).build();
      define(ToolDefinitions.exnCrook)
              .module(PartStatsModule.parts()
                .part(crookHead)
                .part(toolHandle).build())
              .module(defaultTwoParts)
              .module(new SetStatsModule(StatsNBT.builder()
                      .set(ToolStats.ATTACK_DAMAGE, -2F)
                      .set(ToolStats.ATTACK_SPEED, 3F).build()))
              .module(new MultiplyStatsModule(MultiplierNBT.builder()
                      .set(ToolStats.DURABILITY, 1.4F).build()))
              .module(IsEffectiveModule.tag(ExNihiloTags.MINEABLE_WITH_CROOK))
              .smallToolStartingSlots()
              .build();
      define(ToolDefinitions.exnHammer)
              .module(PartStatsModule.parts()
                      .part(hammerHead)
                      .part(toolHandle).build())
              .module(defaultTwoParts)
              .module(new SetStatsModule(StatsNBT.builder()
                      .set(ToolStats.ATTACK_DAMAGE, 0.5F)
                      .set(ToolStats.ATTACK_SPEED, 1.2F).build()))
              .module(new MultiplyStatsModule(MultiplierNBT.builder()
                      .set(ToolStats.DURABILITY, 2.2F).build()))
              .smallToolStartingSlots()
              .module(IsEffectiveModule.tag(ExNihiloTags.MINEABLE_WITH_HAMMER))
              .build();
  }
}
