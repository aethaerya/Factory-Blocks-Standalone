package com.periut.factoryblocks.block.fan;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class RedstoneFanBlock extends BaseFanBlock
{
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public RedstoneFanBlock(Properties settings)
    {
        super(settings);
        registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(ON, false));
    }

    public void neighborUpdate(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify)
    {
        if (!world.isClientSide())
        {
            if (world.hasNeighborSignal(pos))
            {
                world.setBlockAndUpdate(pos, state.setValue(ON, true));
            }
            else
            {
                world.setBlockAndUpdate(pos, state.setValue(ON, false));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
        builder.add(ON);
    }
}
