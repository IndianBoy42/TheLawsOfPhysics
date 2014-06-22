package geek.lawsof.physics.lib.objects.block

import net.minecraft.world.IBlockAccess
import net.minecraft.tileentity.TileEntity

/**
 * Created by anshuman on 14-06-2014.
 */
class Coord(var x: Int, var y: Int, var z: Int) {

  def getBlockAt(w: IBlockAccess) = w.getBlock(x, y, z)

  def getTileAt(w: IBlockAccess) = w.getTileEntity(x, y, z)

  def getTileAtAs[T <: TileEntity](w: IBlockAccess) = getTileAt(w).asInstanceOf[T]

  def blockExistsAt(w: IBlockAccess) = getBlockAt(w) != null

  def tileExistsAt(w: IBlockAccess) = getTileAt(w) != null

  def +(c: Coord) = Coord(x + c.x, y + c.y, z + c.z)

  def -(c: Coord) = Coord(x - c.x, y - c.y, z - c.z)

  def <(c: Coord) = x < c.x && y < c.y && z < c.z

  def >(c: Coord) = x > c.x && y > c.y && z > c.z

  def <=(c: Coord) = x <= c.x && y <= c.y && z <= c.z

  def >=(c: Coord) = x >= c.x && y >= c.y && z >= c.z

  def ==(c: Coord) = x == c.x && y == c.y && z == c.z
}

object Coord {
  def apply(x: Int, y: Int, z: Int) = new Coord(x, y, z)
}
