package qmech.helper.multiblock;

import qmech.helper.multiblock.struct.StructureHandler;
import qmech.helper.multiblock.struct.StructureRegistry;

import java.util.List;

public class MultiBlockHandler {
	
	StructureHandler struct;
	UpdateHandler tickHandler;
	
	List<MultiBlockPart> multiblockParts;

    public MultiBlockPart getController() {
        return controller;
    }

    MultiBlockPart controller;
	MultiBlockPart bottomSouthWest;

    boolean multiBlockValid = false;

	public void checkValidity() {
       multiBlockValid =  struct.checkValidity((MultiBlockPart[]) multiblockParts.toArray());
    }
	
	public void connect(MultiBlockPart block) {
        multiblockParts.add(block);
        if (block.getCoords().lessThan(bottomSouthWest.getCoords())) bottomSouthWest = block;
    }
	
	public MultiBlockHandler(MultiBlockPart origin) {
		struct = StructureRegistry.getStructureDef(origin.structureID());
		tickHandler = StructureRegistry.getTickHandler(origin.structureID());
		
		this.controller = origin;
		bottomSouthWest = origin;
		multiblockParts.add(origin);
	}

    public void tick() {
        if (this.multiBlockValid) {
            tickHandler.tick();
        }
    }
	
}
