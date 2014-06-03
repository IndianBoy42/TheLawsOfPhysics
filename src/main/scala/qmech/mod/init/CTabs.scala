package qmech.mod.init

import qmech.lib.objects.CreativeTabBase
import net.minecraft.init.Items

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def preInit() = {
    //todo register proper icon items
  }

  var Metals = new CreativeTabBase(Reference.MOD_NAME + " | Metals", Items.iron_ingot)
}
