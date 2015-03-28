package com.whammich.roadblock.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

import com.whammich.roadblock.block.BlockRoadBase;

public class ItemBotaniaMallet extends ItemMallet implements IManaUsingItem {

	private static final int MANA_PER_DAMAGE = 60;

	String toolMaterial;

	public ItemBotaniaMallet(Item.ToolMaterial material, String handle, String head) {
		super(material, handle, head);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity,
			EntityLivingBase player) {
		ToolCommons.damageItem(stack, 1, player, MANA_PER_DAMAGE);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block,
			int xCoord, int yCoord, int zCoord, EntityLivingBase player) {
		if ((double) block.getBlockHardness(world, xCoord, yCoord, zCoord) != 0.0D)
			ToolCommons.damageItem(stack, 2, player, MANA_PER_DAMAGE);
		return true;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int xCoord, int yCoord, int zCoord, int side, float hitX,
			float hitY, float hitZ) {
		if (world.getBlock(xCoord, yCoord, zCoord) instanceof BlockRoadBase) {
			if (world.getBlockMetadata(xCoord, yCoord, zCoord) == 0) {
				world.setBlock(xCoord, yCoord, zCoord,
						world.getBlock(xCoord, yCoord, zCoord), 1, 3);
				world.markBlockForUpdate(xCoord, yCoord, zCoord);
				ToolCommons.damageItem(stack, 2, player, MANA_PER_DAMAGE);
				return true;
			} else {
				world.setBlock(xCoord, yCoord, zCoord,
						world.getBlock(xCoord, yCoord, zCoord), 0, 3);
				world.markBlockForUpdate(xCoord, yCoord, zCoord);
				ToolCommons.damageItem(stack, 2, player, MANA_PER_DAMAGE);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return par2ItemStack.getItem() == ModItems.manaResource
				&& par2ItemStack.getItemDamage() == 0 ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4,
			boolean par5) {
		if (!world.isRemote
				&& player instanceof EntityPlayer
				&& stack.getItemDamage() > 0
				&& ManaItemHandler.requestManaExactForTool(stack,
						(EntityPlayer) player, MANA_PER_DAMAGE * 2, true))
			stack.setItemDamage(stack.getItemDamage() - 1);
	}

	@Override
	public boolean usesMana(ItemStack stack) {
		return true;
	}
}