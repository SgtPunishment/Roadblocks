package com.whammich.roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class decroBlock extends Block {

	public String name;
	public String texture;
	public IIcon sDirt;

	public decroBlock(Material material, String blockName, String blockTexture,
			SoundType stepsound) {
		super(material);
		name = blockName;
		texture = blockTexture;
		GameRegistry.registerBlock(this, name).setStepSound(stepsound);
		setBlockName(name);
		setCreativeTab(Register.tabRoadBlock);
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
		if (texture == "smoothDirt") {
			this.blockIcon = register.registerIcon(Reference.modid + ":smoothdirt");
		} else if (texture == "compressedCobblestone") {
			this.blockIcon = register.registerIcon("furnace_top");
		}
	}
}
