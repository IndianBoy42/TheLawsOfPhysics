package lawsof.physics.lib.objects.item

import net.minecraft.item.ItemFood
import net.minecraft.potion.Potion
import cpw.mods.fml.common.registry.GameRegistry
import lawsof.physics.mod.init.Reference

/**
 * Created by anshuman on 26-05-2014.
 */
class FoodBase(hunger: Int, isMeat: Boolean, intName: String) extends ItemFood(hunger, isMeat) {
  this.setTextureName(Reference.MOD_ID + ":" + intName)
  this.setUnlocalizedName(intName)
  this.setMaxStackSize(64)

  def this(hunger: Int, intName: String) = this(hunger, false, intName)

  def setPotionEffect(effect: Potion, duration: Int, amplifier: Int, chancePerCent: Float): FoodBase = {
    this.setPotionEffect(effect.id, duration, amplifier - 1, chancePerCent / 100)
    this
  }

  def registerItem() {
    GameRegistry.registerItem(this, this.getUnlocalizedName.substring(5))
  }
}
