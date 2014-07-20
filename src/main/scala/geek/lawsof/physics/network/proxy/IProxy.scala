package geek.lawsof.physics.network.proxy

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity

/**
 * Created by anshuman on 26-06-2014.
 */
trait IProxy {
  def preInit()

  def init()

  def registerRenderer(te: Class[_ <: TileEntity], renderer: TileEntitySpecialRenderer) = {}

  def registerGUI() = {}
}

abstract class ModProxy extends IProxy