package com.whammich.roadblock.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config.Section;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class Gui_Screen extends GuiConfig {
	public Gui_Screen(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), Roadblock.modid, false,
				false, GuiConfig.getAbridgedConfigPath("/RoadBlocks/"));
	}

	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(GuiScreen parentScreen) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (Section section : Config.sections) {
			list.add(new ConfigElement<ConfigCategory>(Config.config
					.getCategory(section.lc())));
		}
		return list;
	}
}