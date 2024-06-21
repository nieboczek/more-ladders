package boczek.moreladders.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableLadder extends LadderBlock implements Oxidizable {
    private final OxidationLevel oxidationLevel;

    public OxidizableLadder(Settings settings, Oxidizable.OxidationLevel level) {
        super(settings.ticksRandomly());
        oxidationLevel = level;
    }

    public OxidizableLadder(Settings settings, Oxidizable.OxidationLevel level, boolean _waxed) {
        super(settings);
        oxidationLevel = level;
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // for some reason this.tickDegradation doesn't work, so I stole the source code
        if (random.nextFloat() < 0.05688889F) {
            this.tryDegrade(state, world, pos, random).ifPresent((degraded) -> {
                world.setBlockState(pos, degraded);
            });
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }
}
