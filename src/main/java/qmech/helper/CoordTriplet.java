package qmech.helper;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CoordTriplet {
	
	int x, y, z;

	public CoordTriplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CoordTriplet differenceTo(CoordTriplet coord) {
		return new CoordTriplet(coord.x - x, coord.y - y, coord.z - z);
	}
	public CoordTriplet differenceFrom(CoordTriplet coord) {
        return new CoordTriplet(x - coord.x, y - coord.y, z - coord.z);
	}

    public CoordTriplet add(CoordTriplet coord) {
        return new CoordTriplet(x + coord.x, y + coord.y, z + coord.z);
    }
	
	public boolean lessThan(CoordTriplet coord) {
		return (x < coord.x) && (y < coord.y) && (z < coord.z);
	}
	
	public boolean equalTo(CoordTriplet coord) {
		return (x == coord.x) && (y == coord.y) && (z == coord.z);
	}
	
	public boolean moreThan(CoordTriplet coord) {
		return !lessThan(coord) && !equalTo(coord);
	}

    public List<CoordTriplet> around() {
        List<CoordTriplet> coords = new ArrayList<CoordTriplet>();
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                for (int k=-1; k<=1; k++) {
                    coords.add(this.add(new CoordTriplet(i, j, k)));
                }
            }
        }
        return coords;
    }

    public Block blockInWorld(World world) {
        return world.getBlock(this.x, this.y, this.z);
    }
    public TileEntity teInWorld(World world) {
        return world.getTileEntity(this.x, this.y, this.z);
    }
	
	public static CoordTriplet bottomSouthWest(CoordTriplet...coordTriplets) {
		CoordTriplet res = null;
		for (int i=0; i<(coordTriplets.length-1); i++) {
			for (int j=(i+1); j<coordTriplets.length; j++) {
				if (!coordTriplets[i].lessThan(coordTriplets[j])) {
					res = null;
					break;
				}
				res = coordTriplets[i];
			}
		}
		return res;
	}

}
