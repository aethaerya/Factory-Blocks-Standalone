package com.periut.factoryblocks;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

public class TooltipBlockItem extends BlockItem
{
    String customTooltip;
    boolean debug = false;
    public TooltipBlockItem(Block block, Properties settings, String tooltip)
    {
        super(block, settings);
        customTooltip = tooltip;
    }

    public void debugMode()
    {
        debug = true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        textConsumer.accept(Component.translatable("item." + FactoryBlocksMod.MODID + "." + customTooltip).withStyle(ChatFormatting.GRAY));
        if (debug)
        {
            textConsumer.accept(Component.translatable("item." + FactoryBlocksMod.MODID + ".debug").withStyle(ChatFormatting.RED));
        }
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
    }
}
