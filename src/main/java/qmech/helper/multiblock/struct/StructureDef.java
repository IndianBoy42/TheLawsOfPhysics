package qmech.helper.multiblock.struct;

import qmech.helper.multiblock.MultiBlockPart;
import qmech.helper.tileentity.TileEntityBase;

public abstract class StructureDef {
	
	public abstract boolean checkValidity (MultiBlockPart... blocks);
	
}
