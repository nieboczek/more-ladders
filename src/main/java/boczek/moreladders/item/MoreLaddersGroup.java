package boczek.moreladders.item;

import boczek.moreladders.MoreLadders;
import boczek.moreladders.block.BlockLadders;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MoreLaddersGroup {
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(MoreLadders.MOD_ID, "more-ladders"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.more-ladders")).icon(() -> new ItemStack(BlockLadders.SPRUCE_LADDER))
                        .entries((displayContext, entries) -> {
                            entries.add(BlockLadders.SPRUCE_LADDER);
                            entries.add(BlockLadders.BIRCH_LADDER);
                            entries.add(BlockLadders.CHAIN_LADDER);
                            entries.add(BlockLadders.ACACIA_LADDER);
                            entries.add(BlockLadders.CRIMSON_LADDER);
                            entries.add(BlockLadders.WARPED_LADDER);
                            entries.add(BlockLadders.DARK_OAK_LADDER);
                            entries.add(BlockLadders.IRON_LADDER);
                            entries.add(BlockLadders.JUNGLE_LADDER);
                            entries.add(BlockLadders.CHERRY_LADDER);
                            entries.add(BlockLadders.BAMBOO_LADDER);
                            entries.add(BlockLadders.MANGROVE_LADDER);
                            entries.add(BlockLadders.GOLD_LADDER);
                            entries.add(BlockLadders.COPPER_LADDER);
                            entries.add(BlockLadders.EXPOSED_COPPER_LADDER);
                            entries.add(BlockLadders.WEATHERED_COPPER_LADDER);
                            entries.add(BlockLadders.OXIDIZED_COPPER_LADDER);
                            entries.add(BlockLadders.WAXED_COPPER_LADDER);
                            entries.add(BlockLadders.WAXED_EXPOSED_COPPER_LADDER);
                            entries.add(BlockLadders.WAXED_WEATHERED_COPPER_LADDER);
                            entries.add(BlockLadders.WAXED_OXIDIZED_COPPER_LADDER);
                        }).build());
    }
}
