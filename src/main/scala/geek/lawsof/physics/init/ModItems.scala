package geek.lawsof.physics.init

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.util.Log
import geek.lawsof.physics.init.content.CraftingItems

/**
 * Created by anshuman on 26-05-2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
object ModItems {

  def preInit() = {
    Log.info("Creating Items")
    CraftingItems.registerItem()
  }
}
