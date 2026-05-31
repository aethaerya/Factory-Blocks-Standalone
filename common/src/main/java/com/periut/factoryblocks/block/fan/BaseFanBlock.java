package com.periut.factoryblocks.block.fan;

import com.periut.factoryblocks.block.BaseFactoryBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class BaseFanBlock extends BaseFactoryBlock
{
    public BaseFanBlock(Properties settings)
    {
        super(settings);
        registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        try {
            return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getNearestLookingDirection().getOpposite());
        } catch (Exception e) {
            // idk why this happens gg
            return this.defaultBlockState();
        }
    }
}
