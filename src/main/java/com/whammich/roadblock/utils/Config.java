package com.whammich.roadblock.utils;

import java.io.File;

import com.whammich.roadblock.utils.Config;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {

	public static Configuration config;

	public static File configDirectory;
	
	// Category Base
	static String category;

	// Config Options
	public static boolean speedOn;
	public static int speed;
	public static boolean debug;
	public static int returnBlocks;
	public static String[] roadblocks;
	private static String[] roadblocksDefault = {
		"minecraft:stone",
		"minecraft:dirt", 
		"minecraft:cobblestone", 
		"minecraft:log",
		"minecraft:log:1", 
		"minecraft:log:2", 
		"minecraft:log:3",
		"minecraft:log2", 
		"minecraft:log2:1", 
		"minecraft:planks",
		"minecraft:planks:1", 
		"minecraft:planks:2", 
		"minecraft:planks:3",
		"minecraft:planks:4", 
		"minecraft:planks:5", 
		"minecraft:sand",
		"minecraft:sand:1", 
		"minecraft:gravel", 
		"minecraft:lapis_block",
		"minecraft:sandstone", 
		"minecraft:sandstone:1",
		"minecraft:sandstone:2", 
		"minecraft:wool", 
		"minecraft:wool:1",
		"minecraft:wool:2", 
		"minecraft:wool:3", 
		"minecraft:wool:4",
		"minecraft:wool:5", 
		"minecraft:wool:6", 
		"minecraft:wool:7",
		"minecraft:wool:8", 
		"minecraft:wool:9", 
		"minecraft:wool:10",
		"minecraft:wool:11", 
		"minecraft:wool:12", 
		"minecraft:wool:13",
		"minecraft:wool:14", 
		"minecraft:wool:15", 
		"minecraft:gold_block",
		"minecraft:iron_block", 
		"minecraft:brick_block",
		"minecraft:bookshelf", 
		"minecraft:mossy_cobblestone",
		"minecraft:obsidian", 
		"minecraft:diamond_block",
		"minecraft:coal_block", 
		"minecraft:ice", 
		"minecraft:snow",
		"minecraft:clay", 
		"minecraft:pumpkin", 
		"minecraft:netherrack",
		"minecraft:soul_sand", 
		"minecraft:stonebrick",
		"minecraft:stonebrick:1", 
		"minecraft:stonebrick:2",
		"minecraft:stonebrick:3", 
		"minecraft:mycelium",
		"minecraft:nether_brick", 
		"minecraft:end_stone",
		"minecraft:emerald_block", 
		"minecraft:quartz_block",
		"minecraft:quartz_block:1", 
		"minecraft:quartz_block:2",
		"minecraft:hardened_clay", 
		"minecraft:stained_hardened_clay",
		"minecraft:stained_hardened_clay:1",
		"minecraft:stained_hardened_clay:2",
		"minecraft:stained_hardened_clay:3",
		"minecraft:stained_hardened_clay:4",
		"minecraft:stained_hardened_clay:5",
		"minecraft:stained_hardened_clay:6",
		"minecraft:stained_hardened_clay:7",
		"minecraft:stained_hardened_clay:8",
		"minecraft:stained_hardened_clay:9",
		"minecraft:stained_hardened_clay:10",
		"minecraft:stained_hardened_clay:11",
		"minecraft:stained_hardened_clay:12",
		"minecraft:stained_hardened_clay:13",
		"minecraft:stained_hardened_clay:14",
		"minecraft:stained_hardened_clay:15",
        "roadblock:BlockDecor:0",
		"roadblock:BlockDecor:1"
	};

	public static void init(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new Config());
		configDirectory = new File(event.getModConfigurationDirectory() + "/Whammich/");
		if (!configDirectory.exists()) {
			configDirectory.mkdir();
		}
		File configFile = new File(configDirectory, "Roadblocks.cfg");
		config = new Configuration(configFile);
		syncConfig();
	}

	public static void syncConfig() {
		category = "general";

		speedOn = config.get(category, "speedBoostEnabled", true, "Enable the speed boost.").getBoolean();
		
		speed = config.get(category, "speedBoostLevel", 0, "How fast you travel on a roadblock").getInt();
		
		debug = config.get(category, "enableDebugSettings", false, "Enables debug console logging.").getBoolean();
		
		returnBlocks = config.get(category, "amountCraftedReturn", 3, "Amount of roadblocks to obtain when crafted").getInt();
		
		roadblocks = config .get(category, "roadblocksToCreate", roadblocksDefault, "Blocks to create roadblocks for. \nValid syntax: \nmodid:blockname \nmodid:blockname:meta \nmodid:blockname:meta:lightlevel").getStringList();

		config.save();
	}
}
