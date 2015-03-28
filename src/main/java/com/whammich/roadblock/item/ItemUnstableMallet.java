package com.whammich.roadblock.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.rwtema.extrautils.item.IItemMultiTransparency;
import com.whammich.roadblock.utils.Reference;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Optional.Interface(iface = "com.twtema.extrautils.item.IItemMultiTransparency", modid = "ExtraUtilities")
public class ItemUnstableMallet extends ItemMallet implements IItemMultiTransparency {

	private IIcon[] icons;

	public ItemUnstableMallet(Item.ToolMaterial material, String handle, String head) {
		super(material, handle, head);
		setUnlocalizedName(Reference.modid + ":unstablemallet");
		this.setMaxDamage(-1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[2];
		this.itemIcon = (this.icons[0] = iconRegister .registerIcon(getUnlocalizedName().substring(5)));
		this.icons[1] = iconRegister.registerIcon(getUnlocalizedName().substring(5) + "1");
		// itemIcon = iconRegister.registerIcon(Reference.modid +
		// ":unstablemallet");
	}

	@Override
	public int numIcons(ItemStack item) {
		return 2;
	}

	@Override
	public IIcon getIconForTransparentRender(ItemStack item, int pass) {
		return this.icons[pass];
	}

	@Override
	public float getIconTransparency(ItemStack item, int pass) {
		if (pass == 1) {
			return 0.5F;
		}
		return 1.0F;
	}

}
