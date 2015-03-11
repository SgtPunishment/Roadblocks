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

import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.RoadTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRoad extends Block {

	public String name;
	public String texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon side;
	public IIcon bottom;
	public IIcon slab;

	public BlockRoad(Material material, String blockName, String blockTexture,
			SoundType stepsound) {
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
		setBlockBounds(0F, 0F, 0F, 1F, 15F / 16F, 1F);
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
				setBlockBounds(0F, 0F, 0F, 1F, 15F / 16F, 1F);
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
		if (texture == "default") {
			if (side == 1) {
				return this.top;
			} else {

			}

		} else if (texture == "podzol") {
			if (meta == 0) {
				if (side == 1) {
					return this.top;
				} else if (side == 0) {
					return this.bottom;
				} else {

				}
			}
			if (meta == 1) {
				if (side == 1) {
					return this.top;
				} else if (side == 0) {
					return this.bottom;
				} else if (side != 1 && side != 0) {
					return this.slab;
				}
			}

		} else if (texture == "compressedcobble") {
			if (meta == 0) {
				return blockIcon;
			}
			if (meta == 1) {
				if (side == 1 && side == 0) {
					return blockIcon;
				} else if (side != 1 && side != 0) {
					return this.slab;
				}
			}

		} else if (texture == "stonebrick_carved") {
			if (meta == 0) {
				return blockIcon;
			}

			if (meta == 1) {
				if (side == 1 && side == 0) {
					return blockIcon;
				} else if (side != 1 && side != 0) {
					return this.slab;
				}
			}
		} else if (texture == "quartz_block_lines_top") {
			if (meta == 0) {
				return blockIcon;
			}

			if (meta == 1) {
				if (side == 1 && side == 0) {
					return blockIcon;
				} else if (side != 1 && side != 0) {
					return this.slab;
				}
			}
		} else if (texture == "stone_slab_top") {
			if (meta == 0) {
				return blockIcon;
			}

			if (meta == 1) {
				if (side == 1 && side == 0) {
					return blockIcon;
				} else if (side != 1 && side != 0) {
					return this.slab;
				}
			}
		} else if (texture == "smoothDirt") {
			return blockIcon;
		}

		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		if (texture == "default") {
			this.top = register.registerIcon(Reference.modid + ":default");
			this.blockIcon = register.registerIcon("stonebrick");

		} else if (texture == "smoothDirt") {
			this.blockIcon = register.registerIcon(Reference.modid
					+ ":smoothdirt");
		} else if (texture == "podzol") {
			this.top = register.registerIcon("dirt_podzol_top");
			this.blockIcon = register.registerIcon("dirt_podzol_side");
			this.bottom = register.registerIcon("dirt");
			this.slab = register.registerIcon(Reference.modid + ":podzol_slab");

		} else if (texture == "compressedcobble") {
			this.blockIcon = register.registerIcon("furnace_top");
			this.slab = register.registerIcon(Reference.modid
					+ ":compressedslab");

		} else if (texture == "stonebrick_carved") {
			this.blockIcon = register.registerIcon("stonebrick_carved");
			this.slab = register
					.registerIcon(Reference.modid + ":chiseledslab");

		} else if (texture == "quartz_block_lines_top") {
			this.blockIcon = register.registerIcon("quartz_block_lines_top");
			this.slab = register.registerIcon("quartz_block_lines");

		} else if (texture == "stone_slab_top") {
			this.blockIcon = register.registerIcon("stone_slab_top");
			this.slab = register.registerIcon(Reference.modid
					+ ":stoneslabside");

		} else {
			this.blockIcon = register.registerIcon(texture);
		}
	}

}