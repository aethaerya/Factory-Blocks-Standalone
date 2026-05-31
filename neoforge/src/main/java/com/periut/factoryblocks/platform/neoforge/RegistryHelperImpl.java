package com.periut.factoryblocks.platform.neoforge;

import com.periut.factoryblocks.FactoryBlocksMod;
import com.periut.factoryblocks.platform.services.RegistryHelperService;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class RegistryHelperImpl implements RegistryHelperService {
    private static final List<DeferredRegister<?>> REGISTERS = new ArrayList<>();
    private static final Map<ResourceKey<CreativeModeTab>, List<Item>> ITEM_GROUP_ENTRIES = new HashMap<>();

    private static DeferredRegister.Blocks BLOCKS = null;
    private static DeferredRegister.Items ITEMS = null;

    @Override
    public <T extends Block> Supplier<T> registerBlock(Identifier id, ResourceKey<Block> key, Supplier<T> block) {
        if (BLOCKS == null) {
            BLOCKS = DeferredRegister.createBlocks(FactoryBlocksMod.MODID);
            REGISTERS.add(BLOCKS);
        }
        return BLOCKS.register(id.getPath(), block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(Identifier id, ResourceKey<Item> key, Supplier<T> item) {
        if (ITEMS == null) {
            ITEMS = DeferredRegister.createItems(FactoryBlocksMod.MODID);
            REGISTERS.add(ITEMS);
        }
        return ITEMS.register(id.getPath(), item);
    }

    @Override
    public void addToItemGroup(ResourceKey<CreativeModeTab> group, Item item) {
        // Items will be added via BuildCreativeModeTabContentsEvent in FactoryBlocksNeoforge
        ITEM_GROUP_ENTRIES.computeIfAbsent(group, k -> new ArrayList<>()).add(item);
    }

    @Override
    public void initialize() {
        // DeferredRegisters are registered in FactoryBlocksNeoforge
    }

    public static List<DeferredRegister<?>> getRegisters() {
        return REGISTERS;
    }

    public static Map<ResourceKey<CreativeModeTab>, List<Item>> getItemGroupEntries() {
        return ITEM_GROUP_ENTRIES;
    }
}
