package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        MoreLaddersGroup.initialize();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
