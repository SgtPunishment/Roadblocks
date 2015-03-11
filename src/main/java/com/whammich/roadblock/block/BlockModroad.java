package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import vazkii.botania.common.lib.LibMisc;

import com.cricketcraft.chisel.Chisel;
import com.whammich.roadblock.utils.RoadTabs;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModroad extends Block {
	public String name;
	public String texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon side;
	public IIcon bottom;
	public IIcon slab;

	public BlockModroad(Material material, String blockName,
			String blockTexture, SoundType stepsound) {
		super(material);
		name = blockName;
		texture = blockTexture;
		GameRegistry.registerBlock(this, name + "_roadblock").setStepSound(
				stepsound);
		setBlockName(name + "_roadblock");
		setCreativeTab(RoadTabs.tabRoad);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setHardness(1.5F);
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

	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (Loader.isModLoaded("chisel")) {
			if (texture == "wireframe") {
				return blockIcon;
			} else if (texture == "wireframewhite") {
				return blockIcon;
			} else if (texture == "paver") {
				return blockIcon;
			}
		}
		if (Loader.isModLoaded("Botania")) {
			if (texture == "") {
				return blockIcon;
			} else if (texture == "") {
				return blockIcon;
			}
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {

		if (Loader.isModLoaded("chisel")) {
			if (texture == "wireframe") {
				this.blockIcon = register.registerIcon(Chisel.MOD_ID
						+ ":factory/wireframe");

			} else if (texture == "wireframewhite") {
				this.blockIcon = register.registerIcon(Chisel.MOD_ID
						+ ":factory/wireframewhite");

			} else if (texture == "paver") {
				this.blockIcon = register
						.registerIcon(Chisel.MOD_ID + ":paver");
			}
		}

		if (Loader.isModLoaded("Botania")) {
			if (texture == "") {
				this.blockIcon = register.registerIcon(LibMisc.MOD_ID
						+ ":prismarine01");

			} else if (texture == "") {
				this.blockIcon = register.registerIcon(LibMisc.MOD_ID
						+ ":prismarine03");

			}
		} else {
			this.blockIcon = register.registerIcon(texture);
		}
	}

}