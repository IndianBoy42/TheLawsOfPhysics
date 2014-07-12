package geek.lawsof.physics.init

import geek.lawsof.physics.lib.util.Log
import geek.lawsof.physics.init.content.CraftingItems

/**
 * Created by anshuman on 26-05-2014.
 */
object ModItems {

  def preInit() = {
    Log.info("Creating Items")
    CraftingItems.registerItem()
  }
}
