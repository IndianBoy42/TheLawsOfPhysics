package qmech.mod.init

import qmech.mod.content.metals.{SimpleMetalInfo, SimpleMetal, MetalBase, MetalInfo}
import qmech.lib.objects.info.{ArmorInfo, GenStats, FluidInfo, BlockInfo}
import qmech.lib.helper.Log

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {
  var metals: List[MetalBase] = List.empty

  def preInit() = {
    metals = new SimpleMetal(new SimpleMetalInfo("Copper")) :: metals

    metals foreach ((metal: MetalBase) => {
      metal.register()
      metal.recipes()
    })
  }
}
