package roadblock.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import roadblock.utils.Config.Section;
import roadblock.Main;

public class Gui_Screen extends GuiConfig {
	public Gui_Screen(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), Main.modid, false,
				false, GuiConfig.getAbridgedConfigPath("/RoadBlocks/"));
	}

	private static List<IConfigElement> getConfigElements(GuiScreen parentScreen) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (Section section : Config.sections) {
			list.add(new ConfigElement(Config.config.getCategory(section.lc())));
		}
		return list;
	}
}