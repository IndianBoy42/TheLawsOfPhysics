package geek.lawsof.physics.lib.machine.metallic

import geek.lawsof.physics.lib.block.BlockBase
import geek.lawsof.physics.lib.materials.MetalProperties

/**
 * Created by anshuman on 23-07-2014.
 */
trait IMetallicBlock {
  self: BlockBase =>
  def props(dmg: Int): MetalProperties
}
