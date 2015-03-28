package com.whammich.roadblock.utils;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

public class Utils {

	public static String capitalizeFirstLetter(String entry) {
		return Character.toUpperCase(entry.charAt(0)) + entry.substring(1);
	}

	public static Block findBlockUnderEntity(Entity parEntity) {
		int blockX = MathHelper.floor_double(parEntity.posX);
		int blockY = MathHelper.floor_double(parEntity.boundingBox.minY)
				- (int) 1;
		int blockZ = MathHelper.floor_double(parEntity.posZ);
		return parEntity.worldObj.getBlock(blockX, blockY, blockZ);
	}

	public static void safeRegister(String name, ItemStack stack) {
		if (!isRegistered(stack, OreDictionary.getOres(name)))
			OreDictionary.registerOre(name, stack);
	}

	private static boolean isRegistered(ItemStack stack,
			ArrayList<ItemStack> toCheck) {
		for (ItemStack check : toCheck) {
			if (stack != null
					&& stack.getItem() == check.getItem()
					&& (stack.getItemDamage() == check.getItemDamage() || stack
							.getItemDamage() == OreDictionary.WILDCARD_VALUE)) {
				return true;
			}
		}
		return false;
	}

}