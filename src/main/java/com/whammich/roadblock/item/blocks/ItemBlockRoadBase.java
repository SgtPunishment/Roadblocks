package com.whammich.roadblock.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.whammich.roadblock.block.BlockRoadBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockRoadBase extends ItemBlock {

	public ItemBlockRoadBase(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		BlockRoadBase block = (BlockRoadBase) Block.getBlockFromItem(stack.getItem());
		return String.format(StatCollector.translateToLocal("tile.roadblock.road.name"), block.getDisplayName());
		
	}
}
