package roadblock.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import roadblock.Main;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {

	public static int speed;
	public static boolean debug;

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
			debug = config.getBoolean("Enable Debug Mode", "general", false,
					"This will output information to the console");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

}
