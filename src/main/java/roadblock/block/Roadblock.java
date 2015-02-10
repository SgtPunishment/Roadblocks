package roadblock.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadblock.utils.Config;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Roadblock extends Block {

	private int speed;
	public String name;
	public String texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon podzol;
	public IIcon dirt;
	public Random rand;
	public float f = 0.125F;

	public Roadblock(Material material, String blockName, String blockTexture,
			SoundType stepsound) {
		super(material);
		name = blockName;
		texture = blockTexture;
		GameRegistry.registerBlock(this, name + "_roadblock").setStepSound(
				stepsound);
		setBlockName(name + "_roadblock");
		setCreativeTab(Register.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setHardness(1.5F);
		setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
	}

	private boolean isFullRoad(IBlockAccess type, int x, int y, int z) {
		Block block = type.getBlock(x, y, z);
		// add blocks here that wont make a road a full block
		return block == Blocks.fence_gate || block == Blocks.air
				|| block == Blocks.torch;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y,
			int z) {
		boolean airabove = this.isFullRoad(block, x, y + 1, z);
		float f4 = 0.9375F;

		if (airabove) {
			f4 = 0.4375F;
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
	}

	public void onBlockClicked(World world, int xCoord, int yCoord, int zCoord,
			EntityPlayer player) {
		// TODO Figure out player right click with item to change block / model
		// state
		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem();
			if (stack != null && stack.getItem() == Register.ironMallet) {
				if (world.getBlock(xCoord, yCoord, zCoord).getBlockBoundsMaxY() == 0.9375F) {
					world.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0F,
							0F, 0F, 1F, 0.4375F, 1F);
					System.out.println("Set to Half");
					// stack.damageItem(1, player);
				}

				if (world.getBlock(xCoord, yCoord, zCoord).getBlockBoundsMaxY() == 0.4375F) {
					world.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0F,
							0F, 0F, 1F, 0.9375F, 1F);
					System.out.println("Set to Full");
					// stack.damageItem(1, player);
				}
			} else {

			}
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord,
			int zCoord, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			if (Config.speed > 9) {
				speed = 9;
			} else {
				speed = Config.speed;
			}
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
					Potion.moveSpeed.id, 0, speed));
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (texture == "default") {
			if (side == 1) {
				return this.top;
			} else {

			}
		} else if (texture == "podzol") {
			if (side == 1) {
				return this.podzol;
			} else if (side == 0) {
				return this.dirt;
			} else {

			}
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		if (texture == "default") {
			this.top = register.registerIcon("roadblock:default");
			this.blockIcon = register.registerIcon("stonebrick");
		} else if (texture == "podzol") {
			this.podzol = register.registerIcon("dirt_podzol_top");
			this.blockIcon = register.registerIcon("dirt_podzol_side");
			this.dirt = register.registerIcon("dirt");
		} else {
			this.blockIcon = register.registerIcon(texture);
		}
	}

}