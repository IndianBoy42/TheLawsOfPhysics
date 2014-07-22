package geek.lawsof.physics.lib.machine.recipes

import net.minecraft.inventory.InventoryCrafting
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 * Created by anshuman on 22-07-2014.
 */
trait MachineRecipe[I <: MachineRecipeInput, O <: MachineRecipeOutput] {
  def matches(input: I): Boolean

  def time(input: I): Int

  def result(input: I): O
}
