package com.whammich.roadblock.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;
import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.Register;

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
		setUnlocalizedName(Roadblock.modid + "_"
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
		itemIcon = iconRegister.registerIcon("roadblock:"
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
}