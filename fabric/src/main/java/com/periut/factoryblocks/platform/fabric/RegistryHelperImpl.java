package com.periut.factoryblocks.platform.fabric;

import com.periut.factoryblocks.platform.services.RegistryHelperService;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class RegistryHelperImpl implements RegistryHelperService {

    @Override
    public <T extends Block> Supplier<T> registerBlock(Identifier id, ResourceKey<Block> key, Supplier<T> block) {
        T registeredBlock = Registry.register(BuiltInRegistries.BLOCK, id, block.get());
        return () -> registeredBlock;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(Identifier id, ResourceKey<Item> key, Supplier<T> item) {
        T registeredItem = Registry.register(BuiltInRegistries.ITEM, id, item.get());
        return () -> registeredItem;
    }

    @Override
    public void addToItemGroup(ResourceKey<CreativeModeTab> group, Item item) {
        CreativeModeTabEvents.modifyOutputEvent(group).register(entries -> entries.accept(item));
    }

    @Override
    public void initialize() {
        // Fabric doesn't require explicit initialization
    }
}
