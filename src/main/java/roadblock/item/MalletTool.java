package roadblock.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import roadblock.Main;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MalletTool extends Item {

	private final String name = "ironMallet";
	int itemDamage;

	public MalletTool() {
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Main.modid + "_" + name);
		setCreativeTab(Register.tabRoadBlock);
		setMaxStackSize(1);
		setMaxDamage(500);
	}

	public String getName() {
		return name;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("roadblock:ironmallet");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world,
			EntityPlayer player) {
		System.out.println("Using Tool!");
		player.getCurrentEquippedItem().damageItem(1, player);
		return null;
	}

	@Override
	public boolean isDamageable() {
		return true;
	}

	@Override
	public boolean isItemTool(ItemStack item) {
		return this.getItemStackLimit(item) == 1 && this.isDamageable();
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}
}