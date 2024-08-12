package boczek.moreladders;

import boczek.moreladders.block.ModBlocks;
import boczek.moreladders.compat.biomesoplenty.BiomesOPlenty;
import boczek.moreladders.compat.blockus.Blockus;
import boczek.moreladders.compat.regionsunexplored.RegionsUnexplored;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class MoreLaddersGroup {
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, MoreLadders.id("more-ladders"), FabricItemGroup.builder()
                .displayName(Text.literal("More Ladders")).icon(() -> new ItemStack(ModBlocks.SPRUCE_LADDER))
                        .entries((displayContext, entries) -> {
                            ModBlocks.blocks.forEach(entries::add);
                            if (MoreLadders.BIOMESOPLENTY_PRESENT) {
                                BiomesOPlenty.blocks.forEach(entries::add);
                            }
                            if (MoreLadders.BLOCKUS_PRESENT) {
                                Blockus.blocks.forEach(entries::add);
                            }
                            if (MoreLadders.REGIONSUNEXPLORED_PRESENT) {
                                RegionsUnexplored.blocks.forEach(entries::add);
                            }
                        }).build());
    }
}
