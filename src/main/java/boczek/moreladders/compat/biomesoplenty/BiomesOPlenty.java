package boczek.moreladders.compat.biomesoplenty;

import boczek.moreladders.MoreLadders;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class BiomesOPlentyBlocks {
    public static final Block REDWOOD_LADDER = registerBlock("redwood_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));

    public static void initialize() {}

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.ITEM, MoreLadders.id(name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, MoreLadders.id(name), block);
    }
}
