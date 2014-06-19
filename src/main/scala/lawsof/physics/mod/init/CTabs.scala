package lawsof.physics.mod.init

import lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.init.{Blocks, Items}

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def preInit() = {
    Metals.icon = ModMetals.copper.getItem("ingot")

    //will change
    Tech.icon = ModFluids.cell
  }

  var Tech = new CreativeTabBase(Reference.MOD_NAME + "| Tech", Items.redstone)
  var Metals = new CreativeTabBase(Reference.MOD_NAME + " | Metals", Items.iron_ingot)
}
