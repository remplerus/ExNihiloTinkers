package novamachina.exnihilotinkers.datagen.common;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.tags.ExNihiloTags;
import novamachina.exnihilosequentia.world.item.Ore;
import novamachina.exnihilosequentia.world.item.OreItem;
import novamachina.exnihilotinkers.common.init.EXNTinkersItems;
import novamachina.exnihilotinkers.common.init.tconstruct.EXNTinkersTinkerItems;
import novamachina.exnihilotinkers.common.utility.EXNTinkersConstants;
import novamachina.exnihilotinkers.common.utility.EXNTinkersTags;
import novamachina.novacore.data.tags.TagProvider;
import novamachina.novacore.world.item.ItemDefinition;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class EXNTinkersItemTags extends TagProvider {

    public EXNTinkersItemTags(PackOutput generator, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              ExistingFileHelper existingFileHelper) {
    super(generator, lookupProvider, EXNTinkersConstants.ModIds.EX_NIHILO_TINKERS,
        existingFileHelper);
    }

  @Override
  protected void registerTags() {
    registerOre(EXNTinkersItems.COBALT, new ExNihiloTags.OreTag(EXNTinkersItems.COBALT));
    this.addToTag(ExNihiloTags.CROOK, EXNTinkersTinkerItems.exnCrook.asItem());
    this.addToTag(ExNihiloTags.HAMMER, EXNTinkersTinkerItems.exnHammer.asItem());
    this.addToTag(TinkerTags.Items.MODIFIABLE, EXNTinkersTinkerItems.exnHammer.asItem(), EXNTinkersTinkerItems.exnCrook.asItem());
    this.addToTag(TinkerTags.Items.HARVEST, EXNTinkersTinkerItems.exnCrook.get());
    this.addToTag(TinkerTags.Items.HARVEST_PRIMARY, EXNTinkersTinkerItems.exnCrook.get(), EXNTinkersTinkerItems.exnHammer.get());
    this.addToTag(TinkerTags.Items.MELEE, EXNTinkersTinkerItems.exnCrook.get(), EXNTinkersTinkerItems.exnHammer.get());
    this.addToTag(TinkerTags.Items.STONE_HARVEST, EXNTinkersTinkerItems.exnHammer.get());
    this.addToTag(TinkerTags.Items.DURABILITY, EXNTinkersTinkerItems.exnCrook.get(), EXNTinkersTinkerItems.exnHammer.get());
    this.addToTag(TinkerTags.Items.MULTIPART_TOOL, EXNTinkersTinkerItems.exnCrook.get(), EXNTinkersTinkerItems.exnHammer.get());
    this.addToTag(TinkerTags.Items.TOOL_PARTS, EXNTinkersTinkerItems.crookHead.get());
    this.addToTag(TinkerTags.Items.GOLD_CASTS, EXNTinkersTinkerItems.crookHeadCast.get());
    this.addToTag(TinkerTags.Items.RED_SAND_CASTS, EXNTinkersTinkerItems.crookHeadCast.getRedSand());
    this.addToTag(TinkerTags.Items.SAND_CASTS, EXNTinkersTinkerItems.crookHeadCast.getSand());
    this.addToTag(EXNTinkersTags.MULTI_USE, EXNTinkersTinkerItems.crookHeadCast.get());
    this.addToTag(EXNTinkersTags.SINGLE_USE, EXNTinkersTinkerItems.crookHeadCast.getSand(), EXNTinkersTinkerItems.crookHeadCast.getRedSand());
  }

  private void registerOre(Ore ore, ExNihiloTags.OreTag tags) {
    this.addIngot(ore, tags);
    this.addPiece(ore);
    this.addRaw(ore, tags);
    this.addNugget(ore, tags);
  }

  private void addNugget(Ore ore, ExNihiloTags.OreTag tags) {
    Either<ItemDefinition<OreItem>, Item> either = ore.getNuggetItem();
    if (either.left().isPresent()) {
      this.addToTag(tags.getNuggetTag(), new ItemLike[]{(ItemLike)either.left().get()});
      this.getItemBuilder(net.minecraftforge.common.Tags.Items.NUGGETS).add(new TagKey[]{tags.getNuggetTag()});
    }

  }

  private void addRaw(Ore ore, ExNihiloTags.OreTag tags) {
    Either<ItemDefinition<OreItem>, Item> either = ore.getRawOreItem();
    if (either.left().isPresent()) {
      this.addToTag(tags.getRawMaterialTag(), new ItemLike[]{(ItemLike)either.left().get()});
      this.getItemBuilder(net.minecraftforge.common.Tags.Items.RAW_MATERIALS).add(new TagKey[]{tags.getRawMaterialTag()});
    }

  }

  private void addPiece(Ore ore) {
    this.addToTag(ExNihiloTags.PIECE, new ItemLike[]{ore.getPieceItem()});
  }

  private void addIngot(Ore ore, ExNihiloTags.OreTag tags) {
    Either<ItemDefinition<OreItem>, Item> either = ore.getIngotItem();
    if (either.left().isPresent()) {
      this.addToTag(tags.getIngotTag(), new ItemLike[]{(ItemLike)either.left().get()});
      this.getItemBuilder(net.minecraftforge.common.Tags.Items.INGOTS).add(new TagKey[]{tags.getIngotTag()});
    }

  }
}
