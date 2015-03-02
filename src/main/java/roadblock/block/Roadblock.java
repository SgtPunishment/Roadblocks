package roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
//import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Roadblock extends Block {

	private int speed;
	public String name;
	public String texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon side;
	public IIcon bottom;
	public IIcon slab;

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

	@Override
	public boolean onBlockActivated(World world, int xCoord, int yCoord,
			int zCoord, EntityPlayer player, int p_149727_6, float p_149727_7,
			float p_149727_8, float p_149727_9) {
		Block block1 = world.getBlock(xCoord, yCoord, zCoord);

		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem();
			if (Loader.isModLoaded("SSTOW")) {
				if (stack != null && stack.getItem() == Register.ironMallet
						|| stack.getItem() == Register.goldMallet
						|| stack.getItem() == Register.diamondMallet
						|| stack.getItem() == Register.souliumMallet) {
					int meta = world.getBlockMetadata(xCoord, yCoord, zCoord);

					switch (meta) {

					case 0:
						// System.out.println("Metadata Value: " + meta);
						world.setBlockMetadataWithNotify(xCoord, yCoord,
								zCoord, 1, 2);
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
						world.setBlockMetadataWithNotify(xCoord, yCoord,
								zCoord, 0, 2);
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
				} else {

				}
			} else {
				if (stack != null && stack.getItem() == Register.ironMallet
						|| stack.getItem() == Register.goldMallet
						|| stack.getItem() == Register.diamondMallet) {
					int meta = world.getBlockMetadata(xCoord, yCoord, zCoord);

					switch (meta) {

					case 0:
						// System.out.println("Metadata Value: " + meta);
						world.setBlockMetadataWithNotify(xCoord, yCoord,
								zCoord, 1, 2);
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
						world.setBlockMetadataWithNotify(xCoord, yCoord,
								zCoord, 0, 2);
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
				} else {

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
			this.top = register.registerIcon("roadblock:default");
			this.blockIcon = register.registerIcon("stonebrick");

		} else if (texture == "smoothDirt") {
			this.blockIcon = register.registerIcon("roadblock:smoothdirt");
		} else if (texture == "podzol") {
			this.top = register.registerIcon("dirt_podzol_top");
			this.blockIcon = register.registerIcon("dirt_podzol_side");
			this.bottom = register.registerIcon("dirt");
			this.slab = register.registerIcon("roadblock:podzol_slab");

		} else if (texture == "compressedcobble") {
			this.blockIcon = register.registerIcon("furnace_top");
			this.slab = register.registerIcon("roadblock:compressedslab");

		} else if (texture == "stonebrick_carved") {
			this.blockIcon = register.registerIcon("stonebrick_carved");
			this.slab = register.registerIcon("roadblock:chiseledslab");

		} else if (texture == "quartz_block_lines_top") {
			this.blockIcon = register.registerIcon("quartz_block_lines_top");
			this.slab = register.registerIcon("quartz_block_lines");

		} else if (texture == "stone_slab_top") {
			this.blockIcon = register.registerIcon("stone_slab_top");
			this.slab = register.registerIcon("roadblock:stoneslabside");

		} else {
			this.blockIcon = register.registerIcon(texture);
		}
	}

}