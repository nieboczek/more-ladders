package boczek.moreladders.block;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Supplier;

public class OxidizableLadder extends LadderBlock implements Oxidizable {
    // TODO: Give an achievement for waxing if player doesn't have already
    // TODO: Spawn particles when waxing/unwaxing & play a sound

    private final OxidationLevel oxidationLevel;
    private static final Supplier<HashMap<Block, Block>> oxidationIncrease = Suppliers.memoize(() -> {
        HashMap<Block, Block> hashMap = new HashMap<>();
        hashMap.put(BlockLadders.COPPER_LADDER, BlockLadders.EXPOSED_COPPER_LADDER);
        hashMap.put(BlockLadders.EXPOSED_COPPER_LADDER, BlockLadders.WEATHERED_COPPER_LADDER);
        hashMap.put(BlockLadders.WEATHERED_COPPER_LADDER, BlockLadders.OXIDIZED_COPPER_LADDER);
        return hashMap;
    });
    private static final Supplier<HashMap<Block, Block>> oxidationDecrease = Suppliers.memoize(() -> {
        HashMap<Block, Block> hashMap = new HashMap<>();
        hashMap.put(BlockLadders.OXIDIZED_COPPER_LADDER, BlockLadders.WEATHERED_COPPER_LADDER);
        hashMap.put(BlockLadders.WEATHERED_COPPER_LADDER, BlockLadders.EXPOSED_COPPER_LADDER);
        hashMap.put(BlockLadders.EXPOSED_COPPER_LADDER, BlockLadders.COPPER_LADDER);
        return hashMap;
    });
    private static final Supplier<HashMap<Block, Block>> waxing = Suppliers.memoize(() -> {
        HashMap<Block, Block> hashMap = new HashMap<>();
        hashMap.put(BlockLadders.COPPER_LADDER, BlockLadders.WAXED_COPPER_LADDER);
        hashMap.put(BlockLadders.EXPOSED_COPPER_LADDER, BlockLadders.WAXED_EXPOSED_COPPER_LADDER);
        hashMap.put(BlockLadders.WEATHERED_COPPER_LADDER, BlockLadders.WAXED_WEATHERED_COPPER_LADDER);
        hashMap.put(BlockLadders.OXIDIZED_COPPER_LADDER, BlockLadders.WAXED_OXIDIZED_COPPER_LADDER);
        return hashMap;
    });
    private static final Supplier<HashMap<Block, Block>> unwaxing = Suppliers.memoize(() -> {
        HashMap<Block, Block> hashMap = new HashMap<>();
        hashMap.put(BlockLadders.WAXED_COPPER_LADDER, BlockLadders.COPPER_LADDER);
        hashMap.put(BlockLadders.WAXED_EXPOSED_COPPER_LADDER, BlockLadders.EXPOSED_COPPER_LADDER);
        hashMap.put(BlockLadders.WAXED_WEATHERED_COPPER_LADDER, BlockLadders.WEATHERED_COPPER_LADDER);
        hashMap.put(BlockLadders.WAXED_OXIDIZED_COPPER_LADDER, BlockLadders.OXIDIZED_COPPER_LADDER);
        return hashMap;
    });

    public OxidizableLadder(Settings settings, Oxidizable.OxidationLevel level) {
        super(settings.ticksRandomly());
        oxidationLevel = level;
    }

    public OxidizableLadder(Settings settings, Oxidizable.OxidationLevel level, boolean waxed) {
        super(settings);
        oxidationLevel = level;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.swingHand(hand);
        Item item = player.getStackInHand(hand).getItem();
        if (item instanceof AxeItem) {
            Optional<Block> decreasedBlock = getDecreasedOxidationBlock(state.getBlock());
            Optional<Block> unwaxedBlock = getUnwaxedVariant(state.getBlock());
            if (decreasedBlock.isPresent()) {
                world.setBlockState(pos, decreasedBlock.get().getDefaultState().with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING)));
                return ActionResult.CONSUME_PARTIAL;
            } else if (unwaxedBlock.isPresent()) {
                world.setBlockState(pos, unwaxedBlock.get().getDefaultState().with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING)));
                return ActionResult.CONSUME_PARTIAL;
            }
            return ActionResult.FAIL;
        } else if (item instanceof HoneycombItem) {
            Optional<Block> waxedBlock = getWaxedVariant(state.getBlock());
            if (waxedBlock.isPresent()) {
                world.setBlockState(pos, waxedBlock.get().getDefaultState().with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING)));
                return ActionResult.CONSUME;
            }
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f = 0.05688889F;
        if (random.nextFloat() < 0.05688889F) {
            this.tryDegrade(state, world, pos, random).ifPresent((degraded) -> {
                world.setBlockState(pos, degraded);
            });
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    private Optional<Block> getWaxedVariant(Block block) {
        return Optional.ofNullable(waxing.get().get(block));
    }

    private Optional<Block> getUnwaxedVariant(Block block) {
        return Optional.ofNullable(unwaxing.get().get(block));
    }

    @Override
    public Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).map((block) -> block.getStateWithProperties(state));
    }

    public static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable(oxidationDecrease.get().get(block));
    }

    public static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable(oxidationIncrease.get().get(block));
    }
}
