package roadblock.block;

import roadblock.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Road_block_slab extends Block {
	public String Name;
	public String Texture;
	public IIcon blockIcon;
	public IIcon top;

	public Road_block_slab(Material materialName, String blockName,
			String blockTexture) {
		super(Material.grass);
		if (blockName != null) {
			this.setBlockName(blockName + "_RBlocks_RoadBlock_Slab");
		} else {
			this.setBlockName("RBlocks_RoadBlock_Slab");
		}
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.4F, 1F);
		this.setLightOpacity(255);
		this.useNeighborBrightness = true;
		Name = blockName;
		Texture = blockTexture;
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
			f4 = 0.4F;
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.4, z + 1);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

//	@Override
//	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
//		float speed = Config.speed;
//		float max = Config.max;
//		if (entity.motionX <= max)
//			entity.motionX *= speed;
//		if (entity.motionZ <= max)
//			entity.motionZ *= speed;
//
//		// double motionX = Math.abs(entity.motionX);
//		// double motionZ = Math.abs(entity.motionZ);
//		// if (motionX < max) entity.motionX *= speed;
//		// if (motionZ < max) entity.motionZ *= speed;
//	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (Texture == "roadBlock") {
			if (side == 1) {
				return this.top;
			} else {

			}
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		if (Texture == "roadBlock") {
			this.top = register.registerIcon("roadBlock:roadBlock");
			this.blockIcon = register.registerIcon("stonebrick");
		} else {
			this.blockIcon = register.registerIcon(Texture);
		}
	}
}