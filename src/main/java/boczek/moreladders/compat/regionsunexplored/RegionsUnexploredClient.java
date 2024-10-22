package boczek.moreladders.compat.regionsunexplored;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RegionsUnexploredClient {
    public static void initialize() {
        RegionsUnexplored.blocks.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
    }
}
