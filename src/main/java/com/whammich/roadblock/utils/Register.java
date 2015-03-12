package com.whammich.roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import sstow.gameObjs.ObjHandler;

import com.whammich.roadblock.block.BlockGlowRoad;
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

	public static Block defaultRoadblock;
	public static Block[] configBlocks;
	public static Block glowRoadblock;
	public static int configBlockCount = 0;

	public static void registerItems() {
		ironMallet = new ItemMallet(ToolMaterial.IRON, "ingotIron");
		goldMallet = new ItemMallet(ToolMaterial.GOLD, "ingotGold");
		diamondMallet = new ItemMallet(ToolMaterial.EMERALD, "gemDiamond");

		if (Loader.isModLoaded("SSTOW"))
			souliumMallet = new ItemMallet(ObjHandler.SOULIUM, "ingotSoulium");
	}

	public static void registerBlocks() {
		configBlocks = new Block[Config.roadblocks.length];
		for (int i = 0; i < Config.roadblocks.length; i++) {
			String[] split = Config.roadblocks[i].split(":");

			if (split.length == 3) {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = Integer.parseInt(split[2]);

				configBlocks[configBlockCount] = new BlockRoadBase(block, meta,
						Block.soundTypeStone);
				configBlocks[configBlockCount] = new BlockSlabBase(block, meta,
						Block.soundTypeStone);
				configBlockCount++;
			} else if (split.length == 2) {
				Block block = GameRegistry.findBlock(split[0], split[1]);
				int meta = 0;

				configBlocks[configBlockCount] = new BlockRoadBase(block, meta,
						Block.soundTypeStone);
				System.out.println(block + ": " + meta);
				configBlocks[configBlockCount] = new BlockSlabBase(block, meta,
						Block.soundTypeStone);
				configBlockCount++;
			}
		}
		glowRoadblock = new BlockGlowRoad("glowstone", "glowstone",
				Material.glass, Block.soundTypeGlass);
	}

	public static void Achievements() {
		LogHelper.info("Registering Achievement");
		buildRoad = new Achievement("achievement.buildRoad", "buildRoad", 0, 0,
				defaultRoadblock, (Achievement) null).initIndependentStat()
				.registerStat();

		LogHelper.info("Registering Achievement Page");
		AchievementPage.registerAchievementPage(new AchievementPage(
				"Roadblocks", buildRoad));
	}
}