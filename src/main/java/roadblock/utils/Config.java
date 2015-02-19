package roadblock.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import roadblock.Main;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {

	public static int speed;
	public static boolean debug;
	public static boolean speedOn;

	public static Configuration config;
	public static File configDirectory;

	public static class Section {
		public final String name;

		public Section(String name, String lang) {
			this.name = name;
			register();
		}

		private void register() {
			sections.add(this);
		}

		public String lc() {
			return name.toLowerCase();
		}
	}

	public static final List<Section> sections;
	static {
		sections = new ArrayList<Section>();
	}

	public static final Section general = new Section("general", "general");

	public static void load(FMLPreInitializationEvent event) {
		if (Config.debug)
			System.out.println("Loading Config File");
		FMLCommonHandler.instance().bus().register(new Config());
		configDirectory = new File(event.getModConfigurationDirectory()
				+ "/RoadBlocks/");
		if (!configDirectory.exists()) {
			configDirectory.mkdir();
		}
		File configFile = new File(configDirectory, "config.cfg");
		config = new Configuration(configFile);
		syncConfig();
	}

	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent event) {
		if (event.modID.equals(Main.modid)) {
			System.out.println("Updating config...");
			syncConfig();
		}
	}

	public static void syncConfig() {
		try {
			speed = config.getInt("Speed Boost Level", "general", 0, 0, 9,
					"How fast you travel on a road block");
			speedOn = config.getBoolean("Enable Speed Boost", "general", true,
					"Enable the speed boost option");
			debug = config.getBoolean("Enable Debug Mode", "general", false,
					"RESTART REQUIRED: This will output information to the console");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

}
