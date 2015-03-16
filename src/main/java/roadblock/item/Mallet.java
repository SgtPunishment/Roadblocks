package roadblock.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roadblock.Main;
import roadblock.utils.Register;

import com.google.common.collect.Sets;

public class Mallet extends ItemTool {
	private final String name = "ironMallet";

	@SuppressWarnings("rawtypes")
	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {
			Register.acaciaRoadblock, Register.andesiteRoadblock,
			Register.birchRoadblock, Register.bricksRoadblock,
			Register.coarseDirtRoadblock, Register.cobbleRoadblock,
			Register.compressedCobble, Register.compressedCobbleRoadblock,
			Register.darkOakRoadblock, Register.darkPrismarineRoadblock,
			Register.defaultRoadblock, Register.dirtRoadblock,
			Register.gravelRoadblock, Register.jungleRoadblock,
			Register.netherRoadblock, Register.oakRoadblock,
			Register.podzolRoadblock, Register.prismarineRoadblock,
			Register.quartzBottomRoadblock, Register.quartzChiseledRoadblock,
			Register.quartzPillerTopRoadblock, Register.quartzTopRoadblock,
			Register.sandRoadblock, Register.sandstoneBottomRoadblock,
			Register.sandstoneTopRoadblock, Register.redsandRoadblock,
			Register.redSandstoneBottomRoadblock,
			Register.redSandstoneTopRoadblock, Register.spruceRoadblock,
			Register.stonebrickChiseledRoadblock, Register.stoneRoadblock,
			Register.stoneSlabTopRoadblock });

	protected float efficiencyOnProperMaterial = 4.0F;

	/** Damage versus entities. */
	@SuppressWarnings("unused")
	private float damageVsEntity;

	protected int maxStackSize = 1;

	@SuppressWarnings("rawtypes")
	public Mallet(float attackDamage, Item.ToolMaterial material,
			Set effectiveBlocks) {
		super(3.0F, material, EFFECTIVE_ON);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Main.modid + "_" + name);
		setCreativeTab(Main.tabRoadBlock);
		this.setMaxDamage(material.getMaxUses());
		this.efficiencyOnProperMaterial = material
				.getEfficiencyOnProperMaterial();
		this.damageVsEntity = attackDamage + material.getDamageVsEntity();
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("static-access")
	public float getStrVsBlock(ItemStack stack, Block block) {
		return this.EFFECTIVE_ON.contains(block) ? this.efficiencyOnProperMaterial
				: 1.0F;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) {
		stack.damageItem(2, attacker);
		return true;
	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		ItemStack mat = this.toolMaterial.getRepairItemStack();
		if (mat != null
				&& net.minecraftforge.oredict.OreDictionary.itemMatches(mat,
						repair, false))
			return true;
		return super.getIsRepairable(toRepair, repair);
	}
}
