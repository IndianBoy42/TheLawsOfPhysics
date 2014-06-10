package qmech.lib.helper

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack
import scala.collection.JavaConverters._

/**
 * Created by anshuman on 28-05-2014.
 */
object Recipes {
  def shapedRecipe(output: ItemStack, params: Object*) {
    RecipeBridge.addShapedRecipe(output, params.asJava.toArray)
  }

  def shapelessRecipe(output: ItemStack, recipePars: Object*) {
    GameRegistry.addShapelessRecipe(output, recipePars.asJava)
  }

  def smeltingRecipe(output: ItemStack, input: ItemStack, xp: Float = 1.0F) {
    GameRegistry.addSmelting(input, output, xp)
  }

  def fromSeqtoArray(array: Seq[Object]) = for (obj <- array) yield obj

  def grid3 = Array("xxx", "xxx", "xxx")

  def grid2 = Array("xx", "xx")

  def cross3 = Array("xyx", "yxy", "xyx")

  def cross2 = Array("xy", "yx")
}