package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDecor extends Block {

	public String texture;
	@SideOnly(Side.CLIENT)
	protected IIcon[] blockIcon;

	public static final String[] names = { "worndirtpath", "yellowbrickroad" };

	public BlockDecor() {
		super(Material.ground);
		setCreativeTab(Roadblock.tabRoadblocks);
		setLightOpacity(255);
		useNeighborBrightness = true;
		blockHardness = 3.0F;
		blockResistance = 3.0F;
		setHardness(1.5F);
		setBlockName(Reference.modid + ".decor");
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = new IIcon[names.length];
		for (int i = 0; i < this.blockIcon.length; ++i) {
			this.blockIcon[i] = iconRegister.registerIcon(Reference.modid + ":" + names[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta > 6)
			meta = 0;
		return blockIcon[meta];

	}
}
