package geek.lawsof.physics.network.proxy

import net.minecraft.tileentity.TileEntity
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer

/**
 * Created by anshuman on 26-06-2014.
 */
trait IProxy {
  def preInit()

  def init()

  def registerRenderer(te: Class[_ <: TileEntity], renderer: TileEntitySpecialRenderer) = {}

  def registerGUI = {}

}
