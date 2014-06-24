package geek.lawsof.physics.lib.block.te.traits

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

/**
 * Created by anshuman on 28-05-2014.
 */
trait IBlockLogicTile {
  def onBlockActivated(p: EntityPlayer, s: Int, px: Float, py: Float, pz: Float): Boolean

  def onNeighbourBlockChanged(tileX: Int, tileY: Int, tileZ: Int): Unit

  def onBlockBroken(player: EntityPlayer): Boolean

  def onBlockEventRecieved(evtID: Int, evtPar: Int): Boolean

  def onBlockPlaced(w : World, x : Int, y : Int, z : Int, s : Int, hX : Float, hY : Float, hZ : Float, meta : Int): Int
}
