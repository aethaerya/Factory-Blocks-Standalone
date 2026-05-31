package com.periut.factoryblocks.platform;

import com.periut.factoryblocks.platform.services.RegistryHelperService;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class RegistryHelper {
    private static final RegistryHelperService SERVICE = Services.load(RegistryHelperService.class);

    public static <T extends Block> Supplier<T> registerBlock(Identifier id, ResourceKey<Block> key, Supplier<T> block) {
        return SERVICE.registerBlock(id, key, block);
    }

    public static <T extends Item> Supplier<T> registerItem(Identifier id, ResourceKey<Item> key, Supplier<T> item) {
        return SERVICE.registerItem(id, key, item);
    }

    public static void addToItemGroup(ResourceKey<CreativeModeTab> group, Item item) {
        SERVICE.addToItemGroup(group, item);
    }

    public static void initialize() {
        SERVICE.initialize();
    }
}
