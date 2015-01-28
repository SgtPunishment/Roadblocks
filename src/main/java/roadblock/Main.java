package roadblock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import roadblock.block.Road_block;
import roadblock.block.Road_block_slab;
import roadblock.utils.Creative_Tab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.modid, name = Main.name, version = Main.version, dependencies = "required-after:Forge@[10.13.2.1232,)", guiFactory = "roadblock.utils.guiFactory")
public class Main {

	public static final String modid = "RBlocks";
	public static final String name = "Road Blocks";
	public static final String version = "1.0.7";

	public static String dename = "";
	public static String detexture = "roadBlock";

	public static String dname = "Dirt";
	public static String dtexture = "dirt";

	public static String sname = "Sand";
	public static String stexture = "sand";

	public static String gname = "Gravel";
	public static String gtexture = "gravel";

	// Full Blocks

	public static Block Road_Block = new Road_block(Material.ground, dename, detexture);

	public static Block Dirt_Road_Block = new Road_block(Material.grass, dname, dtexture);

	public static Block Sand_Road_Block = new Road_block(Material.sand, sname, stexture);

	public static Block Gravel_Road_Block = new Road_block(Material.ground,	gname, gtexture);

	// Half Slabs
	
//	public static Block Road_Block_slab = new Road_block_slab(Material.ground, dename, detexture);
//
//	public static Block Dirt_Road_Block_slab = new Road_block_slab(Material.ground, dname, dtexture);
//
//	public static Block Sand_Road_Block_slab = new Road_block_slab(Material.ground, sname, stexture);
//
//	public static Block Gravel_Road_Block_slab = new Road_block_slab(Material.ground, gname, gtexture);

	public static Creative_Tab tabRoadBlock = new Creative_Tab();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Full Blocks

		GameRegistry.registerBlock(Road_Block, "RBlocks_Road").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeStone).setHardness(1.5F);

		GameRegistry.registerBlock(Dirt_Road_Block, dname + "_RBlocks_Road").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.5F);

		GameRegistry.registerBlock(Sand_Road_Block, sname + "_RBlocks_Road").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeSand).setHardness(0.5F);

		GameRegistry.registerBlock(Gravel_Road_Block, gname + "_RBlocks_Road").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.6F);
				
		// Register Half Slabs
		
//		GameRegistry.registerBlock(Road_Block_slab, "RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeStone).setHardness(1.5F);
//
//		GameRegistry.registerBlock(Dirt_Road_Block_slab, dname + "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.5F);
//
//		GameRegistry.registerBlock(Sand_Road_Block_slab, sname + "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeSand).setHardness(0.5F);
//
//		GameRegistry.registerBlock(Gravel_Road_Block_slab, gname + "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.6F);

		GameRegistry.addShapedRecipe(new ItemStack(Main.Road_Block), "AAA",	"ASS", "ASS", 'S', Blocks.stone_slab);
		
        GameRegistry.addShapelessRecipe(new ItemStack(Main.Dirt_Road_Block), new Object[] {
        	Main.Road_Block, Blocks.dirt
        	}
        );
        
        GameRegistry.addShapelessRecipe(new ItemStack(Main.Sand_Road_Block), new Object[] {
        	Main.Road_Block, Blocks.sand
        	}
        );
        
        GameRegistry.addShapelessRecipe(new ItemStack(Main.Gravel_Road_Block), new Object[] {
        	Main.Road_Block, Blocks.gravel
        	}
        );
	}
}
