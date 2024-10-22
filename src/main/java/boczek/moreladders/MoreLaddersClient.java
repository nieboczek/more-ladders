package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import boczek.moreladders.compat.biomesoplenty.BiomesOPlentyClient;
import boczek.moreladders.compat.blockus.BlockusClient;
import boczek.moreladders.compat.regionsunexplored.RegionsUnexploredClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;

public class MoreLaddersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.blocks.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
        if (MoreLadders.BIOMESOPLENTY_PRESENT) {
            BiomesOPlentyClient.initialize();
        }
        if (MoreLadders.BLOCKUS_PRESENT) {
            BlockusClient.initialize();
        }
        if (MoreLadders.REGIONSUNEXPLORED_PRESENT) {
            RegionsUnexploredClient.initialize();
        }

        ModContainer container = FabricLoader.getInstance().getModContainer(MoreLadders.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("MoreLadders mod container couldn't be found"));
        ResourceManagerHelper.registerBuiltinResourcePack(MoreLadders.id("3d_ladders"), container,
                Text.literal("3D Ladders"), ResourcePackActivationType.NORMAL);
    }
}
