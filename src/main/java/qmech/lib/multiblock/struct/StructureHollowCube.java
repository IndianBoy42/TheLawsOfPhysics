package qmech.lib.multiblock.struct;

import qmech.lib.multiblock.CoordTriplet;
import qmech.lib.multiblock.MultiBlockPart;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anshuman on 12-05-2014.
 */
public class StructureHollowCube implements StructureHandler {

    private final int x;
    private final int y;
    private final int z;

    public StructureHollowCube(int s) {
        this(s, s, s);
    }

    private StructureHollowCube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean checkValidity(MultiBlockPart... blocks) {
        List<MultiBlockPart> blokz = Arrays.asList(blocks);
//        List<CoordTriplet> coords = new ArrayList<CoordTriplet>();
//        for (MultiBlockPart block : blokz) coords.add(block.getCoords());
        MultiBlockPart bottomSouthWest = MultiBlockPart.bottomSouthWest(blocks);
        for (MultiBlockPart part : blokz) {
            if (!part.getCoords().lessThan(new CoordTriplet(this.x, this.y, this.z))) {
                return false;
            }
            if (part.getCoords().add(new CoordTriplet(1, 1, 1)).lessThan(new CoordTriplet(this.x - 2, this.y - 2, this.z - 2))) {
                return false;
            }
        }
        return true;
    }
}
