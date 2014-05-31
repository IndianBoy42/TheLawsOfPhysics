package qmech.lib.multiblock;

import net.minecraft.tileentity.TileEntity;
import qmech.lib.tileentity.TileEntityBase;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiBlockPart extends TileEntityBase {

    private MultiBlockHandler handler = null;
    private int structureID = 0;
    private int blockID = 0;

    public MultiBlockPart(int StructID, int BlockID) {
        super();
        this.searchForMultiBlock();
        this.structureID = StructID;
        this.blockID = BlockID;
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

    MultiBlockHandler handler() {
        return this.handler;
    }

    public int structureID() {
        return this.structureID;
    }

    int blockID() {
        return this.blockID;
    }

    boolean isController() {
        return this.equals(this.handler().getController());
    }

    boolean hasHandler() {
        return !this.handler().equals(null);
    }

    void searchForMultiBlock() {
        for (CoordTriplet coordTriplet : this.getCoords().around()) {
            TileEntity te = coordTriplet.teInWorld(this.getWorldObj());
            if (te instanceof MultiBlockPart) {
                MultiBlockPart part = (MultiBlockPart) te;
                if (part.structureID() == this.structureID() && part.hasHandler()) part.handler().connect(this);
            }
        }
    }

    public void update() {
        if (this.isController()) this.handler.tick();
    }

}
