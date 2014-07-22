package geek.lawsof.physics.lib.block.te.traits

import geek.lawsof.physics.LawsOfPhysicsMod
import geek.lawsof.physics.lib.block.te.render.CustomRendererBase
import geek.lawsof.physics.lib.block.te.TileEntityBase

/**
 * Created by anshuman on 17-07-2014.
 */
trait ICustomRenderedTile {
  def registerRenderer()
}

trait CustomRenderedTileImpl extends ICustomRenderedTile{
  self: TileEntityBase =>
  override def registerRenderer(): Unit = LawsOfPhysicsMod.proxy.registerRenderer(self.thisClass, rendererClass.newInstance())

  def rendererClass: Class[_ <: CustomRendererBase]
}