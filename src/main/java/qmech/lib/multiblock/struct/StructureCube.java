package qmech.lib.multiblock.struct;

import qmech.lib.multiblock.CoordTriplet;
import qmech.lib.multiblock.MultiBlockPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anshuman on 12-05-2014.
 */
public class StructureCube extends StructureHandler {

    int x;
    int y;
    int z;

    public StructureCube (int s) {
        this(s, s, s);
    }

    public StructureCube(int x, int y, int z) {
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
            if (!part.getCoords().lessThan(bottomSouthWest.getCoords())) {
                return false;
            }
        }
        return true;
    }
}