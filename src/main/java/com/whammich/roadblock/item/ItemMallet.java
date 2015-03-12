package com.whammich.roadblock.item;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.block.BlockRoadBase;
import com.whammich.roadblock.utils.LogHelper;
import com.whammich.roadblock.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;
import com.whammich.roadblock.utils.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemMallet extends Item {

	private float DamVEnt;

	String toolMaterial;

	public ItemMallet(Item.ToolMaterial material, Item resource) {

		String toolMaterial = material.toString().toLowerCase();
		this.toolMaterial = toolMaterial;

		setUnlocalizedName(Reference.modid + ".mallet." + toolMaterial);
		setCreativeTab(Roadblock.tabRoadblocks);
		setMaxStackSize(1);
		setMaxDamage(material.getMaxUses());

		DamVEnt = 2.0F + material.getDamageVsEntity();

		LogHelper.info("Registering " + toolMaterial + " Pavers Mallet");
		GameRegistry.registerItem(this,
				"ItemMallet" + Utils.capitalizeFirstLetter(toolMaterial));
		GameRegistry.addRecipe(new ShapedOreRecipe(this, "M ", "SM", 'S',
				"stickWood", 'M', resource));
	}

	public ItemMallet(Item.ToolMaterial material, String resource) {

		String toolMaterial = material.toString().toLowerCase();
		this.toolMaterial = toolMaterial;

		setUnlocalizedName(Reference.modid + ".mallet." + toolMaterial);
		setCreativeTab(Roadblock.tabRoadblocks);
		setMaxStackSize(1);
		setMaxDamage(material.getMaxUses());

		DamVEnt = 2.0F + material.getDamageVsEntity();

		LogHelper.info("Registering " + toolMaterial + " Pavers Mallet");
		GameRegistry.registerItem(this,
				"ItemMallet" + Utils.capitalizeFirstLetter(toolMaterial));
		GameRegistry.addRecipe(new ShapedOreRecipe(this, "M ", "SM", 'S',
				"stickWood", 'M', resource));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.modid + ":"
				+ toolMaterial + "mallet");
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase entity,
			EntityLivingBase player) {
		stack.damageItem(1, player);

		return true;
	}

	public boolean onBlockDestroyed(ItemStack stack, World world, Block block,
			int xCoord, int yCoord, int zCoord, EntityLivingBase player) {
		if ((double) block.getBlockHardness(world, xCoord, yCoord, zCoord) != 0.0D)
			stack.damageItem(2, player);

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

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int xCoord, int yCoord, int zCoord, int side, float hitX,
			float hitY, float hitZ) {
		if (world.getBlock(xCoord, yCoord, zCoord) instanceof BlockRoadBase) {
			if (world.getBlockMetadata(xCoord, yCoord, zCoord) == 0) {
				world.setBlock(xCoord, yCoord, zCoord,
						world.getBlock(xCoord, yCoord, zCoord), 1, 3);
				world.markBlockForUpdate(xCoord, yCoord, zCoord);
				stack.damageItem(1, player);
				return true;
			} else {
				world.setBlock(xCoord, yCoord, zCoord,
						world.getBlock(xCoord, yCoord, zCoord), 0, 3);
				world.markBlockForUpdate(xCoord, yCoord, zCoord);
				stack.damageItem(1, player);
				return true;
			}
		}

		return false;
	}
}