package roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import roadblock.Main;
import roadblock.utils.Creative_Tab;
import cpw.mods.fml.common.registry.GameRegistry;

public class Regblocks {

	public static Creative_Tab tabRoadBlock = new Creative_Tab();

	public static String dename = "";
	public static String detexture = "roadBlock";
	public static String dname = "Dirt";
	public static String dtexture = "dirt";
	public static String sname = "Sand";
	public static String stexture = "sand";
	public static String gname = "Gravel";
	public static String gtexture = "gravel";
	public static String pname = "Podzol";
	public static String ptexture = "podzol";
	public static String cname = "Cobblestone";
	public static String ctexture = "cobblestone";
	public static String waname = "Acacia_Planks";
	public static String watexture = "acacia";
	public static String wboname = "Dark_Oak_Planks";
	public static String wbotexture = "big_oak";
	public static String wbname = "Birch_Planks";
	public static String wbtexture = "birch";
	public static String wjname = "Jungle_Planks";
	public static String wjtexture = "jungle";
	public static String woname = "Oak_Planks";
	public static String wotexture = "oak";
	public static String wsname = "Spruce_Planks";
	public static String wstexture = "spruce";
	public static String rsname = "Red_Sand";
	public static String rstexture = "red_sand";
	public static String bname = "Brick";
	public static String btexture = "brick";

	// Full Blocks

	public static Block Road_Block = new Road_block(Material.ground, dename,
			detexture);
	public static Block Dirt_Road_Block = new Road_block(Material.grass, dname,
			dtexture);
	public static Block Sand_Road_Block = new Road_block(Material.sand, sname,
			stexture);
	public static Block Gravel_Road_Block = new Road_block(Material.ground,
			gname, gtexture);
	public static Block Podzol_Road_Block = new Road_block(Material.grass,
			pname, ptexture);
	public static Block Cobble_Road_Block = new Road_block(Material.rock,
			cname, ctexture);
	public static Block Acacia_Road_Block = new Road_block(Material.wood,
			waname, "planks_" + watexture);
	public static Block Dark_Oak_Road_Block = new Road_block(Material.wood,
			wboname, "planks_" + wbotexture);
	public static Block Birch_Road_Block = new Road_block(Material.wood,
			wbname, "planks_" + wbtexture);
	public static Block Jungle_Road_Block = new Road_block(Material.wood,
			wjname, "planks_" + wjtexture);
	public static Block Oak_Road_Block = new Road_block(Material.wood, woname,
			"planks_" + wotexture);
	public static Block Spruce_Road_Block = new Road_block(Material.wood,
			wsname, "planks_" + wstexture);
	public static Block Redsand_Road_Block = new Road_block(Material.sand,
			rsname, rstexture);
	public static Block Brick_Road_Block = new Road_block(Material.rock, bname,
			btexture);

	// Half Slabs
	// public static Block Road_Block_slab = new
	// Road_block_slab(Material.ground, dename, detexture);
	// public static Block Dirt_Road_Block_slab = new
	// Road_block_slab(Material.ground, dname, dtexture);
	// public static Block Sand_Road_Block_slab = new
	// Road_block_slab(Material.ground, sname, stexture);
	// public static Block Gravel_Road_Block_slab = new
	// Road_block_slab(Material.ground, gname, gtexture);

	public static void RegisterBlocks() {
		// Register Full Blocks

		GameRegistry.registerBlock(Road_Block, "RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(1.5F);

		GameRegistry.registerBlock(Dirt_Road_Block, dname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeGravel).setHardness(0.5F);

		GameRegistry.registerBlock(Sand_Road_Block, sname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeSand)
				.setHardness(0.5F);

		GameRegistry.registerBlock(Gravel_Road_Block, gname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeGravel).setHardness(0.6F);

		GameRegistry.registerBlock(Podzol_Road_Block, pname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeGravel).setHardness(0.5F);

		GameRegistry.registerBlock(Cobble_Road_Block, cname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F);

		GameRegistry.registerBlock(Oak_Road_Block, woname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F)
				.setResistance(5.0F);

		GameRegistry.registerBlock(Spruce_Road_Block, wsname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F)
				.setResistance(5.0F);

		GameRegistry.registerBlock(Birch_Road_Block, wbname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F)
				.setResistance(5.0F);

		GameRegistry.registerBlock(Jungle_Road_Block, wjname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F)
				.setResistance(5.0F);

		GameRegistry.registerBlock(Acacia_Road_Block, waname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeWood)
				.setHardness(2.0F).setResistance(5.0F);

		GameRegistry
				.registerBlock(Dark_Oak_Road_Block, wboname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypeStone).setHardness(2.0F)
				.setResistance(5.0F);

		GameRegistry
				.registerBlock(Redsand_Road_Block, rsname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeSand)
				.setHardness(0.5F);

		GameRegistry.registerBlock(Brick_Road_Block, bname + "_RBlocks_Road")
				.setCreativeTab(tabRoadBlock)
				.setStepSound(Block.soundTypePiston).setHardness(2.0F)
				.setResistance(10.0F);

		// Register Half Slabs

		// GameRegistry.registerBlock(Road_Block_slab,
		// "RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeStone).setHardness(1.5F);
		//
		// GameRegistry.registerBlock(Dirt_Road_Block_slab, dname +
		// "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.5F);
		//
		// GameRegistry.registerBlock(Sand_Road_Block_slab, sname +
		// "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeSand).setHardness(0.5F);
		//
		// GameRegistry.registerBlock(Gravel_Road_Block_slab, gname +
		// "_RBlocks_Road_Slab").setCreativeTab(tabRoadBlock).setStepSound(Block.soundTypeGravel).setHardness(0.6F);

		// Register Recipes

		GameRegistry.addShapedRecipe(new ItemStack(Regblocks.Road_Block),
				"AAA", "ASS", "ASS", 'S', Blocks.stone_slab);

		GameRegistry.addShapelessRecipe(
				new ItemStack(Regblocks.Dirt_Road_Block), new Object[] {
						Regblocks.Road_Block, Blocks.dirt });

		GameRegistry.addShapelessRecipe(
				new ItemStack(Regblocks.Sand_Road_Block), new Object[] {
						Regblocks.Road_Block, Blocks.sand });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Gravel_Road_Block), new Object[] {
				Regblocks.Road_Block, Blocks.gravel });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Podzol_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.dirt, 1, 2) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Cobble_Road_Block), new Object[] {
				Regblocks.Road_Block, Blocks.cobblestone });

		GameRegistry.addShapelessRecipe(
				new ItemStack(Regblocks.Oak_Road_Block), new Object[] {
						Regblocks.Road_Block,
						new ItemStack(Blocks.planks, 1, 0) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Spruce_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.planks, 1, 1) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Birch_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.planks, 1, 2) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Jungle_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.planks, 1, 3) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Acacia_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.planks, 1, 4) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Dark_Oak_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.planks, 1, 5) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Redsand_Road_Block), new Object[] {
				Regblocks.Road_Block, new ItemStack(Blocks.sand, 1, 1) });
		
		GameRegistry.addShapelessRecipe(new ItemStack(
				Regblocks.Brick_Road_Block), new Object[] {
				Regblocks.Road_Block, Blocks.brick_block });
		
	}
}
