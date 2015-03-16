package roadblock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import roadblock.utils.Config;
import roadblock.utils.Creative_Tab;
import roadblock.utils.Register;

@Mod(modid = Main.modid, name = Main.name, version = Main.version, dependencies = "required-after:Forge@[11.14.1.1305,)", guiFactory = "roadblock.utils.Gui_Factory")
public class Main {

	public static final String modid = "roadblock";
	public static final String name = "Roadblocks";
	public static final String version = "2.1.5";

	public static Creative_Tab tabRoadBlock = new Creative_Tab();

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
		// Register Achievements
		if (Config.debug)
			System.out.println("Registering Achievements");
		Register.Achievements();

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
