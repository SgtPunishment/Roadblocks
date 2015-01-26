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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import RoadBlock.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RBlocks_Block extends Block {

	private IIcon top;

	public RBlocks_Block() {
		super(Material.rock);
		// super(Material materialName, String blockName, String blockTexture);
		this.setBlockName("RBlocks_RoadBlock");
		// this.setBlockName(blockName + " RBlocks_RoadBlock");
		this.setBlockBounds(0F, 0F, 0F, 1F, 15F / 16F, 1F);
		this.setLightOpacity(255);
		this.useNeighborBrightness = true;
	}

	private boolean isFullRoad(IBlockAccess type, int x, int y, int z) {
		Block block = type.getBlock(x, y, z);
		// add blocks here that wont make a road a full block
		return block == Blocks.fence_gate || block == Blocks.air
				|| block == Blocks.torch;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y,
			int z) {
		boolean airabove = this.isFullRoad(block, x, y + 1, z);
		float f4 = 1F;

		if (airabove) {
			f4 = 0.9375F;
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1,
				(float) (y + 0.9375), z + 1);
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
		if (side == 1) {
			return this.top;
		} else {
			return blockIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.top = register.registerIcon("roadblock:road_block");
		this.blockIcon = register.registerIcon("stonebrick");
		// this.blockIcon = register.registerIcon(blockTexture);
	}
}