package geek.lawsof.physics.network.proxy

import cpw.mods.fml.client.registry.ClientRegistry
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity

/**
 * Created by anshuman on 28-05-2014.
 */
class ClientProxy extends ModProxy {
  override def preInit(): Unit = {}

  override def init(): Unit = {}

  override def registerRenderer(te: Class[_ <: TileEntity], renderer: TileEntitySpecialRenderer): Unit = ClientRegistry.bindTileEntitySpecialRenderer(te, renderer)
}
