package roadblock.tile;

import net.minecraft.tileentity.TileEntity;

public class roadtile extends TileEntity {
	private String myString;

	public String getValue() {
		return myString;
	}

	public void setValue(String value) {
		myString = value;
	}
}
