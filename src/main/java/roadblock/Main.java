package roadblock;

import roadblock.utils.Config;
import roadblock.utils.Register;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.modid, name = Main.name, version = Main.version, dependencies = "required-after:Forge@[10.13.2.1232,)", guiFactory = "roadblock.utils.Gui_Factory")
public class Main {

	public static final String modid = "roadblock";
	public static final String name = "Roadblocks";
	public static final String version = "@VERSION@";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
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

		// Register Renderer
		if (Config.debug)
			System.out.println("Registering Renderers");
		Register.Renderers();
	}
}
