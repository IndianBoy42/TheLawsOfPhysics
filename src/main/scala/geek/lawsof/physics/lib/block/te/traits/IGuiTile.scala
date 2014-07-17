package geek.lawsof.physics.lib.block.te.traits

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

/**
 * Created by anshuman on 28-05-2014.
 */
trait IGuiTile extends IActivateAwareTile {

  def updateGUI()

  override def blockActivated(w: World, x: Int, y: Int, z: Int, p: EntityPlayer, pi: Int, px: Float, py: Float, pz: Float): Unit = openGUI(w, x, y, z, p, pi, px, py, pz)

  def openGUI(w: World, x: Int, y: Int, z: Int, p: EntityPlayer, pi: Int, px: Float, py: Float, pz: Float)

}
