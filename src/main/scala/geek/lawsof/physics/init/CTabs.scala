package geek.lawsof.physics.init

import geek.lawsof.physics.init.content.CraftingItems
import net.minecraft.init.{Blocks, Items}
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.util.Log
import geek.lawsof.physics.lib.CreativeTabBase

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def init() = {
    Log.info("Registering Creative Tabs")

    mainTab.icon = CraftingItems
    metalsTab.icon = ModMetals.copper.getItem("ingot")
    techTab.icon = ModFluids.cell
  }

  var mainTab = new CreativeTabBase(Reference.MOD_NAME + "| Main", Items.stick)
  var techTab = new CreativeTabBase(Reference.MOD_NAME + "| Tech", Items.redstone)
  var metalsTab = new CreativeTabBase(Reference.MOD_NAME + " | Metals", Items.iron_ingot)

}
