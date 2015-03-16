package roadblock.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roadblock.Main;
import roadblock.block.compressedCobble;
import roadblock.block.roadblock;
import roadblock.block.roadslab;
import roadblock.item.Mallet;

public class Register {
	public static Block compressedCobble;
	public static Block compressedCobbleRoadblock;
	public static Block defaultRoadblock;
	public static Block stoneRoadblock;
	public static Block andesiteRoadblock;
	public static Block dirtRoadblock;
	public static Block coarseDirtRoadblock;
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
	public static Block redSandstoneTopRoadblock;
	public static Block redSandstoneBottomRoadblock;
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
	public static Block darkPrismarineRoadblock;
	public static Block prismarineRoadblock;
	public static Block compressedCobbleSlab;
	public static Block compressedCobbleRoadslab;
	public static Block defaultRoadslab;
	public static Block stoneRoadslab;
	public static Block andesiteRoadslab;
	public static Block dirtRoadslab;
	public static Block coarseDirtRoadslab;
	public static Block podzolRoadslab;
	public static Block cobbleRoadslab;
	public static Block oakRoadslab;
	public static Block spruceRoadslab;
	public static Block birchRoadslab;
	public static Block jungleRoadslab;
	public static Block acaciaRoadslab;
	public static Block darkOakRoadslab;
	public static Block sandRoadslab;
	public static Block redsandRoadslab;
	public static Block gravelRoadslab;
	public static Block redSandstoneTopRoadslab;
	public static Block redSandstoneBottomRoadslab;
	public static Block sandstoneTopRoadslab;
	public static Block sandstoneBottomRoadslab;
	public static Block stoneSlabTopRoadslab;
	public static Block bricksRoadslab;
	public static Block netherRoadslab;
	public static Block quartzBottomRoadslab;
	public static Block quartzTopRoadslab;
	public static Block quartzChiseledRoadslab;
	public static Block quartzPillerTopRoadslab;
	public static Block stonebrickChiseledRoadslab;
	public static Block darkPrismarineRoadslab;
	public static Block prismarineRoadslab;

	public static Item ironMallet;

	
	public static void Blocks() {

		if (Config.debug)
			System.out.println("Registering Compressed Cobblestone");
		compressedCobble = new compressedCobble();

		if (Config.debug)
			System.out.println("Registering Default Roadblock");
		defaultRoadblock = new roadblock(Material.rock, "Default",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Stone Roadblock");
		stoneRoadblock = new roadblock(Material.rock, "Stone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Andesite Roadblock");
		andesiteRoadblock = new roadblock(Material.rock, "Andesite",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Dirt Roadblock");
		dirtRoadblock = new roadblock(Material.grass, "Dirt",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Coarse Dirt Roadblock");
		coarseDirtRoadblock = new roadblock(Material.ground, "CoarseDirt",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Podzol Roadblock");
		podzolRoadblock = new roadblock(Material.grass, "Podzol",
				Block.soundTypeGrass);

		if (Config.debug)
			System.out.println("Registering Cobblestone Roadblock");
		cobbleRoadblock = new roadblock(Material.rock, "Cobblestone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Oak Roadblock");
		oakRoadblock = new roadblock(Material.wood, "Oak", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Spruce Roadblock");
		spruceRoadblock = new roadblock(Material.wood, "Spruce",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Birch Roadblock");
		birchRoadblock = new roadblock(Material.wood, "Birch",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Jungle Roadblock");
		jungleRoadblock = new roadblock(Material.wood, "Jungle",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Acacia Roadblock");
		acaciaRoadblock = new roadblock(Material.wood, "Acacia",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Dark Oak Roadblock");
		darkOakRoadblock = new roadblock(Material.wood, "DarkOak",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Sand Roadblock");
		sandRoadblock = new roadblock(Material.sand, "Sand",
				Block.soundTypeSand);

		if (Config.debug)
			System.out.println("Registering Sandstone Top Roadblock");
		sandstoneTopRoadblock = new roadblock(Material.rock, "SandstoneTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Roadblock");
		sandstoneBottomRoadblock = new roadblock(Material.rock,
				"SandstoneBottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Redsand Roadblock");
		redsandRoadblock = new roadblock(Material.sand, "Redsand",
				Block.soundTypeSand);

		if (Config.debug)
			System.out.println("Registering Red Sandstone Bottom Roadblock");
		redSandstoneBottomRoadblock = new roadblock(Material.rock,
				"RedSandstoneBottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Red Sandstone Top Roadblock");
		redSandstoneTopRoadblock = new roadblock(Material.rock,
				"RedSandstoneTop", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Gravel Roadblock");
		gravelRoadblock = new roadblock(Material.ground, "Gravel",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Stone Slab Roadblock");
		stoneSlabTopRoadblock = new roadblock(Material.rock, "StoneSlabTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Brick Roadblock");
		bricksRoadblock = new roadblock(Material.rock, "Brick",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Nether Brick Roadblock");
		netherRoadblock = new roadblock(Material.rock, "NetherBrick",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Roadblock");
		quartzBottomRoadblock = new roadblock(Material.rock, "QuartzBottom",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Top Roadblock");
		quartzTopRoadblock = new roadblock(Material.rock, "QuartzTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Chiseled Quartz Roadblock");
		quartzChiseledRoadblock = new roadblock(Material.rock,
				"QuartzChiseled", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Piller Top Roadblock");
		quartzPillerTopRoadblock = new roadblock(Material.rock,
				"QuartzPillerTop", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Chiseled Stone Bricks Roadblock");
		stonebrickChiseledRoadblock = new roadblock(Material.rock,
				"ChiseledStonebrick", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Dark Prismarine Roadblock");
		darkPrismarineRoadblock = new roadblock(Material.rock,
				"DarkPrismarine", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Prismarine Roadblock");
		prismarineRoadblock = new roadblock(Material.rock, "Prismarine",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering CompressedCobble Roadblock");
		compressedCobbleRoadblock = new roadblock(Material.rock,
				"CompressedCobble", Block.soundTypePiston);

	}

	public static void RenderBlocks() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		if (Config.debug)
			System.out.println("Rendering Compressed Cobblestone");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(compressedCobble),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((compressedCobble) compressedCobble).getName(),
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Default Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(defaultRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) defaultRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Stone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stoneRoadblock),
				0,
				new ModelResourceLocation(
						Main.modid + ":"
								+ ((roadblock) stoneRoadblock).getName()
								+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Andesite Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(andesiteRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) andesiteRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Dirt Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(dirtRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) dirtRoadblock).getName() + "_roadblock",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Coarse Dirt Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(coarseDirtRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) coarseDirtRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Podzol Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(podzolRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) podzolRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Cobblestone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(cobbleRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) cobbleRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Oak Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(oakRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) oakRoadblock).getName() + "_roadblock",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Spruce Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(spruceRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) spruceRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Birch Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(birchRoadblock),
				0,
				new ModelResourceLocation(
						Main.modid + ":"
								+ ((roadblock) birchRoadblock).getName()
								+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Jungle Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(jungleRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) jungleRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Acacia Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(acaciaRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) acaciaRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Dark Oak Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(darkOakRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) darkOakRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Sand Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) sandRoadblock).getName() + "_roadblock",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sand Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redsandRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) redsandRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Gravel Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(gravelRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) gravelRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Sandstone Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandstoneTopRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) sandstoneTopRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Sandstone Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandstoneBottomRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) sandstoneBottomRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sandstone Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redSandstoneTopRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) redSandstoneTopRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sandstone Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redSandstoneBottomRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) redSandstoneBottomRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Stone Slab Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stoneSlabTopRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) stoneSlabTopRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Brick Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(bricksRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) bricksRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Nether Brick Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(netherRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) netherRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzBottomRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) quartzBottomRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzTopRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) quartzTopRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Chiseled Quartz Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzChiseledRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) quartzChiseledRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Piller Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzPillerTopRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) quartzPillerTopRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Chiseled Stone Bricks Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stonebrickChiseledRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) stonebrickChiseledRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Dark Prismarine Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(darkPrismarineRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) darkPrismarineRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Prismarine Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(prismarineRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) prismarineRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Compressed Cobblestone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(compressedCobbleRoadblock),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadblock) compressedCobbleRoadblock).getName()
						+ "_roadblock", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Compressed Cobblestone");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(compressedCobble),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((compressedCobble) compressedCobble).getName(),
						"inventory"));

	}

	public static void Slabs() {

		if (Config.debug)
			System.out.println("Registering CompressedCobble Roadblock Slab");
		compressedCobbleRoadslab = new roadslab(Material.rock,
				"CompressedCobble", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Default Roadblock Slab");
		defaultRoadslab = new roadslab(Material.rock, "Default",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Stone Roadblock Slab");
		stoneRoadslab = new roadslab(Material.rock, "Stone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Andesite Roadblock Slab");
		andesiteRoadslab = new roadslab(Material.rock, "Andesite",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Dirt Roadblock Slab");
		dirtRoadslab = new roadslab(Material.grass, "Dirt",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Coarse Dirt Roadblock Slab");
		coarseDirtRoadslab = new roadslab(Material.ground, "CoarseDirt",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Podzol Roadblock Slab");
		podzolRoadslab = new roadslab(Material.grass, "Podzol",
				Block.soundTypeGrass);

		if (Config.debug)
			System.out.println("Registering Cobblestone Roadblock Slab");
		cobbleRoadslab = new roadslab(Material.rock, "Cobblestone",
				Block.soundTypeStone);

		if (Config.debug)
			System.out.println("Registering Oak Roadblock Slab");
		oakRoadslab = new roadslab(Material.wood, "Oak", Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Spruce Roadblock Slab");
		spruceRoadslab = new roadslab(Material.wood, "Spruce",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Birch Roadblock Slab");
		birchRoadslab = new roadslab(Material.wood, "Birch",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Jungle Roadblock Slab");
		jungleRoadslab = new roadslab(Material.wood, "Jungle",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Acacia Roadblock Slab");
		acaciaRoadslab = new roadslab(Material.wood, "Acacia",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Dark Oak Roadblock Slab");
		darkOakRoadslab = new roadslab(Material.wood, "DarkOak",
				Block.soundTypeWood);

		if (Config.debug)
			System.out.println("Registering Sand Roadblock Slab");
		sandRoadslab = new roadslab(Material.sand, "Sand", Block.soundTypeSand);

		if (Config.debug)
			System.out.println("Registering Redsand Roadblock Slab");
		redsandRoadslab = new roadslab(Material.sand, "Redsand",
				Block.soundTypeSand);

		if (Config.debug)
			System.out.println("Registering Gravel Roadblock Slab");
		gravelRoadslab = new roadslab(Material.ground, "Gravel",
				Block.soundTypeGravel);

		if (Config.debug)
			System.out.println("Registering Sandstone Top Roadblock Slab");
		sandstoneTopRoadslab = new roadslab(Material.rock, "SandstoneTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out
					.println("Registering Red Sandstone Bottom Roadblock Slab");
		redSandstoneBottomRoadslab = new roadslab(Material.rock,
				"RedSandstoneBottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Red Sandstone Top Roadblock Slab");
		redSandstoneTopRoadslab = new roadslab(Material.rock,
				"RedSandstoneTop", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Roadblock Slab");
		sandstoneBottomRoadslab = new roadslab(Material.rock,
				"SandstoneBottom", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Stone Slab Roadblock Slab");
		stoneSlabTopRoadslab = new roadslab(Material.rock, "StoneSlabTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Brick Roadblock Slab");
		bricksRoadslab = new roadslab(Material.rock, "Brick",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Nether Brick Roadblock Slab");
		netherRoadslab = new roadslab(Material.rock, "NetherBrick",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Roadblock Slab");
		quartzBottomRoadslab = new roadslab(Material.rock, "QuartzBottom",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Top Roadblock Slab");
		quartzTopRoadslab = new roadslab(Material.rock, "QuartzTop",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Chiseled Quartz Roadblock Slab");
		quartzChiseledRoadslab = new roadslab(Material.rock, "QuartzChiseled",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Quartz Piller Top Roadblock Slab");
		quartzPillerTopRoadslab = new roadslab(Material.rock,
				"QuartzPillerTop", Block.soundTypePiston);

		if (Config.debug)
			System.out
					.println("Registering Chiseled Stone Bricks Roadblock Slab");
		stonebrickChiseledRoadslab = new roadslab(Material.rock,
				"ChiseledStonebrick", Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Dark Prismarine Roadblock Slab");
		darkPrismarineRoadslab = new roadslab(Material.rock, "DarkPrismarine",
				Block.soundTypePiston);

		if (Config.debug)
			System.out.println("Registering Prismarine Roadblock Slab");
		prismarineRoadslab = new roadslab(Material.rock, "Prismarine",
				Block.soundTypePiston);

	}

	public static void RenderSlabs() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		if (Config.debug)
			System.out.println("Rendering Default Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(defaultRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) defaultRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Stone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stoneRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) stoneRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Andesite Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(andesiteRoadslab),
				0,
				new ModelResourceLocation(
						Main.modid + ":"
								+ ((roadslab) andesiteRoadslab).getName()
								+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Dirt Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(dirtRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) dirtRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Coarse Dirt Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(coarseDirtRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) coarseDirtRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Podzol Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(podzolRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) podzolRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Cobblestone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(cobbleRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) cobbleRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Oak Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(oakRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) oakRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Spruce Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(spruceRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) spruceRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Birch Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(birchRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) birchRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Jungle Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(jungleRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) jungleRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Acacia Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(acaciaRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) acaciaRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Dark Oak Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(darkOakRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) darkOakRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Sand Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) sandRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sand Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redsandRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) redsandRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Gravel Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(gravelRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) gravelRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Sandstone Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandstoneTopRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) sandstoneTopRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Sandstone Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(sandstoneBottomRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) sandstoneBottomRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sandstone Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redSandstoneTopRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) redSandstoneTopRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Red Sandstone Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(redSandstoneBottomRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) redSandstoneBottomRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Stone Slab Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stoneSlabTopRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) stoneSlabTopRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Brick Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(bricksRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) bricksRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Nether Brick Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(netherRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) netherRoadslab).getName() + "_roadslab",
						"inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Bottom Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzBottomRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) quartzBottomRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzTopRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) quartzTopRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Chiseled Quartz Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzChiseledRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) quartzChiseledRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Quartz Piller Top Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(quartzPillerTopRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) quartzPillerTopRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Chiseled Stone Bricks Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(stonebrickChiseledRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) stonebrickChiseledRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Dark Prismarine Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(darkPrismarineRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) darkPrismarineRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Prismarine Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(prismarineRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) prismarineRoadslab).getName()
						+ "_roadslab", "inventory"));

		if (Config.debug)
			System.out.println("Rendering Compressed Cobblestone Roadblock");
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(compressedCobbleRoadslab),
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((roadslab) compressedCobbleRoadslab).getName()
						+ "_roadslab", "inventory"));
	}

	public static void Items() {
		
		ironMallet = new Mallet(0, Item.ToolMaterial.IRON, null);
	}

	public static void RenderItems() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(
				ironMallet,
				0,
				new ModelResourceLocation(Main.modid + ":"
						+ ((Mallet) ironMallet).getName(), "inventory"));
	}

	public static void Recipes() {
		// Register Recipes
		if (Config.debug)
			System.out.println("Registering Compressed Cobblestone Recipe");
		GameRegistry.addRecipe(new ItemStack(compressedCobble), new Object[] {
				"AAA", "AAA", "AAA", 'A', Blocks.cobblestone });

		if (Config.debug)
			System.out
					.println("Registering Compressed Cobblestone to Cobblestone Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 9),
				new Object[] { compressedCobble });

		if (Config.debug)
			System.out.println("Registering Roadblock Recipe");
		GameRegistry.addRecipe(new ItemStack(defaultRoadblock), new Object[] {
				"AAA", "ASS", "ASS", 'S',
				new ItemStack(Blocks.stone_slab, 1, 5) });

		if (Config.debug)
			System.out.println("Registering Sandstone Top Recipe");
		GameRegistry.addRecipe(new ItemStack(sandstoneTopRoadblock),
				new Object[] { "S  ", "R  ", "   ", 'S',
						new ItemStack(Blocks.sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Recipe");
		GameRegistry.addRecipe(new ItemStack(sandstoneBottomRoadblock),
				new Object[] { "R  ", "S  ", "   ", 'S',
						new ItemStack(Blocks.sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Red Sandstone Top Recipe");
		GameRegistry.addRecipe(new ItemStack(redSandstoneTopRoadblock),
				new Object[] { "S  ", "R  ", "   ", 'S',
						new ItemStack(Blocks.red_sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Red Sandstone Bottom Recipe");
		GameRegistry.addRecipe(new ItemStack(redSandstoneBottomRoadblock),
				new Object[] { "R  ", "S  ", "   ", 'S',
						new ItemStack(Blocks.red_sandstone, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Top Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzTopRoadblock),
				new Object[] { "S  ", "R  ", "   ", 'S',
						new ItemStack(Blocks.quartz_block, 1, 0), 'R',
						defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzBottomRoadblock),
				new Object[] { "R  ", "S  ", "   ", 'S',
						new ItemStack(Blocks.quartz_block, 1, 0), 'R',
						defaultRoadblock });
		// Register Slab Recipes
		if (Config.debug)
			System.out
					.println("Registering Compressed Cobblestone Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(compressedCobbleRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						compressedCobbleRoadblock });

		if (Config.debug)
			System.out.println("Registering Default Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(defaultRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', defaultRoadblock });

		if (Config.debug)
			System.out.println("Registering Stone Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(stoneRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', stoneRoadblock });

		if (Config.debug)
			System.out.println("Registering Andesite Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(andesiteRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A', andesiteRoadblock });

		if (Config.debug)
			System.out.println("Registering Dirt Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(dirtRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', dirtRoadblock });

		if (Config.debug)
			System.out.println("Registering Coarse Dirt Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(coarseDirtRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A', coarseDirtRoadblock });

		if (Config.debug)
			System.out.println("Registering Podzol Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(podzolRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', podzolRoadblock });

		if (Config.debug)
			System.out.println("Registering Cobblestone Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(cobbleRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', cobbleRoadblock });

		if (Config.debug)
			System.out.println("Registering Oak Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(oakRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', oakRoadblock });

		if (Config.debug)
			System.out.println("Registering Spruce Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(spruceRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', spruceRoadblock });

		if (Config.debug)
			System.out.println("Registering Birch Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(birchRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', birchRoadblock });

		if (Config.debug)
			System.out.println("Registering Jungle Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(jungleRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', jungleRoadblock });

		if (Config.debug)
			System.out.println("Registering Acacia Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(acaciaRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', acaciaRoadblock });

		if (Config.debug)
			System.out.println("Registering Dark Oak Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(darkOakRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', darkOakRoadblock });

		if (Config.debug)
			System.out.println("Registering Sand Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(sandRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', sandRoadblock });

		if (Config.debug)
			System.out.println("Registering Red sand Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(redsandRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', redsandRoadblock });

		if (Config.debug)
			System.out.println("Registering Gravel Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(gravelRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', gravelRoadblock });

		if (Config.debug)
			System.out.println("Registering Red Sandstone Top Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(redSandstoneTopRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						redSandstoneTopRoadblock });

		if (Config.debug)
			System.out.println("Registering Red Sandstone Bottom Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(redSandstoneBottomRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						redSandstoneBottomRoadblock });

		if (Config.debug)
			System.out.println("Registering Sandstone Top Slab Recipe");
		GameRegistry
				.addRecipe(new ItemStack(sandstoneTopRoadslab, 6),
						new Object[] { "   ", "   ", "AAA", 'A',
								sandstoneTopRoadblock });

		if (Config.debug)
			System.out.println("Registering Sandstone Bottom Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(sandstoneBottomRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						sandstoneBottomRoadblock });

		if (Config.debug)
			System.out.println("Registering Stone Slab Top Slab Recipe");
		GameRegistry
				.addRecipe(new ItemStack(stoneSlabTopRoadslab, 6),
						new Object[] { "   ", "   ", "AAA", 'A',
								stoneSlabTopRoadblock });

		if (Config.debug)
			System.out.println("Registering Brick Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(bricksRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', bricksRoadblock });

		if (Config.debug)
			System.out.println("Registering Nether Brick Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(netherRoadslab, 6), new Object[] {
				"   ", "   ", "AAA", 'A', netherRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Bottom Slab Recipe");
		GameRegistry
				.addRecipe(new ItemStack(quartzBottomRoadslab, 6),
						new Object[] { "   ", "   ", "AAA", 'A',
								quartzBottomRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Top Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzTopRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A', quartzTopRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Chiseled Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzChiseledRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						quartzChiseledRoadblock });

		if (Config.debug)
			System.out.println("Registering Quartz Piller Top Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(quartzPillerTopRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						quartzPillerTopRoadblock });

		if (Config.debug)
			System.out.println("Registering Chiseled Stone Brick Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(stonebrickChiseledRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						stonebrickChiseledRoadblock });

		if (Config.debug)
			System.out.println("Registering Dark Prismarine Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(darkPrismarineRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A',
						darkPrismarineRoadblock });

		if (Config.debug)
			System.out.println("Registering Prismarine Slab Recipe");
		GameRegistry.addRecipe(new ItemStack(prismarineRoadslab, 6),
				new Object[] { "   ", "   ", "AAA", 'A', prismarineRoadblock });

		// Register Shapeless Recipes
		if (Config.debug)
			System.out.println("Registering Stone Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(stoneRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.stone, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Andesite Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(andesiteRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.stone, 1, 5) });

		if (Config.debug)
			System.out.println("Registering Dirt Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(dirtRoadblock),
				new Object[] { defaultRoadblock, Blocks.dirt });

		if (Config.debug)
			System.out.println("Registering Coarse Dirt Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(coarseDirtRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.dirt, 1, 1) });

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

		if (Config.debug)
			System.out.println("Registering Prismarine Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(prismarineRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.prismarine, 1, 0) });

		if (Config.debug)
			System.out.println("Registering Dark Prismarine Roadblock Recipe");
		GameRegistry.addShapelessRecipe(new ItemStack(darkPrismarineRoadblock),
				new Object[] { defaultRoadblock,
						new ItemStack(Blocks.prismarine, 1, 2) });

		if (Config.debug)
			System.out
					.println("Registering Compressed Cobblestone Roadblock Recipe");
		GameRegistry.addShapelessRecipe(
				new ItemStack(compressedCobbleRoadblock), new Object[] {
						defaultRoadblock, compressedCobble });
	}

	public static Achievement buildRoad = (new Achievement(
			"achievement.buildRoad", "buildRoad", 0, 0, defaultRoadblock,
			(Achievement) null)).setIndependent().registerAchievement();

	public static void Achievements() {
		AchievementPage.registerAchievementPage(new AchievementPage(
				"Roadblocks", new Achievement[] { buildRoad }));
	}
}