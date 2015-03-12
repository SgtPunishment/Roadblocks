package com.whammich.roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.whammich.roadblock.block.BlockRoadBase;
import com.whammich.roadblock.block.BlockSlabBase;
import com.whammich.roadblock.item.ItemMallet;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {

	public static Achievement buildRoad;

	public static Item ironMallet;
	public static Item goldMallet;
	public static Item diamondMallet;
	public static Item souliumMallet;

	public static Block roadblockDefault;
	public static Block[] roadblockConfig;
	public static int configBlockCount = 0;

	public static void registerItems() {
		ironMallet = new ItemMallet(ToolMaterial.IRON, "ingotIron");
		goldMallet = new ItemMallet(ToolMaterial.GOLD, "ingotGold");
		diamondMallet = new ItemMallet(ToolMaterial.EMERALD, "gemDiamond");

		if (Loader.isModLoaded("SSTOW"))
			souliumMallet = new ItemMallet(
					com.whammich.sstow.utils.Register.SOULIUM, "ingotSoulium");
	}

	public static void registerBlocks() {
		roadblockConfig = new Block[Config.roadblocks.length];
		for (int i = 0; i < Config.roadblocks.length; i++) {
			String[] split = Config.roadblocks[i].split(":");
			LogHelper.info(Config.roadblocks[i]);
			switch (split.length) {
			case 2: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = 0;
				if (block != null) {
					roadblockConfig[configBlockCount] = new BlockRoadBase(
							block, meta, Block.soundTypeStone);
					roadblockConfig[configBlockCount] = new BlockSlabBase(
							false, block, meta, Block.soundTypeStone);
				}
				LogHelper.info(block + ": " + meta);
				configBlockCount++;
				break;
			}
			case 3: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);
				if (block != null) {
					roadblockConfig[configBlockCount] = new BlockRoadBase(
							block, meta, Block.soundTypeStone);
					roadblockConfig[configBlockCount] = new BlockSlabBase(
							false, block, meta, Block.soundTypeStone);
				}
				configBlockCount++;
				break;
			}
			case 4: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);
				float light = Float.parseFloat(split[3]);
				if (block != null) {
					roadblockConfig[configBlockCount] = new BlockRoadBase(
							block, meta, Block.soundTypeStone, light);
				}
				configBlockCount++;
				break;
			}
			}

		}

		roadblockDefault = new BlockRoadBase("default", Reference.modid
				+ ":default", Material.ground, Block.soundTypeStone);
		GameRegistry.registerBlock(roadblockDefault, "BlockRoadDefault");
		roadblockDefault = new BlockSlabBase(false, "default", Reference.modid
				+ ":default", Material.ground, Block.soundTypeStone);
		GameRegistry.registerBlock(roadblockDefault, "BlockSlabDefault");

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