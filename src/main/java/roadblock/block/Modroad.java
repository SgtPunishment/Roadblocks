package roadblock.block;

import java.util.List;

import com.cricketcraft.chisel.Chisel;

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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadblock.utils.Config;
import roadblock.utils.Register;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Modroad extends Block {

	private int speed;
	public String name;
	public String texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon side;
	public IIcon bottom;
	public IIcon slab;

	public Modroad(Material material, String blockName, String blockTexture,
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

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @Override
	// public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	// {
	// for (int i = 0; i < 2; i++) {
	// list.add(new ItemStack(item, 1, i));
	// }
	// }

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
		if (Loader.isModLoaded("chisel")) {
			if (texture == "wireframe") {
				return blockIcon;
			} else if (texture == "wireframewhite") {
				return blockIcon;
			}else if (texture == "paver") {
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
				this.blockIcon = register.registerIcon(Chisel.MOD_ID
						+ ":paver");
			}
		} else {
			this.blockIcon = register.registerIcon(texture);
		}
	}

}