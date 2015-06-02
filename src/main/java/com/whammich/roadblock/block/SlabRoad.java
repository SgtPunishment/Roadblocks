package com.whammich.roadblock.block;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SlabRoad extends Block {

	private String name;
	private int speed;

	public SlabRoad(Material material, String string, SoundType stepsound) {
		super(material);
		name = string;
		GameRegistry.registerBlock(this, name + "_roadslab").setStepSound(
				stepsound);
		setUnlocalizedName(Reference.modID + "_" + name + "_roadslab");
		setCreativeTab(Roadblock.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void onEntityCollidedWithBlock(World world, BlockPos pos,
			IBlockState state, Entity entity) {

		if (entity instanceof EntityLivingBase) {
			if (Config.speed > 9) {
				speed = 9;
			} else {
				speed = Config.speed;
			}
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
					Potion.moveSpeed.id, 0, speed));
		}
	}
}