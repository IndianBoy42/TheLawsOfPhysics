package qmech.mod.init

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.client.registry.RenderingRegistry
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import qmech.lib.helper.Log
import qmech.mod.network.ModProxy

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
  final val MOD_NAME = "QuantumMechanization"
  final val MOD_ID = "qmechanization"
  final val MOD_VERSION = "0.0.0"
  final val MOD_AUTHORS: List[String] = List("GeckoTheGeek42", "ColdRock7", "Zarkoix", "Rein20/Trigalis")
  final val MOD_URL = "not yet sorry guys"
  final val MOD_DESCRIPTION = "A Realistic and Complex End-Game Technology Mod Based on Real Science Concepts"
  final val MOD_CREDITS = "All The People,\n "

  final val MOD_LANGUAGE = "scala"

  final val CLIENT_PROXY_CLASS = "qmech.mod.network.ClientProxy"
  final val SERVER_PROXY_CLASS = "qmech.mod.network.CommonProxy"

  final val RENDER_ID: Int = RenderingRegistry.getNextAvailableRenderId

  object values {
    final val moltenMetalPerIngot: Int = 144
    final val moltenMetalPerOre: Int = moltenMetalPerIngot * 2
    final val moltenMetalPerBlock: Int = moltenMetalPerIngot * 9
    final val moltenMetalPerNugget: Int = moltenMetalPerIngot / 2
  }

  final val TEXTURES_BLOCKS = "textures/blocks"
  final val TEXTURES_ITEMS = "textures/metalItems"
  final val TEXTURES_MODELS = "textures/models"
  final val TEXTURES_GUI = "textures/gui"
  final val TEXTURES_EQUIP = "textures/equip"
}
