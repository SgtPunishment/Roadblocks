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
	public static final String version = "2.1.4";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Items
		Register.Items();

		// Register Blocks
		Register.Blocks();
	
		// Register Recipes
		Register.Recipes();
		
		// Register Achievements
		Register.Achievements();
		
		// Register Tools
		
	}
}
