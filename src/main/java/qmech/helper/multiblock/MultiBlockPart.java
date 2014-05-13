package qmech.helper.multiblock;

import net.minecraft.tileentity.TileEntity;
import qmech.helper.CoordTriplet;
import qmech.helper.multiblock.struct.StructureHandler;
import qmech.helper.tileentity.TileEntityBase;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiBlockPart extends TileEntityBase {
	
	public MultiBlockPart(String name, int StructID, int BlockID) {
		super(name);
		searchForMultiBlock();
        this.structureID = StructID;
        this.blockID = BlockID;
	}

    MultiBlockHandler handler;
	public MultiBlockHandler handler () {
        return handler;
    }

    int structureID = 0;
    public int structureID() {
        return structureID;
    }

    int blockID = 0;
    public int blockID () {
        return blockID();
    }
	
	public boolean isController() {
        return this.equals(handler().getController());
    }
	
	public boolean hasHandler() {
        return !handler().equals(null);
    }

	public void searchForMultiBlock() {
        for (CoordTriplet coordTriplet : this.getCoords().around()) {
            TileEntity te = coordTriplet.teInWorld(this.getWorldObj());
            if (te instanceof MultiBlockPart) {
                MultiBlockPart part = (MultiBlockPart) te;
                if (part.structureID() == this.structureID() && part.hasHandler()) part.handler().connect(this);
            }
        }
    }

    public static MultiBlockPart bottomSouthWest(MultiBlockPart... parts) {
        List<CoordTriplet> coords = new ArrayList<CoordTriplet>();
        for (MultiBlockPart block : parts) coords.add(block.getCoords());

        CoordTriplet bsw = CoordTriplet.bottomSouthWest((CoordTriplet[]) coords.toArray());

        for (MultiBlockPart part : parts) {
            if (part.getCoords() == bsw) {
                return part;
            }
        }

        return null;
    }

    public void update() {
        if (this.isController()) handler.tick();
    }

}
