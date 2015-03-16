package roadblock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roadblock.Main;
import roadblock.utils.Config;

public class roadslab extends Block {

	private String name;
	private int speed;

	public roadslab(Material material, String string, SoundType stepsound) {
		super(material);
		name = string;
		GameRegistry.registerBlock(this, name + "_roadslab").setStepSound(
				stepsound);
		setUnlocalizedName(Main.modid + "_" + name + "_roadslab");
		setCreativeTab(Main.tabRoadBlock);
		setLightOpacity(255);
		useNeighborBrightness = true;
		setBlockBounds(0F, 0F, 0F, 1F, 0.4375F, 1F);
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
}