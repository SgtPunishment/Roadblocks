package com.whammich.roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.whammich.roadblock.block.BlockRoadLight;
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
	public static Block roadblockGlowstone;
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

			switch (split.length) {
			case 2: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = 0;

				roadblockConfig[configBlockCount] = new BlockRoadBase(block, meta, Block.soundTypeStone);
				roadblockConfig[configBlockCount] = new BlockSlabBase(false, block, meta, Block.soundTypeStone);
				LogHelper.info(block + ": " + meta);
				configBlockCount++;			}
			case 3: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);

				roadblockConfig[configBlockCount] = new BlockRoadBase(block, meta, Block.soundTypeStone);
				roadblockConfig[configBlockCount] = new BlockSlabBase(false, block, meta, Block.soundTypeStone);
				configBlockCount++;
			}
			case 4: {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);
				float light = Float.parseFloat(split[3]);
				
				roadblockConfig[configBlockCount] = new BlockRoadBase(block, meta, Block.soundTypeStone, light);
				configBlockCount++;
			}
			}

		}

//		roadblockGlowstone = new BlockRoadLight("glowstone", "glowstone",
//				Material.glass, Block.soundTypeGlass);
//		GameRegistry.registerBlock(roadblockGlowstone, "BlockRoadGlowstone");
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