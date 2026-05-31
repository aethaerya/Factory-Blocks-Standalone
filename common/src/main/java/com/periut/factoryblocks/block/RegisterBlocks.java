package com.periut.factoryblocks.block;

import com.periut.factoryblocks.TooltipBlockItem;
import com.periut.factoryblocks.block.fan.BaseFanBlock;
import com.periut.factoryblocks.block.fan.MediumFanBlock;
import com.periut.factoryblocks.block.fan.RedstoneFanBlock;
import com.periut.factoryblocks.platform.RegistryHelper;
import java.util.ArrayList;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static com.periut.factoryblocks.FactoryBlocksMod.MODID;

public class RegisterBlocks
{
    enum Type {
        base,
        baseFan,
        redFan,
        mediumFan
    }

    private static void addFactoryBlock(String nameID, Type type)
    {
        addFactoryBlock(nameID, type,true);
    }

    public static ArrayList<Supplier<Item>> itemSuppliers = new ArrayList<>();

    private static void addFactoryBlock(String nameID, Type type, boolean include)
    {
        Identifier blockID = Identifier.fromNamespaceAndPath(MODID, nameID);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, blockID);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockID);

        Supplier<Block> blockSupplier;

        switch (type) {
            default -> blockSupplier = RegistryHelper.registerBlock(blockID, blockKey, () -> new BaseFactoryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(blockKey)));
            case baseFan -> blockSupplier = RegistryHelper.registerBlock(blockID, blockKey, () -> new BaseFanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(blockKey)));
            case redFan -> blockSupplier = RegistryHelper.registerBlock(blockID, blockKey, () -> new RedstoneFanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(blockKey)));
            case mediumFan -> blockSupplier = RegistryHelper.registerBlock(blockID, blockKey, () -> new MediumFanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(blockKey)));
        }

        Supplier<Item> itemSupplier = RegistryHelper.registerItem(blockID, itemKey, () -> new TooltipBlockItem(blockSupplier.get(), new Item.Properties().setId(itemKey), nameID + ".tooltip"));
        itemSuppliers.add(itemSupplier);
    }

    public static void registerItemGroups() {
        for (Supplier<Item> itemSupplier : itemSuppliers) {
            RegistryHelper.addToItemGroup(ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.withDefaultNamespace("building_blocks")), itemSupplier.get());
        }
    }

    public static void register()
    {
        addFactoryBlock("factory", Type.base);
        addFactoryBlock("rust", Type.base);
        addFactoryBlock("vrust", Type.base);
        addFactoryBlock("srust", Type.base);
        addFactoryBlock("wireframe", Type.base);
        addFactoryBlock("pwireframe", Type.base);
        addFactoryBlock("hazard", Type.base);
        addFactoryBlock("hazardo", Type.base);
        addFactoryBlock("circuit", Type.base);
        addFactoryBlock("metalbox", Type.base);
        addFactoryBlock("gcircuit", Type.base);
        addFactoryBlock("pgcircuit", Type.base);
        addFactoryBlock("grinder", Type.base);
        addFactoryBlock("old_vents", Type.base);
        addFactoryBlock("rust_plates", Type.base);
        addFactoryBlock("bcircuit", Type.base);
        addFactoryBlock("ice", Type.base);
        addFactoryBlock("mosaic", Type.base);
        addFactoryBlock("bwireframe", Type.base);
        addFactoryBlock("rusty_scaffold", Type.base);
        addFactoryBlock("caution", Type.base);
        addFactoryBlock("large_pipes", Type.base);
        addFactoryBlock("small_pipes", Type.base);
        addFactoryBlock("vent", Type.base);
        addFactoryBlock("gvent", Type.base);
        addFactoryBlock("insulation", Type.base);
        addFactoryBlock("gears", Type.base);
        addFactoryBlock("cables", Type.base);
        addFactoryBlock("rust_bplates", Type.base);
        addFactoryBlock("grate", Type.base);
        addFactoryBlock("rgrate", Type.base);
        addFactoryBlock("hex", Type.base);
        addFactoryBlock("wgpanel", Type.base);
        addFactoryBlock("wopanel", Type.base);
        addFactoryBlock("sturdy", Type.base);
        addFactoryBlock("megacell", Type.base);
        addFactoryBlock("exhaust", Type.base);
        addFactoryBlock("engineer", Type.base);
        addFactoryBlock("scaffold", Type.base);
        addFactoryBlock("piping", Type.base);
        addFactoryBlock("large_plating", Type.base);
        addFactoryBlock("fan_side", Type.base);

        addFactoryBlock("fan_on", Type.baseFan);
        addFactoryBlock("fan_four_on", Type.baseFan);
        addFactoryBlock("fan_malfunction_on", Type.baseFan);

        addFactoryBlock("fan", Type.redFan);
        addFactoryBlock("fan_four", Type.redFan);
        addFactoryBlock("fan_malfunction", Type.redFan);

        addFactoryBlock("medium_fan", Type.mediumFan, false);
    }
}
