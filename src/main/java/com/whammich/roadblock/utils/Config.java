package com.whammich.roadblock.utils;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {

	public static int speed;
	public static boolean debug;
	public static boolean speedOn;
	public static int returnBlocks;

	public static Configuration config;
	public static boolean configExists;

	public static void loadConfig(File configFile) {
		config = new Configuration(configFile);
		config.load();
		load();
		FMLCommonHandler.instance().bus().register(new syncConfig());
	}

	public static void load() {
		String category;

		category = "general";

		returnBlocks = config.get(category, "Roadblock Crafted Amount", 1,
				"How many roadblocks should you get when crafted?").getInt(1);

		speed = config.get(category, "Speed Boost Level", 0,
				"How fast you travel on a roadblock").getInt(0);

		speedOn = config.get(category, "Enable Speed Boost", true,
				"Enable Speed Boost Option").getBoolean(true);

		debug = config
				.get(category, "Enable Debug Mode", false,
						"RESTART REQUIRED: This will output information to the console")
				.getBoolean(false);
	}

	public static class syncConfig {
		@SubscribeEvent
		public void onConfigChanged(
				ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.modID.equals(Reference.modid))
				load();
		}
	}
}
