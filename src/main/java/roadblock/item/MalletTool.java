package roadblock.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import roadblock.Main;
import roadblock.block.Roadblock;
import roadblock.event.MalletEvent;
import roadblock.utils.Register;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MalletTool extends Item {
	private final String name = "ironMallet";

	protected Item.ToolMaterial theToolMaterial;

	public MalletTool(Item.ToolMaterial material) {
		this.theToolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Main.modid + "_" + name);
		setCreativeTab(Register.tabRoadBlock);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int xCoord, int yCoord, int zCoord, int side, float hitX,
			float hitY, float hitZ) {
		if (!player.canPlayerEdit(xCoord, yCoord, zCoord, side, stack)) {
			return false;
		} else {
			MalletEvent event = new MalletEvent(player, stack, world, xCoord,
					yCoord, zCoord);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}

			Block block = world.getBlock(xCoord, yCoord, zCoord);

			if (side != 0
					&& world.getBlock(xCoord, yCoord + 1, zCoord).isAir(world,
							xCoord, yCoord + 1, zCoord)
					&& (block instanceof Roadblock)) {
				Block block1 = world.getBlock(xCoord, yCoord, zCoord);
				world.playSoundEffect((double) ((float) xCoord + 0.5F),
						(double) ((float) yCoord + 0.5F),
						(double) ((float) zCoord + 0.5F),
						block1.stepSound.getStepResourcePath(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F,
						block1.stepSound.getPitch() * 0.8F);

				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(xCoord, yCoord, zCoord, block1);
					stack.damageItem(1, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("roadblock:ironmallet");
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public String getToolMaterialName() {
		return this.theToolMaterial.toString();
	}
}