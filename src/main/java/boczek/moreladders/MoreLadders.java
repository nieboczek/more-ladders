package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import boczek.moreladders.compat.biomesoplenty.BiomesOPlentyBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";
    public static final Logger LOGGER = LoggerFactory.getLogger("MoreLadders");

    @Override
    public void onInitialize() {
        ModBlocks.initialize();

        if (FabricLoader.getInstance().isModLoaded("biomesoplenty")) {
            LOGGER.info("Found biomesoplenty, initializing compatibility class");
            BiomesOPlentyBlocks.initialize();
        }

        MoreLaddersGroup.initialize();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
