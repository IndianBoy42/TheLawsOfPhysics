package lazy.helper.multiblock;

import java.util.List;

public abstract class MultiBlockHandler {
	
	StructureDef struct;
	UpdateHandler tickHandler;
	
	List<MultiBlockPart> multiblockParts;
	MultiBlockPart controller;
	MultiBlockPart bottomSouthWest;

	public abstract void checkValidity ();
	
	public abstract void connect (MultiBlockPart block);
	
	public MultiBlockHandler(MultiBlockPart origin) {
		struct = StructureRegistry.getStructureDef(origin.structureID());
		tickHandler = StructureRegistry.getTickHandler(origin.structureID());
		
		this.controller = origin;
		bottomSouthWest = origin;
		multiblockParts.add(origin);
	}
	
}
