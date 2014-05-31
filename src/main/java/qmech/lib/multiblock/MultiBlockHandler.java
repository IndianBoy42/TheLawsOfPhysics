package qmech.lib.multiblock;

import qmech.lib.multiblock.struct.StructureHandler;
import qmech.lib.multiblock.struct.StructureRegistry;

import java.util.List;

public class MultiBlockHandler {

    private final StructureHandler struct;
    private final UpdateHandler tickHandler;

    private List<MultiBlockPart> multiblockParts;
    private final MultiBlockPart controller;
    private MultiBlockPart bottomSouthWest;
    private boolean multiBlockValid = false;

    public MultiBlockHandler(MultiBlockPart origin) {
        this.struct = StructureRegistry.getStructureDef(origin.structureID());
        this.tickHandler = StructureRegistry.getTickHandler(origin.structureID());

        this.controller = origin;
        this.bottomSouthWest = origin;
        this.multiblockParts.add(origin);
    }

    public MultiBlockPart getController() {
        return this.controller;
    }

    public void checkValidity() {
        this.multiBlockValid = this.struct.checkValidity((MultiBlockPart[]) this.multiblockParts.toArray());
    }

    public void connect(MultiBlockPart block) {
        this.multiblockParts.add(block);
        if (block.getCoords().lessThan(this.bottomSouthWest.getCoords())) this.bottomSouthWest = block;
    }

    public void tick() {
        if (this.multiBlockValid) {
            this.tickHandler.tick();
        }
    }

}
