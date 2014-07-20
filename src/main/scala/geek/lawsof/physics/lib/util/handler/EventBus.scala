package geek.lawsof.physics.lib.util.handler

import cpw.mods.fml.common.FMLCommonHandler
import net.minecraftforge.common.MinecraftForge

/**
 * Created by anshuman on 12-07-2014.
 */
object EventBus {
  def registerForgeEvent(obj: AnyRef) = MinecraftForge.EVENT_BUS.register(obj)

  def registerFMLEvent(obj: AnyRef) = FMLCommonHandler.instance().bus().register(obj)
}

object FMLEventBus {
  def += (obj: AnyRef) = EventBus.registerFMLEvent(obj)
}

object MinecraftForgeBus {
  def += (obj: AnyRef) = EventBus.registerForgeEvent(obj)
}