package lazy.helper;

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
	
	public boolean lessThan(CoordTriplet coord) {
		return (x < coord.x) && (y < coord.y) && (z < coord.z);
	}
	
	public boolean equalTo(CoordTriplet coord) {
		return (x == coord.x) && (y == coord.y) && (z == coord.z);
	}
	
	public boolean moreThan(CoordTriplet coord) {
		return !lessThan(coord) && !equalTo(coord);
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
