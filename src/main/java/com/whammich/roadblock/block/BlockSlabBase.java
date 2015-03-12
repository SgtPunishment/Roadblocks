package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.LogHelper;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlabBase extends BlockSlab {

	int speed;
	private Block block = null;
	int blockMeta = 0;
	public final boolean field_150004_a;

	/**
	 *
	 * @param unlocName
	 *            - Unlocalized name to give to the block. Gets prefixed with
	 *            the modid and suffixed with ".roadblock"
	 * @param textureName
	 *            - Name of the texture to use for the block
	 * @param material
	 *            - Material of the block
	 * @param soundType
	 *            - Sound type of the block
	 */
	public BlockSlabBase(boolean p_i45410_1_, String unlocName,
			String textureName, Material material, SoundType soundType) {
		super(p_i45410_1_, material);
		this.field_150004_a = p_i45410_1_;
		setBlockName(Reference.modid + "." + unlocName + ".roadslab");
		setBlockTextureName(textureName);
		setCreativeTab(Roadblock.tabRoadblocks);
		setStepSound(soundType);
		setHardness(1.5F);

		LogHelper
				.info("Registering road slab with name: " + getLocalizedName());
	}

	/**
	 *
	 * @param block
	 *            - Block to get Name, Texture, and Material from
	 * @param blockMeta
	 *            - Meta of the block to get Name, Texture, and Material from
	 * @param soundType
	 *            - Soundtype of the roadblock
	 */
	public BlockSlabBase(boolean p_i45410_1_, Block block, int blockMeta,
			SoundType soundType) {
		super(p_i45410_1_, block.getMaterial());

		this.field_150004_a = p_i45410_1_;
		setBlockName(Reference.modid + ".roadslab");
		setCreativeTab(Roadblock.tabRoadblocks);
		setStepSound(soundType);
		setHardness(1.5F);

		this.block = block;
		this.blockMeta = blockMeta;

		LogHelper.info("Registering road slab for block: "
				+ block.getLocalizedName());
		ItemStack blockStack = new ItemStack(block, 1, blockMeta);

		GameRegistry.registerBlock(this, "SlabRoad"
				+ blockStack.getDisplayName().replaceAll(" ", ""));
	}

	@Override
	public String getUnlocalizedName() {
		if (block != null) {
			ItemStack blockStack = new ItemStack(block, 1, blockMeta);
			return String.format(
					StatCollector.translateToLocal("tile.roadblock.slab.name"),
					blockStack.getDisplayName());
		}

		return super.getUnlocalizedName();
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
		setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
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
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.5, z + 1);
	}

	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.4375F, 1.0F);
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if (Utils.findBlockUnderEntity(entity) instanceof BlockSlabBase) {
			if (Config.speedOn) {
				if (entity instanceof EntityLivingBase) {
					if (Config.speed > 9) {
						speed = 9;
					} else {
						speed = Config.speed;
					}
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(
									Potion.moveSpeed.id, 20, speed));
				}
			}
		}
		// float speed = 2F;
		// float max = 0.4F;
		// double motionX = Math.abs(entity.motionX);
		// double motionZ = Math.abs(entity.motionZ);
		//
		// if (motionX < max)
		// entity.motionX *= speed;
		// if (motionZ < max)
		// entity.motionZ *= speed;
	}

	@Override
	public String func_150002_b(int p_150002_1_) {
		// TODO Auto-generated method stub
		return null;
	}
}