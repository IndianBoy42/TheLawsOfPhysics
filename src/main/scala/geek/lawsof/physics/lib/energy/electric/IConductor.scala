package geek.lawsof.physics.lib.energy.electric

import net.minecraft.world.World
import geek.lawsof.physics.lib.util.Coord

/**
 * Created by anshuman on 24-06-2014.
 */
trait IConductor {
  var electricGrid: IElectricGrid = null
  def isConnected = electricGrid != null

  def onBlockPlaced(w: World, x: Int, y: Int, z: Int, s: Int, hX: Float, hY: Float, hZ: Float, meta: Int): Int = {
    var tiles = Coord(x, y, z).getSurroundingTilesIfExists(w)
    for (tile <- tiles; if tile.isInstanceOf[IConductor]; conductorTile = tile.asInstanceOf[IConductor]; if conductorTile.isConnected) {
      conductorTile.electricGrid.connect(this)
      electricGrid = conductorTile.electricGrid
    }
    for (tile <- tiles; if !isConnected; if tile.isInstanceOf[IElectricBlock]; blockTile = tile.asInstanceOf[IElectricBlock]) {
      //todo create an IElectricGrid
    }
    meta
  }

  def onNeighbourBlockChanged(tileX: Int, tileY: Int, tileZ: Int): Unit = ???
}
