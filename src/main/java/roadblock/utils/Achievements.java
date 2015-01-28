package roadblock.utils;

import roadblock.Main;
import roadblock.block.Regblocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.Loader;

public class Achievements {
	public static Achievement buildRoad;

	public static void RegAchievements() {

		buildRoad = new Achievement("achievement.buildRoad", "buildRoad", 0, 0,
				Regblocks.Road_Block, (Achievement) null).initIndependentStat()
				.registerStat();

		AchievementPage.registerAchievementPage(new AchievementPage(
				"Road Blocks", new Achievement[] { buildRoad }));
	}
}
