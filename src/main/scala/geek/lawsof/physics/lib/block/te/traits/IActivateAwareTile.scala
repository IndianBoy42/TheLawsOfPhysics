package geek.lawsof.physics.lib.block.te.traits

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

/**
 * Created by anshuman on 17-07-2014.
 */
trait IActivateAwareTile {

  def blockActivated(w: World, x: Int, y: Int, z: Int, p: EntityPlayer, pi: Int, px: Float, py: Float, pz: Float)

}
