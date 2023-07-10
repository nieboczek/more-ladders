package boczek.moreladders.client;

import boczek.moreladders.block.BlockLadders;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoreLaddersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.BIRCH_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.ACACIA_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.SPRUCE_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.CRIMSON_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.CHAIN_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.IRON_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.DARK_OAK_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.WARPED_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.JUNGLE_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.CHERRY_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.BAMBOO_LADDER, RenderLayer.getCutout());
    }
}
