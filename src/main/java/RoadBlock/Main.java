package RoadBlock;

import net.minecraft.block.Block;
import RoadBlock.Blocks.RBlocks_Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Main.modid, name = Main.name, version = Main.version)
public class Main {
	public static final String modid = "RBlocks";
	public static final String name = "Road Blocks";
	public static final String version = "0.0.2";
	public static Block Road_Block = new RBlocks_Block();

	public static CreativeTabs tabRoadBlocks = new CreativeTabs("RBlocks_Tab") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.stonebrick);
		}
	};

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerBlock(Road_Block, "RBlocks_Road").setCreativeTab(
				tabRoadBlocks);
		GameRegistry.addShapedRecipe(new ItemStack(Main.Road_Block), "AAA",
				"ASS", "ASS", 'S', Blocks.stone_slab);
	}
}
