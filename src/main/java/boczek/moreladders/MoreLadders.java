package boczek.moreladders;

import boczek.moreladders.block.BlockLadders;
import boczek.moreladders.item.MoreLaddersGroup;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreLadders implements ModInitializer {
    public static final String MOD_ID = "moreladders";
    public static final Logger LOGGER = LoggerFactory.getLogger("MoreLadders");
    @Override
    public void onInitialize() {
        BlockLadders.registerModBlocks();
        MoreLaddersGroup.load();
    }
}
