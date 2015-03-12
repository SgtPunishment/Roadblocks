package com.whammich.roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.LogHelper;
import com.whammich.roadblock.utils.Reference;

public class BlockRoadLight extends BlockRoadBase {

	@SuppressWarnings("unused")
	private Block block = null;

	public BlockRoadLight(String unlocName, String textureName,
			Material material, SoundType soundType) {
		super(unlocName, textureName, material, soundType);

		setBlockName(Reference.modid + "." + unlocName + ".roadblock");
		setBlockTextureName(textureName);
		setCreativeTab(Roadblock.tabRoadblocks);
		setStepSound(soundType);
		setHardness(1.5F);

		LogHelper
				.info("Registering roadblock with name: " + getLocalizedName());
		setLightLevel(1.0F);
	}


}
