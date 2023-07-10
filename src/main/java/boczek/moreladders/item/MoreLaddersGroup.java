package boczek.moreladders.item;

import boczek.moreladders.MoreLadders;
import boczek.moreladders.block.BlockLadders;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MoreLaddersGroup {
    public static ItemGroup MORE_LADDERS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(MoreLadders.MOD_ID, "more-ladders"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.more-ladders")).icon(() -> new ItemStack(BlockLadders.SPRUCE_LADDER))
                    .entries((displayContext, entries) -> {
                        // Items to add
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
                    }).build());
    public static void load() {
        MoreLadders.LOGGER.info("Registering More Ladders Group");
    }
}
