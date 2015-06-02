package com.whammich.roadblock.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.block.BlockRoad;
import com.whammich.roadblock.utils.ModLogger;

public class ItemMallet extends Item {
	
	@SuppressWarnings("unused")
	private float DamVEnt;
	String toolMaterial;
	public ItemMallet(Item.ToolMaterial material) {		
		String toolMaterial = material.toString().toLowerCase();
		this.toolMaterial = toolMaterial;
		
		setUnlocalizedName(toolMaterial.toLowerCase() + "Mallet");
		setCreativeTab(Roadblock.tabRoadBlock);
		setMaxStackSize(1);
		setMaxDamage(material.getMaxUses());
		
		DamVEnt = 2.0F + material.getDamageVsEntity();
		
		ModLogger.logInfo("Registering " + toolMaterial + " Pavers Mallet");
		GameRegistry.registerItem(this, toolMaterial.toLowerCase() + "Mallet");
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(2, attacker);
		return true;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.getBlockState(pos).getBlock() instanceof BlockRoad) {
			ModLogger.logInfo("Roadblock!");
//			if (world.getBlockState(pos).get == 0) {
//				world.setBlock(xCoord, yCoord, zCoord, world.getBlock(xCoord, yCoord, zCoord), 1, 3);
//				world.markBlockForUpdate(xCoord, yCoord, zCoord);
//				stack.damageItem(1, player);
//				return true;
//			} else {
//				world.setBlock(xCoord, yCoord, zCoord, world.getBlock(xCoord, yCoord, zCoord), 0, 3);
//				world.markBlockForUpdate(xCoord, yCoord, zCoord);
//				stack.damageItem(1, player);
//				return true;
//			}
		}
		return false;
	}
}