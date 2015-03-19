package com.whammich.roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDecor extends Block {

	public String texture;

	public BlockDecor(Material material, String blockTexture) {
		super(material);
		texture = blockTexture;
		setCreativeTab(Roadblock.tabRoadblocks);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setHardness(1.5F);

	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(Reference.modid + ":" + texture);
	}
}
