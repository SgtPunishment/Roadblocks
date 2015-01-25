package RoadBlock.Items;

import RoadBlock.Main;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RBlocks_Item extends ItemBlock {
	public RBlocks_Item(Block block) {
		super(Main.Road_Block);

		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "RBlocks.RBlock";
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}