package com.whammich.roadblock.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

import com.whammich.roadblock.utils.Register;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class grassRoadRender implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		if (Register.renderPass == 0) {
			// Solid Rendering Pass, Render Dirt Block
			renderer.renderStandardBlock(Blocks.dirt, x, y, z);
		} else {
			// Alpha Rendering Pass, Render Grass Roadblock
			renderer.renderStandardBlock(Register.grassRoad, x, y, z);
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return Register.grassRoadRenderType;
	}

}
