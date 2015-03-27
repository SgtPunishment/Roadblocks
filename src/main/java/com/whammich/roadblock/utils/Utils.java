package com.whammich.roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Utils {

	public static String capitalizeFirstLetter(String entry) {
		return Character.toUpperCase(entry.charAt(0)) + entry.substring(1);
	}

	public static Block findBlockUnderEntity(Entity parEntity) {
		int blockX = MathHelper.floor_double(parEntity.posX);
		int blockY = MathHelper.floor_double(parEntity.boundingBox.minY)- (int) 1;
		int blockZ = MathHelper.floor_double(parEntity.posZ);
		return parEntity.worldObj.getBlock(blockX, blockY, blockZ);
	}
}