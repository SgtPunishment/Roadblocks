package roadblock.block;

import java.util.List;

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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadblock.utils.Config;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Grassroad extends Block {

	private int speed;
	private final String name = "Grassroad";
	@SideOnly(Side.CLIENT)
	public IIcon top;
	@SideOnly(Side.CLIENT)
	public IIcon top_overlay;
	@SideOnly(Side.CLIENT)
	public IIcon side_overlay;

	public Grassroad() {
		super(Material.grass);

		GameRegistry.registerBlock(this, name).setStepSound(
				Block.soundTypeGrass);
		setBlockName(name);
		setCreativeTab(Register.tabRoadBlock);
		setLightOpacity(0);
		useNeighborBrightness = true;
		setHardness(1.5F);
	}

	@Override
	public int getRenderType() {
		return Register.grassRoadRenderType;

	}

	@Override
	public boolean canRenderInPass(int pass) {
		// Set the static var in the client proxy
		Register.renderPass = pass;
		// the block can render in both passes, so return true always
		return true;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	private boolean isFullRoad(IBlockAccess type, int x, int y, int z) {
		Block block = type.getBlock(x, y, z);
		// add blocks here that wont make a road a full block
		return block == Blocks.fence_gate || block == Blocks.air
				|| block == Blocks.torch;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y,
			int z) {
		int meta = block.getBlockMetadata(x, y, z);
		boolean airabove = this.isFullRoad(block, x, y + 1, z);
		float f4;

		if (!airabove) {
			f4 = 1.0F;
		} else {
			if (meta == 0) {
				f4 = 0.9375F;
			} else {
				f4 = 0.4375F;
			}
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
	}

	@SuppressWarnings({ "rawtypes" })
	public void addCollisionBoxesToList(World world, int x, int y, int z,
			AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list,
				entity);
	}

	@Override
	public boolean onBlockActivated(World world, int xCoord, int yCoord,
			int zCoord, EntityPlayer player, int p_149727_6, float p_149727_7,
			float p_149727_8, float p_149727_9) {
		Block block1 = world.getBlock(xCoord, yCoord, zCoord);

		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem();
			if (stack != null && stack.getItem() == Register.ironMallet
					|| stack.getItem() == Register.goldMallet
					|| stack.getItem() == Register.diamondMallet) {
				int meta = world.getBlockMetadata(xCoord, yCoord, zCoord);

				switch (meta) {

				case 0:
					// System.out.println("Metadata Value: " + meta);
					world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1,
							2);
					world.markBlockForUpdate(xCoord, yCoord, zCoord);
					world.playSoundEffect((double) ((float) xCoord + 0.5F),
							(double) ((float) yCoord + 0.5F),
							(double) ((float) zCoord + 0.5F),
							block1.stepSound.getStepResourcePath(),
							(block1.stepSound.getVolume() + 1.0F) / 2.0F,
							block1.stepSound.getPitch() * 0.8F);
					stack.damageItem(1, player);
					break;
				case 1:
					// System.out.println("Metadata Value: " + meta);
					world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0,
							2);
					world.markBlockForUpdate(xCoord, yCoord, zCoord);
					world.playSoundEffect((double) ((float) xCoord + 0.5F),
							(double) ((float) yCoord + 0.5F),
							(double) ((float) zCoord + 0.5F),
							block1.stepSound.getStepResourcePath(),
							(block1.stepSound.getVolume() + 1.0F) / 2.0F,
							block1.stepSound.getPitch() * 0.8F);
					stack.damageItem(1, player);
					break;
				case 2:
					// System.out.println("Metadata Value: " + meta);
					break;

				}
			}
		}

		return true;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord,
			int zCoord, Entity entity) {
		if (Config.speedOn) {
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
	}

	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : (side == 0 ? Blocks.dirt
				.getBlockTextureFromSide(side) : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess block, int xCoord, int yCoord,
			int zCoord, int side) {
		if (side == 1) {
			return this.top_overlay;
		} else if (side == 0) {
			return Blocks.dirt.getBlockTextureFromSide(side);
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister regIcon) {
		this.blockIcon = regIcon.registerIcon("grass_side_overlay");
		this.top = regIcon.registerIcon("roadblock:grassroad_top");
		this.top_overlay = regIcon
				.registerIcon("roadblock:grassroad_top_overlay");
		this.side_overlay = regIcon.registerIcon("grass_side_overlay");
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_) {
		return this.getBlockColor();
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess BlockAcc, int xCoord, int yCoord,
			int zCoord) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;

		for (int k1 = -1; k1 <= 1; ++k1) {
			for (int l1 = -1; l1 <= 1; ++l1) {
				int i2 = BlockAcc
						.getBiomeGenForCoords(xCoord + l1, zCoord + k1)
						.getBiomeGrassColor(xCoord + l1, yCoord, zCoord + k1);
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}

		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconSideOverlay() {
		return this.blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconTopOverlay() {
		return this.top;
	}

}