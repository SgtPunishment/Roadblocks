package com.whammich.roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.block.BlockDecor;
import com.whammich.roadblock.block.BlockRoadBase;
import com.whammich.roadblock.item.ItemMallet;
import com.whammich.roadblock.item.blocks.ItemBlockDecor;

import cpw.mods.fml.common.registry.GameRegistry;

public class Register {

	public static Achievement buildRoad;
	
	// Default Mallets
	public static Item ironMallet;
	public static Item goldMallet;
	public static Item diamondMallet;
	
	// Blocks
	
	public static Block roadblockDefault;
	public static Block BlockDecor;
	
	
	public static Block[] roadblockConfig;
	public static int configBlockCount = 0;

	public static void Recipes() {
		Utils.safeRegister("blockObsidian", new ItemStack(Blocks.obsidian));
		GameRegistry.addRecipe(new ItemStack(BlockDecor, 4, 0), new Object[] { "#%", "%#", '#', Blocks.dirt, '%', Blocks.sand });
		GameRegistry.addRecipe(new ItemStack(roadblockDefault), new Object[] { "##", "##", '#', new ItemStack(Blocks.stone_slab, 1, 5) });
	}
	
	public static void registerItems() {
		ironMallet = new ItemMallet(ToolMaterial.IRON, "stickWood", "ingotIron", Reference.modid + ":mallet_iron").setCreativeTab(Roadblock.tabRoadblocks);
		GameRegistry.registerItem(ironMallet, "IronMallet");
		
		goldMallet = new ItemMallet(ToolMaterial.GOLD, "stickWood", "ingotGold", Reference.modid + ":mallet_gold").setCreativeTab(Roadblock.tabRoadblocks);
		GameRegistry.registerItem(goldMallet, "GoldMallet");
		
		diamondMallet = new ItemMallet(ToolMaterial.EMERALD, "stickWood", "gemDiamond", Reference.modid + ":mallet_diamond").setCreativeTab(Roadblock.tabRoadblocks);
		GameRegistry.registerItem(diamondMallet, "DiamondMallet");
	}

	public static void registerBlocks() {
		
		BlockDecor = new BlockDecor();
		GameRegistry.registerBlock(BlockDecor, ItemBlockDecor.class, "BlockDecor").setStepSound(Block.soundTypeStone);

		roadblockDefault = new BlockRoadBase("default", Reference.modid + ":default", Material.ground, Block.soundTypeStone);
		GameRegistry.registerBlock(roadblockDefault, "BlockRoadDefault");
		//roadblockDefault = new BlockSlabBase(false, "default", Reference.modid + ":default", Material.ground, Block.soundTypeStone);
		//GameRegistry.registerBlock(roadblockDefault, "BlockSlabDefault");
		
		roadblockConfig = new Block[Config.roadblocks.length];
		for (int i = 0; i < Config.roadblocks.length; i++) {
			String[] split = Config.roadblocks[i].split(":");
			LogHelper.info(Config.roadblocks[i]);
			switch (split.length) {
			case 2: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = 0;
				if (block != null) {
					roadblockConfig[configBlockCount] = new BlockRoadBase(block, meta, Block.soundTypeStone);
					//roadblockConfig[configBlockCount] = new BlockSlabBase(false, block, meta, Block.soundTypeStone);
				}
				LogHelper.info(block + ": " + meta);
				configBlockCount++;
				break;
			}
			case 3: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);
				if (block != null) {
					roadblockConfig[configBlockCount] = new BlockRoadBase(block, meta, Block.soundTypeStone);
					//roadblockConfig[configBlockCount] = new BlockSlabBase(false, block, meta, Block.soundTypeStone);
				}
				configBlockCount++;
				break;
			}
			}

		}

	}

	public static void Achievements() {
		LogHelper.info("Registering Achievement");
		buildRoad = new Achievement("achievement.buildRoad", "buildRoad", 0, 0,
				roadblockDefault, (Achievement) null).initIndependentStat()
				.registerStat();

		LogHelper.info("Registering Achievement Page");
		AchievementPage.registerAchievementPage(new AchievementPage(
				"Roadblocks", buildRoad));
	}


}