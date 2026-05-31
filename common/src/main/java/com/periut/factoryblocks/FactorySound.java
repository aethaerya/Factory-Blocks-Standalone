package com.periut.factoryblocks;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class FactorySound
{
    public static final Identifier METAL_BLOCK_SOUND = Identifier.fromNamespaceAndPath(FactoryBlocksMod.MODID,"metal_sound");
    public static SoundEvent METAL_SOUND_EVENT = SoundEvent.createVariableRangeEvent(METAL_BLOCK_SOUND);
    public static SoundType FACTORY_BLOCKS = new SoundType(1.0F, 1.0F, METAL_SOUND_EVENT, METAL_SOUND_EVENT, METAL_SOUND_EVENT, METAL_SOUND_EVENT, METAL_SOUND_EVENT);
}
