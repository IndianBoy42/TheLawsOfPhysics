package geek.lawsof.physics.init

import geek.lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.init.{Blocks, Items}
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.helper.Log

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def init() = {
    Log.info("Registering Creative Tabs")

    Metals.icon = ModMetals.copper.getItem("ingot")

    Tech.icon = ModFluids.cell
  }

  var Tech = new CreativeTabBase(Reference.MOD_NAME + "| Tech", Items.redstone)
  var Metals = new CreativeTabBase(Reference.MOD_NAME + " | Metals", Items.iron_ingot)
}
