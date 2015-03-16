package roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roadblock.Main;

public class compressedCobble extends Block {
	private final String name = "compressedCobble";

	public compressedCobble() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(Main.modid + "_" + name);
		setCreativeTab(Main.tabRoadBlock);
	}

	public String getName() {
		return name;
	}
}