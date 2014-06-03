package qmech.mod.init

import qmech.mod.content.metals.{MetalBase, MetalInfo}

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {
  var metals: List[MetalBase] = List.empty

  def preInit = metals foreach ((metal: MetalBase) => metal.register())
}
