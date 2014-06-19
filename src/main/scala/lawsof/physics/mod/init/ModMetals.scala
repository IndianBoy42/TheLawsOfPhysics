package lawsof.physics.mod.init

import lawsof.physics.mod.content.metals._
import lawsof.physics.lib.objects.info.{ArmorInfo, GenStats, FluidInfo, BlockInfo}
import lawsof.physics.lib.helper.Log

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {
  var copper = new SimpleMetal(MetalPresets.copper)

  def preInit() = {
    copper.register()

    copper.recipes()
  }
}
