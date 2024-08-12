package boczek.moreladders.compat.blockus;

import boczek.moreladders.MoreLadders;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.List;

public class Blockus {
    public static List<Block> blocks = List.of();

    public static void initialize() {}

    private static Block registerBlock(String name, Block block) {
        blocks.add(block);
        Registry.register(Registries.ITEM, MoreLadders.id(name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, MoreLadders.id(name), block);
    }
}
