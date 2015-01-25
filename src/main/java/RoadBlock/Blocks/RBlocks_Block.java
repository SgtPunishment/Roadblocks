package RoadBlock.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import RoadBlock.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RBlocks_Block extends Block {
	public RBlocks_Block() {
		super(Material.rock);
		// super(materialName);
		this.setBlockName("RBlocks_RoadBlock");
		// this.setBlockName(blockName + " RBlocks_RoadBlock");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		this.setLightOpacity(255);
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world,
			int xCoord, int yCoord, int zCoord) {
		float f = 0.1F;
		return AxisAlignedBB.getBoundingBox((double) xCoord, (double) yCoord,
				(double) zCoord, (double) (xCoord + 1),
				(double) ((float) (yCoord + 1) - f), (double) (zCoord + 1));
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord,
			int zCoord, Entity entity) {
		entity.motionX *= 1.1D;
		entity.motionZ *= 1.1D;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon("minecraft:stonebrick");
		// this.blockIcon = register.registerIcon(blockTexture);
	}
}