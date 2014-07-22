package geek.lawsof.physics.lib.block.traits

import geek.lawsof.physics.Reference

/**
 * Created by anshuman on 22-07-2014.
 */
trait ICustomRenderedBlock {
  def renderID(): Int = Reference.MAIN_RENDER_ID
}
