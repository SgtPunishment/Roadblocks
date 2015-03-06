package com.whammich.roadblock.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.collect.Multimap;
import com.whammich.roadblock.event.UseMalletEvent;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Register;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MalletTool extends Item {
	public final String name = "Mallet";
	private float DamVEnt;

	public Item.ToolMaterial theToolMaterial;

	public MalletTool(Item.ToolMaterial material) {
		this.theToolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		GameRegistry.registerItem(this, getToolMaterialName().toLowerCase()
				+ name);
		setUnlocalizedName(Reference.modid + "_"
				+ getToolMaterialName().toLowerCase() + name);
		setCreativeTab(Register.tabRoadBlock);
		this.DamVEnt = 2.0F + theToolMaterial.getDamageVsEntity();
		if (Config.debug)
			System.out.println("Registering "
					+ getToolMaterialName().toLowerCase()
					+ " Pavers Mallet Recipe");
	}

	public float func_150931_i() {
		return this.theToolMaterial.getDamageVsEntity();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.modid + ":"
				+ getToolMaterialName().toLowerCase() + "mallet");
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public String getToolMaterialName() {
		return this.theToolMaterial.toString();
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase entity,
			EntityLivingBase player) {
		stack.damageItem(1, player);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack stack, World world, Block block,
			int xCoord, int yCoord, int zCoord, EntityLivingBase player) {
		if ((double) block.getBlockHardness(world, xCoord, yCoord, zCoord) != 0.0D) {
			stack.damageItem(2, player);
		}

		return true;
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", (double) this.DamVEnt, 0));
		return multimap;
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int xCoord, int yCoord, int zCoord, int side, float p_77648_8_,
			float p_77648_9_, float p_77648_10_) {
		if (!player.canPlayerEdit(xCoord, yCoord, zCoord, side, stack)) {
			return false;
		} else {
			UseMalletEvent event = new UseMalletEvent(player, stack, world,
					xCoord, yCoord, zCoord);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}

			Block block = world.getBlock(xCoord, yCoord, zCoord);
			int meta = world.getBlockMetadata(xCoord, yCoord, zCoord);

			if (side != 0
					&& world.getBlock(xCoord, yCoord + 1, zCoord).isAir(world,
							xCoord, yCoord + 1, zCoord) && (meta == 0)
					&& block == Register.defaultRoadblock) {
				Block block1 = Register.defaultRoadblock;
				world.playSoundEffect((double) ((float) xCoord + 0.5F),
						(double) ((float) yCoord + 0.5F),
						(double) ((float) zCoord + 0.5F),
						block1.stepSound.getStepResourcePath(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F,
						block1.stepSound.getPitch() * 0.8F);

				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(xCoord, yCoord, zCoord, block, meta, side);
					stack.damageItem(1, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}
}