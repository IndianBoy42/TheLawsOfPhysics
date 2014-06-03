package qmech.lib.helper

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack

/**
 * Created by anshuman on 28-05-2014.
 */
object Recipes {
  def shapedRecipe[T <: Any](output: ItemStack, recipePars: T*) {
    GameRegistry.addRecipe(output, recipePars)
  }

  def shapelessRecipe[T <: Any](output: ItemStack, recipePars: T*) {
    GameRegistry.addShapelessRecipe(output, recipePars)
  }

  def smeltingRecipe(output: ItemStack, input: ItemStack, xp: Float = 1.0F) {
    GameRegistry.addSmelting(input, output, xp)
  }

  def grid3 = Array("xxx", "xxx", "xxx")
  def grid2 = Array("xx", "xx")
  def cross3 = Array("xyx", "yxy", "xyx")
  def cross2 = Array("xy", "yx")
}
