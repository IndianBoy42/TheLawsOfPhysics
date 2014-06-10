package qmech.mod.init

import qmech.mod.content.metals.{SimpleMetalInfo, SimpleMetal, MetalBase, MetalInfo}
import qmech.lib.objects.info.{ArmorInfo, GenStats, FluidInfo, BlockInfo}
import qmech.lib.helper.Log

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {
  var copper = new SimpleMetal(new SimpleMetalInfo("Copper"))

  def preInit() = {
    copper.register()

    copper.recipes()
  }
}
