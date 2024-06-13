package boczek.moreladders;

import boczek.moreladders.block.BlockLadders;
import boczek.moreladders.item.MoreLaddersGroup;
import net.fabricmc.api.ModInitializer;

public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";

    @Override
    public void onInitialize() {
        BlockLadders.initialize();
        MoreLaddersGroup.initialize();
    }
}
