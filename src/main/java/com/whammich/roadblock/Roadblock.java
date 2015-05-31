package com.whammich.roadblock;

import com.whammich.roadblock.utils.*;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

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

    public static CreativeTabs tabRoadblocks = new CreativeTabRoadblocks(Reference.modid + ".creativeTab");

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event);

        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Items
        LogHelper.info("Registering Items");
		Register.registerItems();

		// Register Blocks
        LogHelper.info("Registering Blocks");
		Register.registerBlocks();

		// Register Recipes
        LogHelper.info("Registering Recipes");
		Register.Recipes();

		// Register Achievements
        LogHelper.info("Registering Achievements");
		Register.Achievements();
	}

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(Reference.modid)) {
            Config.syncConfig();
            LogHelper.info(StatCollector.translateToLocal("info.roadblock.config.reload"));
        }
    }
}