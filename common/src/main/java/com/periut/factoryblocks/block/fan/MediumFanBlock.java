package com.periut.factoryblocks.block.fan;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MediumFanBlock extends BaseFanBlock
{
    public MediumFanBlock(Properties settings)
    {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ctx) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return Shapes.box(0.0f, 0.0f, 0.0f, 2.0f, 2.0f, 1.0f);
            case EAST:
            case WEST:
                return Shapes.box(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 2.0f);
            default:
                return Shapes.box(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 2.0f);
        }
    }
}
