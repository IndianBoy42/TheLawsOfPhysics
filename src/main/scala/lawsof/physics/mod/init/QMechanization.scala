package lawsof.physics.mod.init

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.client.registry.RenderingRegistry
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import lawsof.physics.lib.helper.Log
import lawsof.physics.mod.network.ModProxy

/**
 * Created by anshuman on 25-05-2014.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, modLanguage = Reference.MOD_LANGUAGE)
object QMechanization {

  @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
  var proxy: ModProxy = null

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) = {
    Log.info("Mechanizing Quantumly")
    preInitVar = event

    ModConfigs.preInit()

    ModBlocks.preInit()
    ModItems.preInit()
    ModFluids.preInit()
    ModEquipment.preInit()

    ModMetals.preInit()

    ModRecipies.preInit()

    CTabs.preInit()
  }

  @EventHandler
  def init(event: FMLInitializationEvent) = {
    initVar = event
  }

  def postInit(event: FMLPostInitializationEvent) = {
    postInitVar = event
  }

  var preInitVar: FMLPreInitializationEvent = null
  var initVar: FMLInitializationEvent = null
  var postInitVar: FMLPostInitializationEvent = null

}

object Reference {
  final val MOD_ID = "lawsofphysics"

  final val MOD_LANGUAGE = "scala"

  final val CLIENT_PROXY_CLASS = "lawsof.physics.mod.network.ClientProxy"
  final val SERVER_PROXY_CLASS = "lawsof.physics.mod.network.CommonProxy"

  final val RENDER_ID: Int = RenderingRegistry.getNextAvailableRenderId

  final val TEXTURES_BLOCKS = "textures/blocks"
  final val TEXTURES_ITEMS = "textures/metalItems"
  final val TEXTURES_MODELS = "textures/models"
  final val TEXTURES_GUI = "textures/gui"
  final val TEXTURES_EQUIP = "textures/equip"
}
