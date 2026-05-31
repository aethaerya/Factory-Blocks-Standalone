package com.periut.factoryblocks.optional;

import com.periut.chisel.block.ChiselGroupLookup;
import net.minecraft.resources.Identifier;

public class ChiselSupport {
    public static void addFactoryBlockToChisel(Identifier blockID)
    {
        try {
            ChiselGroupLookup.addItemToGroup("factory", blockID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
