package boczek.moreladders.data;

import boczek.moreladders.MoreLadders;
import boczek.moreladders.block.BlockLadders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.util.Identifier;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    protected ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // pls fix soon
    }
}
