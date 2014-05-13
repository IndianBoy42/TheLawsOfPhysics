package lazy.helper.multiblock;

import java.util.Map;

import lazy.helper.tileentity.TileEntityBase;

public abstract class StructureDef {
	
	public abstract boolean checkValidity (TileEntityBase... blocks);
	
}
