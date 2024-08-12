package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import boczek.moreladders.compat.biomesoplenty.BiomesOPlenty;
import boczek.moreladders.compat.blockus.Blockus;
import boczek.moreladders.compat.regionsunexplored.RegionsUnexplored;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";
    public static final Logger LOGGER = LoggerFactory.getLogger("MoreLadders");
    public static boolean BIOMESOPLENTY_PRESENT = false;
    public static boolean BLOCKUS_PRESENT = false;
    public static boolean REGIONSUNEXPLORED_PRESENT = false;

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        BIOMESOPLENTY_PRESENT = FabricLoader.getInstance().isModLoaded("biomesoplenty");
        BLOCKUS_PRESENT = FabricLoader.getInstance().isModLoaded("blockus");
        REGIONSUNEXPLORED_PRESENT = FabricLoader.getInstance().isModLoaded("regions_unexplored");

        if (BIOMESOPLENTY_PRESENT) {
            LOGGER.info("Found Biomes O' Plenty, initializing compatibility class");
            BiomesOPlenty.initialize();
        }
        if (BLOCKUS_PRESENT) {
            LOGGER.info("Found Blockus, initializing compatibility class");
            Blockus.initialize();
        }
        if (REGIONSUNEXPLORED_PRESENT) {
            LOGGER.info("Found Regions Unexplored, initializing compatibility class");
            RegionsUnexplored.initialize();
        }
        MoreLaddersGroup.initialize();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
