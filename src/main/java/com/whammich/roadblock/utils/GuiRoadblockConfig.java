package com.whammich.roadblock.utils;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

import com.whammich.roadblock.utils.Reference;

public class GuiRoadblockConfig extends GuiConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GuiRoadblockConfig(GuiScreen parent) {
		super(parent, new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.modid, false, false, GuiConfig.getAbridgedConfigPath(Config.config.toString()));
	}
}