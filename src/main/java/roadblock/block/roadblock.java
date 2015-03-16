package roadblock.block;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roadblock.Main;
import roadblock.utils.Config;
import roadblock.utils.Register;

public class roadblock extends Block {

	private String name;
	private int speed;

	public roadblock(Material material, String string, SoundType stepsound) {
		super(material);
		name = string;
		GameRegistry.registerBlock(this, name + "_roadblock").setStepSound(
				stepsound);
		setUnlocalizedName(Main.modid + "_" + name + "_roadblock");
		setCreativeTab(Main.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
		setHardness(1.5F);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public String getName() {
		return name;
	}

	public int damageDropped(IBlockState state) {
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 2; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	// private boolean isFullRoad(IBlockAccess type, int x, int y, int z) {
	// Block block = type.getBlockState(pos).getBlock();
	// // add blocks here that wont make a road a full block
	// return block == Blocks.fence_gate || block == Blocks.air
	// || block == Blocks.torch;
	// }

	@SuppressWarnings("rawtypes")
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {

		Collection meta = world.getBlockState(pos).getPropertyNames();
		System.out.println(meta);
		// boolean airabove = this.isFullRoad(block, x, y + 1, z);
		//
		// float f4 = 0.9375F;
		//
		// if (meta == 0) {
		// this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		// // System.out.println("Metadata Value: " + meta);
		// } else if (meta == 1) {
		// this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.4375F, 1.0F);
		// // System.out.println("Metadata Value: " + meta);
		// } else {
		//
		// if (airabove && meta == 0) {
		// f4 = 1.0F;
		// }
		// // System.out.println("Metadata Value: " + meta);
		// this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f4, 1.0F);
		// }

		// System.out.println("when do I get here?" + meta);
	}

	@SuppressWarnings({ "rawtypes" })
	public void addCollisionBoxesToList(World world, BlockPos pos,
			IBlockState state, AxisAlignedBB mask, List list, Entity entity) {
		setBlockBoundsBasedOnState(world, pos);
		super.addCollisionBoxesToList(world, pos, state, mask, list, entity);
	}

	@SuppressWarnings("unused")
	public boolean onBlockActivated(World world, BlockPos pos,
			IBlockState state, EntityPlayer player, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem();
			if (stack != null && stack.getItem() == Register.ironMallet) {
				IBlockState meta = world.getBlockState(pos);

				// switch (meta) {
				//
				// case 0:
				// System.out.println("Metadata Value: " + meta);
				// world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1,
				// 2);
				// world.markBlockForUpdate(xCoord, yCoord, zCoord);
				// break;
				// case 1:
				// System.out.println("Metadata Value: " + meta);
				// world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0,
				// 2);
				// world.markBlockForUpdate(xCoord, yCoord, zCoord);
				// break;
				// case 2:
				// System.out.println("Metadata Value: " + meta);
				// break;
				//
				// }
			}
		}
		return true;
	}

	public void onEntityCollidedWithBlock(World world, BlockPos pos,
			IBlockState state, Entity entity) {

		if (entity instanceof EntityLivingBase) {
			if (Config.speed > 9) {
				speed = 9;
			} else {
				speed = Config.speed;
			}
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
					Potion.moveSpeed.id, 0, speed));
		}
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

}