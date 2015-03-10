package com.whammich.roadblock.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RoadTabs {

	private static class CustomCreativeTab extends CreativeTabs {

		public CustomCreativeTab(String lable) {
			super(lable);
			// TODO Auto-generated constructor stub
		}

		private ItemStack stack;

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return stack.getItem();
		}

		public void setTabIconItemStack(ItemStack stack) {
			this.stack = stack;
		}

		@Override
		public ItemStack getIconItemStack() {
			return stack;
		}

	}

	public static final CustomCreativeTab tabRoad = new CustomCreativeTab(
			"tabRoad");

	public static void postInit() {
		tabRoad.setTabIconItemStack(new ItemStack(Register.diamondMallet));
	}
}
