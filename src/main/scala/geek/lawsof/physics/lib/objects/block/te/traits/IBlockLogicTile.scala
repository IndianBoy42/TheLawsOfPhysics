package geek.lawsof.physics.lib.objects.block.te.traits

import net.minecraft.entity.player.EntityPlayer

/**
 * Created by anshuman on 28-05-2014.
 */
trait IBlockLogicTile {
  def onBlockActivated(p: EntityPlayer, s: Int, px: Float, py: Float, pz: Float): Boolean

  def onNeighbourBlockChanged(tileX: Int, tileY: Int, tileZ: Int): Unit

  def onBlockBroken(player: EntityPlayer): Boolean

  def onBlockEventRecievedw(evtID: Int, evtPar: Int): Boolean
}
