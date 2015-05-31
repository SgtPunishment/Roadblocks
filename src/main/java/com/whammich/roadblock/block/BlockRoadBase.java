package com.whammich.roadblock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.whammich.roadblock.Roadblock;
import com.whammich.roadblock.utils.Config;
import com.whammich.roadblock.utils.LogHelper;
import com.whammich.roadblock.utils.Reference;
import com.whammich.roadblock.utils.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRoadBase extends Block {

	int speed;
	private Block block = null;
	int blockMeta = 0;

	private int blockNum;
	float slippy = 0.4F;

	/**
	 *
	 * @param unlocName
	 *            - Unlocalized name to give to the block. Gets prefixed with
	 *            the modid and suffixed with ".roadblock"
	 * @param textureName
	 *            - Name of the texture to use for the block
	 * @param material
	 *            - Material of the block
	 * @param soundType
	 *            - Sound type of the block
	 */
	public BlockRoadBase(String unlocName, String textureName, Material material, SoundType soundType) {
		super(material);
		setBlockName(Reference.modid + "." + unlocName + ".roadblock");
		setBlockTextureName(textureName);
		setCreativeTab(Roadblock.tabRoadblocks);
		setStepSound(soundType);
		setHardness(1.5F);
		this.slipperiness = slippy;
		LogHelper.info("Registering roadblock with name: " + getLocalizedName());
	}

	public int getBlockNum() {
		return this.blockNum;
	}

	/**
	 *
	 * @param block
	 *            - Block to get Name, Texture, and Material from
	 * @param blockMeta
	 *            - Meta of the block to get Name, Texture, and Material from
	 * @param soundType
	 *            - Soundtype of the roadblock
	 */
	public BlockRoadBase(Block block, int blockMeta, SoundType soundType) {
		super(block.getMaterial());

		setBlockName(Reference.modid + ".road");
		setCreativeTab(Roadblock.tabRoadblocks);
		setStepSound(soundType);
		setHardness(1.5F);

		this.block = block;
		this.blockMeta = blockMeta;

		LogHelper.info("Registering roadblock for block: " + block.getLocalizedName());
		ItemStack blockStack = new ItemStack(block, 1, blockMeta);

		GameRegistry.registerBlock(this, "BlockRoad" + blockStack.getDisplayName().replaceAll(" ", ""));
		GameRegistry.addRecipe(new ShapedOreRecipe(this, "SBS", 'S',
				Register.roadblockDefault, 'B', new ItemStack(block, Config.returnBlocks, blockMeta)));
		this.slipperiness = slippy;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		setBlockBoundsBasedOnState(world, x, y, z);
		//LogHelper.info("onNeighborBlockChange Called");
	}

	@Override
	public String getUnlocalizedName() {
		if (block != null) {
			ItemStack blockStack = new ItemStack(block, 1, blockMeta);
			return String.format(
					StatCollector.translateToLocal("tile.roadblock.road.name"), blockStack.getDisplayName());
		}

		return super.getUnlocalizedName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (block != null)
			return block.getIcon(side, blockMeta);
		else
			return blockIcon;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

		int meta = world.getBlockMetadata(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);

		if (!blockAbove.isAir(world, x, y + 1, z)){
			setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
			//LogHelper.info("air setBlockBounds Called");
		} else {
			if (meta == 0){
				setBlockBounds(0F, 0F, 0F, 1F, 0.9375F, 1F);
				//LogHelper.info("full setBlockBounds Called");
			} else{
				//LogHelper.info("half setBlockBounds Called");
				setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
			}
		}
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {

		int meta = world.getBlockMetadata(x, y, x);
		if(meta == 0) {//Or whichever mob you want to block
			setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
			//LogHelper.info("full2 setBlockBounds Called");
		} else {
			setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
			//LogHelper.info("half2 setBlockBounds Called");
		}
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
	}

	//	@Override
	//	public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord, int zCoord, Entity entity) {
	//		if (Config.speedOn) {
	//			if (entity instanceof EntityLivingBase) {
	//				if (Config.speed > 9) {
	//					speed = 9;
	//				} else {
	//					speed = Config.speed;
	//				}
	//				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
	//						Potion.moveSpeed.id, 0, speed));
	//			}
	//		}
	//	}
}