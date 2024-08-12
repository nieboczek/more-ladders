package boczek.moreladders.compat.biomesoplenty;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BiomesOPlentyClient {
    public static void initialize() {
        BiomesOPlenty.blocks.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
    }
}
