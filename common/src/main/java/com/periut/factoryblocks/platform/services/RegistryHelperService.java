package com.periut.factoryblocks.platform.services;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface RegistryHelperService {
    <T extends Block> Supplier<T> registerBlock(Identifier id, ResourceKey<Block> key, Supplier<T> block);

    <T extends Item> Supplier<T> registerItem(Identifier id, ResourceKey<Item> key, Supplier<T> item);

    void addToItemGroup(ResourceKey<CreativeModeTab> group, Item item);

    void initialize();
}
