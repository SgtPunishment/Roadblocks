package roadblock.particle;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import roadblock.Main;

public class Particle {

	public static float f = 0.125F;

	public static Block findBlockUnderEntity(Entity parEntity) {
		int blockX = MathHelper.floor_double(parEntity.posX);
		int blockY = MathHelper.floor_double(parEntity.boundingBox.minY)
				- (int) f;
		int blockZ = MathHelper.floor_double(parEntity.posZ);
		return parEntity.worldObj.getBlock(blockX, blockY, blockZ);
	}

	public static void particles(World world, int xCoord, int yCoord, int zCoord) {
		Random random = world.rand;
		double d0 = 0.0625D;

		for (int l = 0; l < 6; ++l) {
			double d1 = (double) ((float) xCoord + random.nextFloat());
			double d2 = (double) ((float) yCoord + random.nextFloat());
			double d3 = (double) ((float) zCoord + random.nextFloat());

			if (l == 0
					&& !world.getBlock(xCoord, yCoord + 1, zCoord)
							.isOpaqueCube()) {
				d2 = (double) (yCoord + 1) + d0;
			}

			if (l == 1
					&& !world.getBlock(xCoord, yCoord - 1, zCoord)
							.isOpaqueCube()) {
				d2 = (double) (yCoord + 0) - d0;
			}

			if (l == 2
					&& !world.getBlock(xCoord, yCoord, zCoord + 1)
							.isOpaqueCube()) {
				d3 = (double) (zCoord + 1) + d0;
			}

			if (l == 3
					&& !world.getBlock(xCoord, yCoord, zCoord - 1)
							.isOpaqueCube()) {
				d3 = (double) (zCoord + 0) - d0;
			}

			if (l == 4
					&& !world.getBlock(xCoord + 1, yCoord, zCoord)
							.isOpaqueCube()) {
				d1 = (double) (xCoord + 1) + d0;
			}

			if (l == 5
					&& !world.getBlock(xCoord - 1, yCoord, zCoord)
							.isOpaqueCube()) {
				d1 = (double) (xCoord + 0) - d0;
			}

			if (d1 < (double) xCoord || d1 > (double) (xCoord + 1) || d2 < 0.0D
					|| d2 > (double) (yCoord + 1) || d3 < (double) zCoord
					|| d3 > (double) (zCoord + 1)) {
				world.spawnParticle("heart", d1, d2, d3, 0.0D, 0.0D, 0.0D);
			}
		}
	}

}
