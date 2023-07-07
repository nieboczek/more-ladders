package boczek.moreladders.data;

import boczek.moreladders.MoreLadders;
import boczek.moreladders.block.BlockLadders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(BlockLadders.BIRCH_LADDER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // no
    }
}
