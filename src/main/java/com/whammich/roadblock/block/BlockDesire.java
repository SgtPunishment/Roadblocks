package com.whammich.roadblock.block;

import java.util.List;

import com.whammich.roadblock.Roadblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.whammich.roadblock.renderer.CTM;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.CreativeTabRoadblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDesire extends Block {

	private final String name = "Grassroad";
	public CTM CTM;
	@SideOnly(Side.CLIENT)
	public IIcon icon;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockDesire() {
		super(Material.grass);

		GameRegistry.registerBlock(this, name).setStepSound(
				Block.soundTypeGrass);
		setBlockName(name);
		setCreativeTab(Roadblock.tabRoadblocks);
		setLightOpacity(0);
		useNeighborBrightness = true;
		setHardness(1.5F);
		CTM = new CTM();
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y,
			int z) {
		int meta = world.getBlockMetadata(x, y, z);

		Block blockAbove = world.getBlock(x, y + 1, z);
		if (!blockAbove.isAir(world, x, y + 1, z)) {
			setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		} else {
			if (meta == 0) {
				setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
			} else {
				setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
			}
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
	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		int tex = com.whammich.roadblock.renderer.CTM.getTex(world, x, y, z,
				side);
		return icons[tex];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[59];
		for (int i = 0; i < icons.length; ++i) {
			this.icons[i] = iconRegister.registerIcon(Reference.modid
					+ ":desirepath/" + i);
		}
	}
}