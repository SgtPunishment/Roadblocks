package roadblock.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import roadblock.Main;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Mallet extends Item {

	private final String name = "ironMallet";

	public Mallet() {
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Main.modid + "_" + name);
		setCreativeTab(Register.tabRoadBlock);
	}

	public String getName() {
		return name;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("roadblock:ironmallet");
	}
}
