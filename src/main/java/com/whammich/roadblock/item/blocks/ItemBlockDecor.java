package com.whammich.roadblock.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecor extends ItemBlock {
	String[] names = { "dirt.worn" };

	public ItemBlockDecor(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "." + names[stack.getItemDamage() % names.length];
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
