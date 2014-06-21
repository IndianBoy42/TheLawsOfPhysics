package geek.lawsof.physics.init

import geek.lawsof.physics.init.metals._
import geek.lawsof.physics.lib.objects.info.{ArmorInfo, GenStats, FluidInfo, BlockInfo}
import geek.lawsof.physics.lib.helper.Log

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {
  var copper = new SimpleMetal(MetalPresets.copper)

  def preInit() = {
    Log.info("Creating Metal Sets")

    copper.register()
  }

  def init() = {
    Log.info("Adding Recipes for Metal Sets")

    copper.recipes()
  }
}
