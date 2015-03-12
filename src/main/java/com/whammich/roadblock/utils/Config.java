package com.whammich.roadblock.utils;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {

    public static Configuration config;

    // Category Base
    static String category;

    // Config Options
    public static int speed;
	public static boolean debug;
	public static boolean speedOn;
	public static int returnBlocks;
    public static String[] roadblocks;
    private static String[] roadblocksDefault = { "minecraft:dirt", "minecraft:dirt:2", "minecraft:grass", "minecraft:stone", "minecraft:cobblestone", "minecraft:planks", "minecraft:planks:1" };

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        category = "general";

        speed = config.get(category, "speedBoostLevel", 0, "How fast to travel on a roadblock.").getInt();
        returnBlocks = config.get(category, "amountCraftedReturn", 1, "Amount of roadblocks to obtain when crafted").getInt();
        speedOn = config.get(category, "speedBoostEnabled", true, "Enable the speed boost.").getBoolean();
        debug = config.get(category, "enableDebugSettings", false, "Enables debug console logging.").getBoolean();
        roadblocks = config.get(category, "roadblocksToCreate", roadblocksDefault, "Blocks to create roadblocks for. \nSyntax is: \nmodid:blockname:meta").getStringList();

        config.save();
    }
}
