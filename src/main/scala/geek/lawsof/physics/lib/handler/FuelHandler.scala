package geek.lawsof.physics.lib.handler

import cpw.mods.fml.common.IFuelHandler
import net.minecraft.item.ItemStack
import cpw.mods.fml.common.registry.GameRegistry

/**
 * Created by anshuman on 28-05-2014.
 */
class FuelHandler extends IFuelHandler {
  GameRegistry.registerFuelHandler(this)

  var fuels: Map[ItemStack, Int] = Map.empty

  def add(stack: ItemStack, items: Int) = fuels += (stack -> items * 200)

  override def getBurnTime(fuel: ItemStack): Int = fuels(fuel)
}
