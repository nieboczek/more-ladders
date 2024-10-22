package boczek.moreladders.block;

import boczek.moreladders.MoreLadders;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.List;

public class ModBlocks {
    public static final Block SPRUCE_LADDER = registerBlock("spruce_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block BIRCH_LADDER = registerBlock("birch_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block DARK_OAK_LADDER = registerBlock("dark_oak_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block JUNGLE_LADDER = registerBlock("jungle_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block WARPED_LADDER = registerBlock("warped_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block CRIMSON_LADDER = registerBlock("crimson_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block IRON_LADDER = registerBlock("iron_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block ACACIA_LADDER = registerBlock("acacia_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block CHAIN_LADDER = registerBlock("chain_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.CHAIN).requiresTool()));
    public static final Block CHERRY_LADDER = registerBlock("cherry_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block BAMBOO_LADDER = registerBlock("bamboo_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.BAMBOO)));
    public static final Block MANGROVE_LADDER = registerBlock("mangrove_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block GOLD_LADDER = registerBlock("gold_ladder", new LadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block COPPER_LADDER = registerBlock("copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER).ticksRandomly(), Oxidizable.OxidationLevel.UNAFFECTED));
    public static final Block EXPOSED_COPPER_LADDER = registerBlock("exposed_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER).ticksRandomly(), Oxidizable.OxidationLevel.EXPOSED));
    public static final Block WEATHERED_COPPER_LADDER = registerBlock("weathered_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER).ticksRandomly(), Oxidizable.OxidationLevel.WEATHERED));
    public static final Block OXIDIZED_COPPER_LADDER = registerBlock("oxidized_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER), Oxidizable.OxidationLevel.OXIDIZED));
    public static final Block WAXED_COPPER_LADDER = registerBlock("waxed_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER), Oxidizable.OxidationLevel.UNAFFECTED));
    public static final Block WAXED_EXPOSED_COPPER_LADDER = registerBlock("waxed_exposed_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER), Oxidizable.OxidationLevel.EXPOSED));
    public static final Block WAXED_WEATHERED_COPPER_LADDER = registerBlock("waxed_weathered_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER), Oxidizable.OxidationLevel.WEATHERED));
    public static final Block WAXED_OXIDIZED_COPPER_LADDER = registerBlock("waxed_oxidized_copper_ladder", new OxidizableLadder(AbstractBlock.Settings.copy(Blocks.LADDER), Oxidizable.OxidationLevel.OXIDIZED));
    public static List<Block> blocks = List.of();

    private static Block registerBlock(String name, Block block) {
        blocks.add(block);
        Registry.register(Registries.ITEM, MoreLadders.id(name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, MoreLadders.id(name), block);
    }

    public static void initialize() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_LADDER, EXPOSED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_LADDER, WEATHERED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_LADDER, OXIDIZED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_LADDER, WAXED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_LADDER, WAXED_EXPOSED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_LADDER, WAXED_WEATHERED_COPPER_LADDER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_LADDER, WAXED_OXIDIZED_COPPER_LADDER);
    }
}