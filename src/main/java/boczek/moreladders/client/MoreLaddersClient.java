package boczek.moreladders.client;

import boczek.moreladders.block.BlockLadders;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoreLaddersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLadders.BIRCH_LADDER, RenderLayer.getCutout());
    }
}
