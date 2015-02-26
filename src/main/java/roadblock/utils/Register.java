package roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.oredict.ShapedOreRecipe;
import roadblock.block.Grassroad;
import roadblock.block.Modroad;
import roadblock.block.Roadblock;
import roadblock.block.decroBlock;
import roadblock.item.MalletTool;
import roadblock.renderer.grassRoadRender;
import sstow.gameObjs.ObjHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {

	public static Achievement buildRoad;

	public static Creative_Tab tabRoadBlock = new Creative_Tab();

	// Full Blocks

	public static Block grassRoad;
	public static Block smoothDirt;
	public static Block compressedCobblestone;
	public static Block defaultRoadblock;
	public static Block compressedCobbleRoadblock;
	public static Block smoothDirtRoadblock;
	public static Block stoneRoadblock;
	public static Block dirtRoadblock;
	public static Block podzolRoadblock;
	public static Block cobbleRoadblock;
	public static Block oakRoadblock;
	public static Block spruceRoadblock;
	public static Block birchRoadblock;
	public static Block jungleRoadblock;
	public static Block acaciaRoadblock;
	public static Block darkOakRoadblock;
	public static Block sandRoadblock;
	public static Block redsandRoadblock;
	public static Block gravelRoadblock;
	public static Block sandstoneTopRoadblock;
	public static Block sandstoneBottomRoadblock;
	public static Block stoneSlabTopRoadblock;
	public static Block bricksRoadblock;
	public static Block netherRoadblock;
	public static Block quartzBottomRoadblock;
	public static Block quartzTopRoadblock;
	public static Block quartzChiseledRoadblock;
	public static Block quartzPillerTopRoadblock;
	public static Block stonebrickChiseledRoadblock;

	// Chisel 2 Textures
	public static Block chiselFactory01;
	public static Block chiselFactory02;
	public static Block chiselPaver;

	public static Item ironMallet;
	public static Item goldMallet;
	public static Item diamondMallet;
	public static Item souliumMallet;

	public static int renderPass;
	public static int grassRoadRenderType;

	public static void Items() {
		ironMallet = new MalletTool(ToolMaterial.IRON);
		goldMallet = new MalletTool(ToolMaterial.GOLD);
		diamondMallet = new MalletTool(ToolMaterial.EMERALD);
		if (Loader.isModLoaded("SSTOW")) {
			souliumMallet = new MalletTool(ObjHandler.SOULIUM);
		}
	}

	public static void Blocks() {
		// Register Full Blocks
		if (Loader.isModLoaded("chisel")) {
			if (Config.debug)
				System.out.println("Registering Factory Block");
			chiselFactory01 = new Modroad(Material.iron, "WireFrame",
					"wireframe", Block.soundTypeMetal);

			if (Config.debug)
				System.out.println("Registering Factory Block");
			chiselFactory02 = new Modroad(Material.iron, "WireFrameWhite",
					"wireframewhite", Block.soundTypeMetal);

			if (Config.debug)
				System.out.println("Registering Paver Block");
			chiselPaver = new Modroad(Material.iron, "paver", "paver",
					Block.soundTypeMetal);

		} else {

		}

//		if (Config.debug)
//			System.out.println("Registering Grass Roadblock");
//		grassRoad = new Grassroad();

		if (Config.debug)
			System.out.println("Registering Smooth Dirt Block");
		smoothDirt = new decroBlock(Material.ground, "SmoothDirt",
				"smoothDirt", Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Compressed Cobblestone Block");
		compressedCobblestone = new decroBlock(Material.rock,
				"compressedCobblestone", "compressedCobblestone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Default Roadblock");
		defaultRoadblock = new Roadblock(Material.rock, "Default", "default",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Smooth Dirt Roadblock");
		smoothDirtRoadblock = new Roadblock(Material.ground, "SmoothDirt",
				"smoothDirt", Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Compressed Cobblestone Roadblock");
		compressedCobbleRoadblock = new Roadblock(Material.rock,
				"CompressedCobble", "compressedcobble", Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Stone Roadblock");
		stoneRoadblock = new Roadblock(Material.rock, "Stone", "stone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Dirt Roadblock");
		dirtRoadblock = new Roadblock(Material.grass, "Dirt", "dirt",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Podzol Roadblock");
		podzolRoadblock = new Roadblock(Material.grass, "Podzol", "podzol",
				Block.soundTypeGrass);

		if (Config.debug)
			System.out.println("Registering Cobblestone Roadblock");
		cobbleRoadblock = new Roadblock(Material.rock, "Cobblestone",
				"cobblestone", Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Oak Roadblock");
		oakRoadblock = new Roadblock(Material.wood, "Oak", "planks_oak",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Spruce Roadblock");
		spruceRoadblock = new Roadblock(Material.wood, "Spruce",
				"planks_spruce", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Birch Roadblock");
		birchRoadblock = new Roadblock(Material.wood, "Birch", "planks_birch",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Jungle Roadblock");
		jungleRoadblock = new Roadblock(Material.wood, "Jungle",
				"planks_jungle", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Acacia Roadblock");
		acaciaRoadblock = new Roadblock(Material.wood, "Acacia",
				"planks_acacia", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Dark Oak Roadblock");
		darkOakRoadblock = new Roadblock(Material.wood, "DarkOak",
				"planks_big_oak", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Sand Roadblock");
		sandRoadblock = new Roadblock(Material.sand, "Sand", "sand",
				Block.soundTypeSand);

		if (Config.debug)
			System.out.println("Registering Sandstone Top Roadblock");
		sandstoneTopRoadblock = new Roadblock(Material.rock, "SandstoneTop",
				"sandstone_top", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Roadblock");
		sandstoneBottomRoadblock = new Roadblock(Material.rock,
				"SandstoneBottom", "sandstone_bottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Gravel Roadblock");
		gravelRoadblock = new Roadblock(Material.ground, "Gravel", "gravel",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Stone Slab Roadblock");
		stoneSlabTopRoadblock = new Roadblock(Material.rock, "StoneSlabTop",
				"stone_slab_top", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Brick Roadblock");
		bricksRoadblock = new Roadblock(Material.rock, "Brick", "brick",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Nether Brick Roadblock");
		netherRoadblock = new Roadblock(Material.rock, "NetherBrick",
				"nether_brick", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Roadblock");
		quartzBottomRoadblock = new Roadblock(Material.rock, "QuartzBottom",
				"quartz_block_bottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Top Roadblock");
		quartzTopRoadblock = new Roadblock(Material.rock, "QuartzTop",
				"quartz_block_top", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Chiseled Quartz Roadblock");
		quartzChiseledRoadblock = new Roadblock(Material.rock,
				"QuartzChiseled", "quartz_block_chiseled",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Piller Top Roadblock");
		quartzPillerTopRoadblock = new Roadblock(Material.rock,
				"QuartzPillerTop", "quartz_block_lines_top",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Chiseled Stone Bricks Roadblock");
		stonebrickChiseledRoadblock = new Roadblock(Material.rock,
				"ChiseledStonebrick", "stonebrick_carved",
				Block.soundTypePiston);
	}

	public static void Recipes() {
		// Register Recipes

		if (Config.debug)
			System.out.println("Registering Iron Pavers Mallet Recipe");
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ironMallet),
				"IA", "SI", 'S', "stickWood", 'I', Items.iron_ingot));

		if (Config.debug)
			System.out.println("Registering Gold Pavers Mallet Recipe");
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(goldMallet),
				"GA", "SG", 'S', "stickWood", 'G', Items.gold_ingot));

		if (Config.debug)
			System.out.println("Registering Diamond Pavers Mallet Recipe");
		GameRegistry.addRecipe(new ShapedOreRecipe(
				new ItemStack(diamondMallet), "DA", "SD", 'S', "stickWood",
				'D', Items.diamond));

		if (Config.debug)
			System.out.println("Registering Dirt Path Recipe");
		GameRegistry.addRecipe(new ItemStack(smoothDirt, 4), new Object[] {
				"#%", "%#", '#', Blocks.dirt, '%', Blocks.sand });

		if (Config.debug)
			System.out.println("Registering Compressed Cobblestone Recipe");
		GameRegistry.addRecipe(new ItemStack(compressedCobblestone),
				new Object[] { "###", "###", "###", '#', Blocks.cobblestone });

		if (Config.debug)
			System.out
					.println("Registering Compressed Cobblestone to Cobblestone Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 9),
				new Object[] { compressedCobblestone });

		if (Config.debug)
			System.out.println("Registering Roadblock Recipe");
		GameRegistry.addRecipe(new ItemStack(defaultRoadblock), new Object[] {
				"##", "##", '#', new ItemStack(Blocks.stone_slab, 1, 5) });

		if (Config.debug)
			System.out.println("Registering Sandstone Top Recipe");
		GameRegistry.addRecipe(new ItemStack(sandstoneTopRoadblock),
				new Object[] { "S", "R", 'S',
						new ItemStack(Blocks.sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Recipe");
		GameRegistry.addRecipe(new ItemStack(sandstoneBottomRoadblock),
				new Object[] { "R", "S", 'S',
						new ItemStack(Blocks.sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Top Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzTopRoadblock), new Object[] {
				"S", "R", 'S', new ItemStack(Blocks.quartz_block, 1, 0), 'R',
				defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzBottomRoadblock),
				new Object[] { "R", "S", 'S',
						new ItemStack(Blocks.quartz_block, 1, 0), 'R',
						defaultRoadblock });

		// Register Shapeless Recipes
		if (Config.debug)
			System.out.println("Registering Stone Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(stoneRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.stone, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Smooth Dirt Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(smoothDirtRoadblock),
				new Object[] { defaultRoadblock, smoothDirt });

		if (Config.debug)
			System.out.println("Registering Stone Roadblock Recipe");
		GameRegistry.addShapelessRecipe(
				new ItemStack(compressedCobbleRoadblock), new Object[] {
						defaultRoadblock,
						new ItemStack(Register.compressedCobblestone) });

		if (Config.debug)
			System.out.println("Registering Dirt Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(dirtRoadblock),
				new Object[] { defaultRoadblock, Blocks.dirt });

		if (Config.debug)
			System.out.println("Registering Podzol Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(podzolRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.dirt, 1, 2) });

		if (Config.debug)
			System.out.println("Registering Cobblestone Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(cobbleRoadblock),
				new Object[] { defaultRoadblock, Blocks.cobblestone });

		if (Config.debug)
			System.out.println("Registering Oak Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(oakRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Spruce Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(spruceRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 1) });

		if (Config.debug)
			System.out.println("Registering Birch Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(birchRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 2) });

		if (Config.debug)
			System.out.println("Registering Jungle Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(jungleRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 3) });

		if (Config.debug)
			System.out.println("Registering Acacia Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(acaciaRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 4) });

		if (Config.debug)
			System.out.println("Registering Dark Oak Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(darkOakRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.planks, 1, 5) });

		if (Config.debug)
			System.out.println("Registering Sand Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(sandRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.sand, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Red Sand Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(redsandRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.sand, 1, 1) });

		if (Config.debug)
			System.out.println("Registering Gravel Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(gravelRoadblock),
				new Object[] { defaultRoadblock, Blocks.gravel });

		if (Config.debug)
			System.out.println("Registering Stoneslab Top Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(stoneSlabTopRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.stone_slab, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Brick Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(bricksRoadblock),
				new Object[] { defaultRoadblock, Blocks.brick_block });

		if (Config.debug)
			System.out.println("Registering Nether Brick Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(netherRoadblock),
				new Object[] { defaultRoadblock, Blocks.nether_brick });

		if (Config.debug)
			System.out.println("Registering Chiseled Quartz Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(quartzChiseledRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.quartz_block, 1, 1) });

		if (Config.debug)
			System.out.println("Registering Quartz Piller Roadblock Recipe");
		GameRegistry.addShapelessRecipe(
				new ItemStack(quartzPillerTopRoadblock), new Object[] {
						defaultRoadblock,
						new ItemStack(Blocks.quartz_block, 1, 2) });

		if (Config.debug)
			System.out
					.println("Registering Chiseled Stonebrick Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(
				stonebrickChiseledRoadblock), new Object[] { defaultRoadblock,
				new ItemStack(Blocks.stonebrick, 1, 3) });
	}

	public static void Achievements() {

		buildRoad = new Achievement("achievement.buildRoad", "buildRoad", 0, 0,
				Register.defaultRoadblock, (Achievement) null)
				.initIndependentStat().registerStat();

		AchievementPage.registerAchievementPage(new AchievementPage(
				"Road Blocks", new Achievement[] { buildRoad }));
	}

	public static void Renderers() {
		grassRoadRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new grassRoadRender());
	}

}