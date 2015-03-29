package com.whammich.roadblock.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabRoadblocks extends CreativeTabs {

    public CreativeTabRoadblocks(String tabLabel) {
        super(tabLabel);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Register.ironMallet);
    }

    @Override
    public Item getTabIconItem() {
        return new Item();
    }
}
