package qmech.helper.multiblock.struct;

import qmech.helper.multiblock.MultiBlockPart;
import qmech.helper.tileentity.TileEntityBase;

public abstract class StructureHandler {
	
	public abstract boolean checkValidity (MultiBlockPart... blocks);
	
}
