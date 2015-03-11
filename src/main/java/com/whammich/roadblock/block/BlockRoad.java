package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.RoadTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRoad extends BlockRoadBase {

	int blockMeta = 0;

	public BlockRoad(String unlocName, String textureName,
			Material material, SoundType soundType) {
		super(material);

	}

	public BlockRoad(Block block, int blockMeta, SoundType soundType) {
		super(block.getMaterial());

	}
}