package geek.lawsof.physics.lib.util

import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.IBlockAccess

/**
 * Created by anshuman on 14-06-2014.
 */
class Coord(var x: Int, var y: Int, var z: Int) {

  def getBlockAt(w: IBlockAccess) = w.getBlock(x, y, z)

  def getBlockAtAs[B <: Block](w: IBlockAccess) = getBlockAt(w).asInstanceOf[B]

  def getTileAt(w: IBlockAccess) = w.getTileEntity(x, y, z)

  def getTileAtAs[T <: TileEntity](w: IBlockAccess) = getTileAt(w).asInstanceOf[T]

  def blockExistsAt(w: IBlockAccess) = getBlockAt(w) != null

  def tileExistsAt(w: IBlockAccess) = getTileAt(w) != null

  def getAdjacentCoords = Array(
    this + Coord(1, 0, 0),
    this + Coord(0, 1, 0),
    this + Coord(0, 0, 1),
    this - Coord(1, 0, 0),
    this - Coord(0, 1, 0),
    this - Coord(0, 0, 1)
  )

  def getSurroundingBlocks(w: IBlockAccess) = for (coord <- getAdjacentCoords) yield coord.getBlockAt(w)

  def getSurroundingTiles(w: IBlockAccess) = for (coord <- getAdjacentCoords) yield coord.getTileAt(w)

  def getSurroundingBlocksIfExists(w: IBlockAccess) = for (coord <- getAdjacentCoords; if coord.blockExistsAt(w)) yield coord.getBlockAt(w)

  def getSurroundingTilesIfExists(w: IBlockAccess) = for (coord <- getAdjacentCoords; if coord.tileExistsAt(w)) yield coord.getTileAt(w)

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

  implicit def tuple3IntToCoord(xyz: (Int, Int, Int)) = new Coord(xyz._1, xyz._2, xyz._3)
}
