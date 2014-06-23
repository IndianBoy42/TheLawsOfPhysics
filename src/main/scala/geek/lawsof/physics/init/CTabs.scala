package geek.lawsof.physics.init

import net.minecraft.init.{Blocks, Items}
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.helper.Log
import geek.lawsof.physics.lib.CreativeTabBase

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def init() = {
    Log.info("Registering Creative Tabs")

    metalsTab.icon = ModMetals.copper.getItem("ingot")

    techTab.icon = ModFluids.cell
  }

  var techTab = new CreativeTabBase(Reference.MOD_NAME + "| Tech", Items.redstone)
  var metalsTab = new CreativeTabBase(Reference.MOD_NAME + " | Metals", Items.iron_ingot)
}
