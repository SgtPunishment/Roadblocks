package com.whammich.roadblock.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.Reference;

public class BlockRoad extends Block {

	private String name;
	private int speed;

	public BlockRoad(Material material, String string, SoundType stepsound) {
		super(material);
		name = string;
		GameRegistry.registerBlock(this, name + "_roadblock").setStepSound(stepsound);
		setUnlocalizedName(Reference.modID + "_" + name + "_roadblock");
		setCreativeTab(Roadblock.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
		setHardness(1.5F);
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

	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {

		if (entity instanceof EntityLivingBase) {
			if (Config.speed > 9) {
				speed = 9;
			} else {
				speed = Config.speed;
			}
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 0, speed));
		}
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
}