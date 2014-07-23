package geek.lawsof.physics.lib.machine.metallic

import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.materials.metals.MetalBlock

/**
 * Created by anshuman on 23-07-2014.
 */
trait IMetallicMachine {
  self: TileEntityBase =>
  def properties = {
    val block = coord.getBlockAt(worldObj)
    if (block._1.isInstanceOf[IMetallicBlock]) block._1.asInstanceOf[IMetallicBlock].props(block._2)
  }
}
