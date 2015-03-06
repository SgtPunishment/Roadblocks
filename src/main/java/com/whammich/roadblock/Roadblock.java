package com.whammich.roadblock;

import com.whammich.roadblock.proxy.IProxy;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = Reference.modid, 
		name = Reference.name, 
		version = Reference.version, 
		dependencies = Reference.dependencies, 
		guiFactory = Reference.GuiFactory_class
	)

public class Roadblock {

	@Instance(Reference.modid)
	public static Roadblock instance;

	@SidedProxy(clientSide = Reference.client_proxy_class, serverSide = Reference.server_proxy_class)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.loadConfig(event.getSuggestedConfigurationFile());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Items
		if (Config.debug)
			System.out.println("Registering Items");
		Register.Items();

		// Register Blocks
		if (Config.debug)
			System.out.println("Registering Blocks");
		Register.Blocks();

		// Register Recipes
		if (Config.debug)
			System.out.println("Registering Recipes");
		Register.Recipes();

		// Register Achievements
		if (Config.debug)
			System.out.println("Registering Achievements");
		Register.Achievements();

		// Register Tools
		if (Config.debug)
			System.out.println("Registering Mallet Recipes");
		Register.malletRecipes();

		if (Config.debug)
			System.out.println("Registering Mallet Crafting");
		Register.malletCrafting();

		// // Register Renderer
		// if (Config.debug)
		// System.out.println("Registering Renderers");
		// Register.Renderers();
	}

}