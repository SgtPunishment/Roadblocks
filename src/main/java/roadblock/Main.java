package roadblock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import roadblock.block.Road_block;
import roadblock.block.Road_block_slab;
import roadblock.utils.Creative_Tab;
import roadblock.block.Regblocks;
import roadblock.utils.Achievements;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.modid, name = Main.name, version = Main.version, dependencies = "required-after:Forge@[10.13.2.1232,)", guiFactory = "roadblock.utils.Gui_Factory")
public class Main {

	public static final String modid = "RBlocks";
	public static final String name = "Road Blocks";
	public static final String version = "1.1.2";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		// Register Blocks
		Regblocks.RegisterBlocks();
		
		// Register Achievements

		Achievements.RegAchievements();
	}
}
