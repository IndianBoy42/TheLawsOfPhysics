package geek.lawsof.physics.init

import geek.lawsof.physics.Reference
import geek.lawsof.physics.init.content.CraftingItems
import geek.lawsof.physics.lib.CreativeTabBase
import geek.lawsof.physics.lib.metals.MetalIngots
import geek.lawsof.physics.lib.util.Log

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def init() = {
    Log.info("Registering Creative Tabs")

    mainTab setTabIcon CraftingItems.newItemStack()
    metalsTab setTabIcon MetalIngots.newItemStack()
    techTab setTabIcon ModFluids.cell.newItemStack()
  }

  var mainTab = new CreativeTabBase(Reference.MOD_NAME + "| Main")
  var techTab = new CreativeTabBase(Reference.MOD_NAME + "| Tech")
  var metalsTab = new CreativeTabBase(Reference.MOD_NAME + " | Metals")

}
