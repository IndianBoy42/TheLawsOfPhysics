package qmech.helper.multiblock.struct;

import qmech.helper.CoordTriplet;
import qmech.helper.multiblock.MultiBlockPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anshuman on 12-05-2014.
 */
public class StructureHollowCube extends StructureDef {

    int x;
    int y;
    int z;

    public StructureHollowCube(int s) {
        this(s, s, s);
    }

    public StructureHollowCube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean checkValidity(MultiBlockPart... blocks) {
        List<MultiBlockPart> blokz = Arrays.asList(blocks);
        List<CoordTriplet> coords = new ArrayList<CoordTriplet>();
        for (MultiBlockPart block : blokz) coords.add(block.getCoords());
        MultiBlockPart bottomSouthWest = MultiBlockPart.bottomSouthWest(blocks);
        for (MultiBlockPart part : blokz) {
            if (!part.getCoords().lessThan(new CoordTriplet(x, y, z))) {
                return false;
            }
           if (part.getCoords().add(new CoordTriplet(1,1,1)).lessThan(new CoordTriplet(x-2, y-2, z-2))) {
               return false;
           }
        }
        return true;
    }
}
