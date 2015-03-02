package com.whammich.roadblock.renderer;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class CTM {
	public static int getTex(IBlockAccess world, int x, int y, int z, int side) {
		if (world == null)
			return 0;

		int tex = 0;
		Block block = world.getBlock(x, y, z);

		boolean b[] = new boolean[6];
		if (side <= 1) {
			b[0] = isConnected(world, x - 1, y, z, side, block);
			b[1] = isConnected(world, x + 1, y, z, side, block);
			b[2] = isConnected(world, x, y, z + 1, side, block);
			b[3] = isConnected(world, x, y, z - 1, side, block);
		} else if (side == 2) {
			b[0] = isConnected(world, x + 1, y, z, side, block);
			b[1] = isConnected(world, x - 1, y, z, side, block);
			b[2] = isConnected(world, x, y - 1, z, side, block);
			b[3] = isConnected(world, x, y + 1, z, side, block);
		} else if (side == 3) {
			b[0] = isConnected(world, x - 1, y, z, side, block);
			b[1] = isConnected(world, x + 1, y, z, side, block);
			b[2] = isConnected(world, x, y - 1, z, side, block);
			b[3] = isConnected(world, x, y + 1, z, side, block);
		} else if (side == 4) {
			b[0] = isConnected(world, x, y, z - 1, side, block);
			b[1] = isConnected(world, x, y, z + 1, side, block);
			b[2] = isConnected(world, x, y - 1, z, side, block);
			b[3] = isConnected(world, x, y + 1, z, side, block);
		} else if (side == 5) {
			b[0] = isConnected(world, x, y, z + 1, side, block);
			b[1] = isConnected(world, x, y, z - 1, side, block);
			b[2] = isConnected(world, x, y - 1, z, side, block);
			b[3] = isConnected(world, x, y + 1, z, side, block);
		}
		if (b[0] & !b[1] & !b[2] & !b[3])
			tex = 3;
		else if (!b[0] & b[1] & !b[2] & !b[3])
			tex = 1;
		else if (!b[0] & !b[1] & b[2] & !b[3])
			tex = 16;
		else if (!b[0] & !b[1] & !b[2] & b[3])
			tex = 48;
		else if (b[0] & b[1] & !b[2] & !b[3])
			tex = 2;
		else if (!b[0] & !b[1] & b[2] & b[3])
			tex = 32;
		else if (b[0] & !b[1] & b[2] & !b[3])
			tex = 19;
		else if (b[0] & !b[1] & !b[2] & b[3])
			tex = 51;
		else if (!b[0] & b[1] & b[2] & !b[3])
			tex = 17;
		else if (!b[0] & b[1] & !b[2] & b[3])
			tex = 49;
		else if (!b[0] & b[1] & b[2] & b[3])
			tex = 33;
		else if (b[0] & !b[1] & b[2] & b[3])
			tex = 35;
		else if (b[0] & b[1] & !b[2] & b[3])
			tex = 50;
		else if (b[0] & b[1] & b[2] & !b[3])
			tex = 18;
		else if (b[0] & b[1] & b[2] & b[3])
			tex = 34;

		boolean b2[] = new boolean[6];
		if (side <= 1) {
			b2[0] = !isConnected(world, x + 1, y, z + 1, side, block);
			b2[1] = !isConnected(world, x - 1, y, z + 1, side, block);
			b2[2] = !isConnected(world, x + 1, y, z - 1, side, block);
			b2[3] = !isConnected(world, x - 1, y, z - 1, side, block);
		} else if (side == 2) {
			b2[0] = !isConnected(world, x - 1, y - 1, z, side, block);
			b2[1] = !isConnected(world, x + 1, y - 1, z, side, block);
			b2[2] = !isConnected(world, x - 1, y + 1, z, side, block);
			b2[3] = !isConnected(world, x + 1, y + 1, z, side, block);
		} else if (side == 3) {
			b2[0] = !isConnected(world, x + 1, y - 1, z, side, block);
			b2[1] = !isConnected(world, x - 1, y - 1, z, side, block);
			b2[2] = !isConnected(world, x + 1, y + 1, z, side, block);
			b2[3] = !isConnected(world, x - 1, y + 1, z, side, block);
		} else if (side == 4) {
			b2[0] = !isConnected(world, x, y - 1, z + 1, side, block);
			b2[1] = !isConnected(world, x, y - 1, z - 1, side, block);
			b2[2] = !isConnected(world, x, y + 1, z + 1, side, block);
			b2[3] = !isConnected(world, x, y + 1, z - 1, side, block);
		} else if (side == 5) {
			b2[0] = !isConnected(world, x, y - 1, z - 1, side, block);
			b2[1] = !isConnected(world, x, y - 1, z + 1, side, block);
			b2[2] = !isConnected(world, x, y + 1, z - 1, side, block);
			b2[3] = !isConnected(world, x, y + 1, z + 1, side, block);
		}

		if (tex == 17 && b2[0])
			tex = 4;
		if (tex == 19 && b2[1])
			tex = 5;
		if (tex == 49 && b2[2])
			tex = 20;
		if (tex == 51 && b2[3])
			tex = 21;

		if (tex == 18 && b2[0] && b2[1])
			tex = 7;
		if (tex == 33 && b2[0] && b2[2])
			tex = 6;
		if (tex == 35 && b2[3] && b2[1])
			tex = 23;
		if (tex == 50 && b2[3] && b2[2])
			tex = 22;

		if (tex == 18 && !b2[0] && b2[1])
			tex = 39;
		if (tex == 33 && b2[0] && !b2[2])
			tex = 38;
		if (tex == 35 && !b2[3] && b2[1])
			tex = 53;
		if (tex == 50 && b2[3] && !b2[2])
			tex = 52;

		if (tex == 18 && b2[0] && !b2[1])
			tex = 37;
		if (tex == 33 && !b2[0] && b2[2])
			tex = 36;
		if (tex == 35 && b2[3] && !b2[1])
			tex = 55;
		if (tex == 50 && !b2[3] && b2[2])
			tex = 54;

		if (tex == 34 && b2[0] && b2[1] && b2[2] && b2[3])
			tex = 58;

		if (tex == 34 && !b2[0] && b2[1] && b2[2] && b2[3])
			tex = 9;
		if (tex == 34 && b2[0] && !b2[1] && b2[2] && b2[3])
			tex = 25;
		if (tex == 34 && b2[0] && b2[1] && !b2[2] && b2[3])
			tex = 8;
		if (tex == 34 && b2[0] && b2[1] && b2[2] && !b2[3])
			tex = 24;

		if (tex == 34 && b2[0] && b2[1] && !b2[2] && !b2[3])
			tex = 11;
		if (tex == 34 && !b2[0] && !b2[1] && b2[2] && b2[3])
			tex = 26;
		if (tex == 34 && !b2[0] && b2[1] && !b2[2] && b2[3])
			tex = 27;
		if (tex == 34 && b2[0] && !b2[1] && b2[2] && !b2[3])
			tex = 10;

		if (tex == 34 && b2[0] && !b2[1] && !b2[2] && b2[3])
			tex = 42;
		if (tex == 34 && !b2[0] && b2[1] && b2[2] && !b2[3])
			tex = 43;

		if (tex == 34 && b2[0] && !b2[1] && !b2[2] && !b2[3])
			tex = 40;
		if (tex == 34 && !b2[0] && b2[1] && !b2[2] && !b2[3])
			tex = 41;
		if (tex == 34 && !b2[0] && !b2[1] && b2[2] && !b2[3])
			tex = 56;
		if (tex == 34 && !b2[0] && !b2[1] && !b2[2] && b2[3])
			tex = 57;
		return tex;
	}

	private static boolean isConnected(IBlockAccess world, int x, int y, int z,
			int side, Block block) {
		int x2 = x, y2 = y, z2 = z;

		switch (side) {
		case 0:
			y2--;
			break;
		case 1:
			y2++;
			break;
		case 2:
			z2--;
			break;
		case 3:
			z2++;
			break;
		case 4:
			x2--;
			break;
		case 5:
			x2++;
			break;
		}

		return getBlock(world, x, y, z, side).equals(block)
				&& (!getBlock(world, x2, y2, z2, side).equals(block));
	}

	private static Block getBlock(IBlockAccess world, int x, int y, int z,
			int side) {
		Block zega = world.getBlock(x, y, z);
		return zega;
	}

	static int submaps[][] = { { 16, 17, 18, 19 }, { 16, 9, 18, 13 },
			{ 8, 9, 12, 13 }, { 8, 17, 12, 19 }, { 16, 9, 6, 15 },
			{ 8, 17, 14, 7 }, { 2, 11, 6, 15 }, { 8, 9, 14, 15 },
			{ 10, 1, 14, 15 }, { 10, 11, 14, 5 }, { 0, 11, 4, 15 },
			{ 0, 1, 14, 15 }, {}, {}, {}, {}, { 16, 17, 6, 7 },
			{ 16, 9, 6, 5 }, { 8, 9, 4, 5 }, { 8, 17, 4, 7 },
			{ 2, 11, 18, 13 }, { 10, 3, 12, 19 }, { 10, 11, 12, 13 },
			{ 10, 3, 14, 7 }, { 0, 11, 14, 15 }, { 10, 11, 4, 15 },
			{ 10, 11, 4, 5 }, { 10, 1, 14, 5 }, {}, {}, {}, {}, { 2, 3, 6, 7 },
			{ 2, 1, 6, 5 }, { 0, 1, 4, 5 }, { 0, 3, 4, 7 }, { 2, 11, 6, 5 },
			{ 8, 9, 4, 15 }, { 2, 1, 6, 15 }, { 8, 9, 14, 5 }, { 0, 1, 4, 15 },
			{ 0, 1, 14, 5 }, { 10, 1, 4, 15 }, { 0, 11, 14, 5 }, {}, {}, {},
			{}, { 2, 3, 18, 19 }, { 2, 1, 18, 13 }, { 0, 1, 12, 13 },
			{ 0, 3, 12, 19 }, { 10, 1, 12, 13 }, { 0, 3, 14, 7 },
			{ 0, 11, 12, 13 }, { 10, 3, 4, 7 }, { 0, 11, 4, 5 },
			{ 10, 1, 4, 5 }, { 10, 11, 14, 15 }, { 0, 1, 4, 5 }, {}, {}, {},
			{}, };

	public static int[] getSubmapIndices(IBlockAccess world, int x, int y,
			int z, int side) {
		int index = getTex(world, x, y, z, side);

		return submaps[index];
	}
}
