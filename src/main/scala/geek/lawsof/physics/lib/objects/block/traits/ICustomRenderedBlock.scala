package geek.lawsof.physics.lib.objects.block.traits

import net.minecraft.world.World

/**
 * Created by anshuman on 28-05-2014.
 */
trait ICustomRenderedBlock {
  def registerRenderer

  def getBlockBoundsByState(w: World, x: Int, y: Int, z:Int)
}
