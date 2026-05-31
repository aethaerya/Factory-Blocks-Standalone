package com.periut.factoryblocks.block;

import static com.periut.factoryblocks.FactorySound.FACTORY_BLOCKS;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class BaseFactoryBlock extends Block
{
    public static final BooleanProperty ON = BooleanProperty.create("on");
    public BaseFactoryBlock(Properties settings)
    {
        super(settings.strength(2.0f).sound(FACTORY_BLOCKS));
    }
}
