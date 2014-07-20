package geek.lawsof.physics.lib.util.handler

import cpw.mods.fml.common.IFuelHandler
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack

/**
 * Created by anshuman on 28-05-2014.
 */
object FuelHandler extends IFuelHandler {
  GameRegistry.registerFuelHandler(this)

  var fuels: Map[ItemStack, Int] = Map.empty

  def add(stack: ItemStack, items: Int) = fuels += (stack -> items * 200)

  def += (fuel: (ItemStack, Int)) = add(fuel._1, fuel._2)

  override def getBurnTime(fuel: ItemStack): Int = fuels(fuel)
}
