package roadblock.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import roadblock.Main;
import roadblock.utils.Register;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MalletTool extends Item {
	public final String name = "Mallet";

	public Item.ToolMaterial theToolMaterial;

	public MalletTool(Item.ToolMaterial material) {
		this.theToolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		GameRegistry.registerItem(this, getToolMaterialName().toLowerCase()
				+ name);
		setUnlocalizedName(Main.modid + "_"
				+ getToolMaterialName().toLowerCase() + name);
		setCreativeTab(Register.tabRoadBlock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("roadblock:"
				+ getToolMaterialName().toLowerCase() + "mallet");
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public String getToolMaterialName() {
		return this.theToolMaterial.toString();
	}
}