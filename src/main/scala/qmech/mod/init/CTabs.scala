package qmech.mod.init

import qmech.lib.objects.CreativeTabBase
import net.minecraft.init.Items
import Reference

/**
 * Created by anshuman on 28-05-2014.
 */
object CTabs {
  def preInit() = {
    //todo register proper icon items
  }

  var Metals = new CreativeTabBase(Reference.MOD_ID + " | Metals", Items.iron_ingot)
}
