package roadblock.utils;

import java.util.ArrayList;
import java.util.List;

import roadblock.Config;
import roadblock.Main;
import roadblock.Config.Section;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class guiscreen extends GuiConfig {
	public guiscreen(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), Main.modid, false,
				false, GuiConfig.getAbridgedConfigPath("/RoadBlocks/"));
	}

	private static List<IConfigElement> getConfigElements(GuiScreen parentScreen) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (Section section : Config.sections) {
			list.add(new ConfigElement<ConfigCategory>(Config.config
					.getCategory(section.lc())));
		}
		return list;
	}
}