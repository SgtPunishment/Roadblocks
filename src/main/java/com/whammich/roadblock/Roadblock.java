package com.whammich.roadblock;

import com.whammich.roadblock.proxy.IProxy;
import com.whammich.roadblock.utils.*;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version, dependencies = Reference.dependencies, guiFactory = Reference.GuiFactory_class)

public class Roadblock {

	@Instance(Reference.modid)
	public static Roadblock instance;

	@SidedProxy(clientSide = Reference.client_proxy_class, serverSide = Reference.server_proxy_class)
	public static IProxy proxy;

    public static CreativeTabs tabRoadblocks = new CreativeTabRoadblocks(Reference.modid + ".creativeTab");

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Items
		if (Config.debug)
			System.out.println("Registering Items");
		Register.registerItems();

		// Register Blocks
		if (Config.debug)
			System.out.println("Registering Blocks");
		Register.registerBlocks();

		// Register Recipes
		if (Config.debug)
			System.out.println("Registering Recipes");
//		Register.Recipes();

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

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(Reference.modid)) {
            Config.syncConfig();
        }
    }
}