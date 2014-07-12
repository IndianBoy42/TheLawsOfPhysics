package geek.lawsof.physics.lib.util

import cpw.mods.fml.common.FMLCommonHandler
import net.minecraftforge.common.MinecraftForge

/**
 * Created by anshuman on 12-07-2014.
 */
object EventBus {
  def registerForgeEvent (obj: AnyRef) = MinecraftForge.EVENT_BUS.register(obj)

  def registerFMLEvent (obj: AnyRef) = FMLCommonHandler.instance().bus().register(obj)
}
