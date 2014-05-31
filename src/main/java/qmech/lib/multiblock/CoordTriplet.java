package qmech.lib.multiblock;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;

public class CoordTriplet {

    private final int x;
    private final int y;
    private final int z;

    public CoordTriplet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static CoordTriplet bottomSouthWest(CoordTriplet... coordTriplets) {
        CoordTriplet res = null;
        for (int i = 0; i < (coordTriplets.length - 1); i++) {
            for (int j = (i + 1); j < coordTriplets.length; j++) {
                if (!coordTriplets[i].lessThan(coordTriplets[j])) {
                    res = null;
                    break;
                }
                res = coordTriplets[i];
            }
        }
        return res;
    }

    public CoordTriplet differenceTo(CoordTriplet coord) {
        return new CoordTriplet(coord.x - this.x, coord.y - this.y, coord.z - this.z);
    }

    public CoordTriplet differenceFrom(CoordTriplet coord) {
        return new CoordTriplet(this.x - coord.x, this.y - coord.y, this.z - coord.z);
    }

    public CoordTriplet add(CoordTriplet coord) {
        return new CoordTriplet(this.x + coord.x, this.y + coord.y, this.z + coord.z);
    }

    public boolean lessThan(CoordTriplet coord) {
        return (this.x < coord.x) && (this.y < coord.y) && (this.z < coord.z);
    }

    boolean equalTo(CoordTriplet coord) {
        return (this.x == coord.x) && (this.y == coord.y) && (this.z == coord.z);
    }

    public boolean moreThan(CoordTriplet coord) {
        return !this.lessThan(coord) && !this.equalTo(coord);
    }

    public List<CoordTriplet> around() {
        List<CoordTriplet> coords = new ArrayList<CoordTriplet>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    coords.add(this.add(new CoordTriplet(i, j, k)));
                }
            }
        }
        return coords;
    }

    public Block blockInWorld(IBlockAccess world) {
        return world.getBlock(this.x, this.y, this.z);
    }

    public TileEntity teInWorld(IBlockAccess world) {
        return world.getTileEntity(this.x, this.y, this.z);
    }

}
