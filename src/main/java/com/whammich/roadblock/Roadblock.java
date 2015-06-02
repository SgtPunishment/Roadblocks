package com.whammich.roadblock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.CreativeTab;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Register;

@Mod(
		modid = Reference.modID, 
		name = Reference.name, 
		version = Reference.version, 
		dependencies = Reference.Dependencies, 
		guiFactory = Reference.GuiFactory
	)

public class Roadblock {

	public static CreativeTab tabRoadBlock = new CreativeTab();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Load Config
		Config.load(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Blocks
		if (Config.debug)
			System.out.println("Registering Blocks");
		Register.Blocks();
		// Register Slabs
		if (Config.debug)
			System.out.println("Registering Slabs");
		Register.Slabs();
		// Register Items
		Register.Items();
		// Register Recipes
		if (Config.debug)
			System.out.println("Registering Recipes");
		Register.Recipes();
		
		
		
		if (event.getSide() == Side.CLIENT) {
			// Render Blocks
			if (Config.debug)
				System.out.println("Rendering Blocks");
			Register.RenderBlocks();
			// Render Slabs
			if (Config.debug)
				System.out.println("Rendering Slabs");
			Register.RenderSlabs();
			// Render Items
			Register.RenderItems();
		}
	}
}
