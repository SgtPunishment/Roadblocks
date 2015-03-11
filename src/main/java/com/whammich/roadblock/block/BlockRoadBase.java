package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.RoadTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRoadBase extends Block {

	private Block block = null;
	int blockMeta = 0;

	public BlockRoadBase(String unlocName, String textureName,
			Material material, SoundType soundType) {
		super(material);

		setBlockName(Reference.modid + "." + unlocName + ".roadblock");
		setBlockTextureName(textureName);
		setCreativeTab(RoadTabs.tabRoad);
		setStepSound(soundType);
		setHardness(1.5F);
	}

	public BlockRoadBase(Block block, int blockMeta, SoundType soundType) {
		super(block.getMaterial());

		setBlockName(Reference.modid + ".road");
		setCreativeTab(RoadTabs.tabRoad);
		setStepSound(soundType);
		setHardness(1.5F);

		this.block = block;
		this.blockMeta = blockMeta;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (block != null)
			return block.getIcon(side, blockMeta);
		else
			return blockIcon;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y,
			int z) {

		int meta = world.getBlockMetadata(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);

		if (!blockAbove.isAir(world, x, y + 1, z))
			setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		else {
			if (meta == 0)
				setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
			else
				setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public void addCollisionBoxesToList(World world, int x, int y, int z,
			AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list,
				entity);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}

	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		float speed = 2F;
		float max = 0.4F;
		double motionX = Math.abs(entity.motionX);
		double motionZ = Math.abs(entity.motionZ);
		if (motionX < max)
			entity.motionX *= speed;
		if (motionZ < max)
			entity.motionZ *= speed;
	}

	@Override
	public String getLocalizedName() {

		if (block != null) {
			ItemStack blockStack = new ItemStack(block, 1, blockMeta);

			return blockStack.getDisplayName() + " "
					+ StatCollector.translateToLocal("info.roadblock.title");
		}

		return super.getLocalizedName();
	}
}