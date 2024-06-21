package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";
    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        MoreLaddersGroup.initialize();
    }
}
