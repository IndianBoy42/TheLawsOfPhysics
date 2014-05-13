package qmech.helper.multiblock;

import qmech.helper.CoordTriplet;
import qmech.helper.tileentity.TileEntityBase;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiBlockPart extends TileEntityBase {
	
	public MultiBlockPart() {
		super();
		searchForMultiBlock();
	}

    MultiBlockHandler handler;
	public MultiBlockHandler handler () {
        return handler;
    }
	
	public abstract int structureID ();
	public abstract int blockID ();
	
	public boolean isController() {
        return this.equals(handler().getController());
    }
	
	public boolean hasHandler() {
        return !handler().equals(null);
    }
	
	public abstract void searchForMultiBlock() {
        for (CoordTriplet coordTriplet : this.getCoords().around()) {
            //coordTriplet.blockInWorld().enti
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

    public void tick () {
        if (this.isController()) handler.tick();
    }

}
