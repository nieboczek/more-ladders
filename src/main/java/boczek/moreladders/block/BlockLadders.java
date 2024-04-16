package boczek.moreladders.block;

import boczek.moreladders.MoreLadders;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockLadders {
    public static final Block SPRUCE_LADDER = registerBlock("spruce_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block BIRCH_LADDER = registerBlock("birch_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block DARK_OAK_LADDER = registerBlock("dark_oak_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block JUNGLE_LADDER = registerBlock("jungle_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block WARPED_LADDER = registerBlock("warped_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block CRIMSON_LADDER = registerBlock("crimson_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block IRON_LADDER = registerBlock("iron_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.METAL)));
    public static final Block ACACIA_LADDER = registerBlock("acacia_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block CHAIN_LADDER = registerBlock("chain_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.CHAIN)));
    public static final Block CHERRY_LADDER = registerBlock("cherry_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block BAMBOO_LADDER = registerBlock("bamboo_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.BAMBOO)));
    public static final Block MANGROVE_LADDER = registerBlock("mangrove_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.LADDER)));
    public static final Block GOLD_LADDER = registerBlock("gold_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.METAL)));
    public static final Block COPPER_LADDER = registerBlock("copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.UNAFFECTED));
    public static final Block EXPOSED_COPPER_LADDER = registerBlock("exposed_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.EXPOSED));
    public static final Block WEATHERED_COPPER_LADDER = registerBlock("weathered_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.WEATHERED));
    public static final Block OXIDIZED_COPPER_LADDER = registerBlock("oxidized_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.OXIDIZED));
    public static final Block WAXED_COPPER_LADDER = registerBlock("waxed_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.UNAFFECTED, true));
    public static final Block WAXED_EXPOSED_COPPER_LADDER = registerBlock("waxed_exposed_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.EXPOSED, true));
    public static final Block WAXED_WEATHERED_COPPER_LADDER = registerBlock("waxed_weathered_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.WEATHERED, true));
    public static final Block WAXED_OXIDIZED_COPPER_LADDER = registerBlock("waxed_oxidized_copper_ladder", new OxidizableLadder(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(BlockSoundGroup.COPPER), Oxidizable.OxidationLevel.OXIDIZED, true));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MoreLadders.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MoreLadders.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
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
