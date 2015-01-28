package roadblock.block;

import roadblock.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Road_block extends Block {
	public String Name;
	public String Texture;
	public IIcon blockIcon;
	public IIcon top;
	public IIcon podzol;
	public IIcon dirt;

	public Road_block(Material materialName, String blockName,
			String blockTexture) {
		super(materialName);
		if (blockName != null) {
			this.setBlockName(blockName + "_RBlocks_RoadBlock");
		} else {
			this.setBlockName("RBlocks_RoadBlock");
		}
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
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
			f4 = 0.9375F;
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world,
			int xCoord, int yCoord, int zCoord) {
		float f = 0.125F;
		return AxisAlignedBB.getBoundingBox((double) xCoord, (double) yCoord,
				(double) zCoord, (double) (xCoord + 1),
				(double) (yCoord + 1 - f), (double) (zCoord + 1));
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord,
			int zCoord, Entity entity) {
		// Code from Chisel {
		double TSpeed = Math.sqrt(entity.motionX * entity.motionX
				+ entity.motionZ * entity.motionZ);
		if (!(entity instanceof EntityPlayerSP))
			return;

		if (TSpeed == 0)
			return;

		if (TSpeed >= Config.speed)
			return;

		EntityPlayerSP player = (EntityPlayerSP) entity;
		if (Math.abs(player.movementInput.moveStrafe) < 0.75f
				&& Math.abs(player.movementInput.moveForward) < 0.75f)
			return;

		entity.motionX = Config.speed * entity.motionX / TSpeed;
		entity.motionZ = Config.speed * entity.motionZ / TSpeed;
		// }
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (Texture == "roadBlock") {
			if (side == 1) {
				return this.top;
			} else {

			}
		} else if (Texture == "podzol") {
			if (side == 1) {
				return this.podzol;
			} else if (side == 0) {
				return this.dirt;
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
		} else if (Texture == "podzol") {
			this.podzol = register.registerIcon("dirt_podzol_top");
			this.blockIcon = register.registerIcon("dirt_podzol_side");
			this.dirt = register.registerIcon("dirt");
		} else {
			this.blockIcon = register.registerIcon(Texture);
		}
	}
}