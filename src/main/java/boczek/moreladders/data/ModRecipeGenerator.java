package boczek.moreladders.data;

import boczek.moreladders.MoreLadders;
import boczek.moreladders.block.BlockLadders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockLadders.BIRCH_LADDER)
                .input('#', Items.BIRCH_PLANKS)
                .pattern("")
                .pattern("# #")
                .pattern("# #")
                .criterion(FabricRecipeProvider.hasItem(BlockLadders.BIRCH_LADDER),
                        FabricRecipeProvider.conditionsFromItem(Items.BIRCH_PLANKS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(BlockLadders.BIRCH_LADDER)));
    }
}
