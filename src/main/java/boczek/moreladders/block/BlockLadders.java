package boczek.moreladders.block;

import boczek.moreladders.MoreLadders;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockLadders {
    public static final Block SPRUCE_LADDER = registerBlock("spruce_ladder", new Block(FabricBlockSettings.copyOf(Blocks.LADDER)));
    public static final Block BIRCH_LADDER = registerBlock("birch_ladder", new Block(FabricBlockSettings.copyOf(Blocks.LADDER)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MoreLadders.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MoreLadders.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        MoreLadders.LOGGER.info("Registering Ladders");
    }
}
