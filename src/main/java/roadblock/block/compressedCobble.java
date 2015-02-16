package roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class compressedCobble extends Block {

	public String name = "compressedCobblestone";

	public compressedCobble() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockName(name);
		setCreativeTab(Register.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setHardness(1.5F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon("furnace_top");
	}
}
