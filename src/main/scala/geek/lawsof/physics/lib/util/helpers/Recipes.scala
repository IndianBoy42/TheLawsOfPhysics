package geek.lawsof.physics.lib.util.helpers

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.oredict.{ShapelessOreRecipe, ShapedOreRecipe, OreDictionary}

import scala.collection.JavaConverters._

/**
 * Created by anshuman on 28-05-2014.
 */
object Recipes {
  def shapedRecipe(output: ItemStack, params: Object*) {
    RecipeBridge.addShapedRecipe(output, params.asJava.toArray())
  }

  def shapelessRecipe(output: ItemStack, recipePars: Object*) =GameRegistry.addShapelessRecipe(output, recipePars.asJava)

  def smeltingRecipe(output: ItemStack, input: ItemStack, xp: Float = 1.0F) = GameRegistry.addSmelting(input, output, xp)

  def shapedOreRecipe(output: ItemStack, params: Object*) = GameRegistry.addRecipe(new ShapedOreRecipe(output, params))

  def shapelessOreRecipe(output: ItemStack, recipe: Object*) = GameRegistry.addRecipe(new ShapelessOreRecipe(output, recipe))

  def customRecipe(recipe: IRecipe) = GameRegistry.addRecipe(recipe)

  def grid3 = Array("xxx", "xxx", "xxx")

  def grid2 = Array("xx", "xx")

  def cross3 = Array("xyx", "yxy", "xyx")

  def cross2 = Array("xy", "yx")

  def compressionCraft(o: ItemStack, i: ItemStack) = shapedRecipe(o, "iii", "iii", "iii", char2Character('i'), i)
  def decompressionCraft(o: ItemStack, i: ItemStack) = shapedRecipe(o, "i", char2Character('i'), i)
  def reversibleCompressionCraft(o: ItemStack, i: ItemStack) = {
    compressionCraft(o, i)
    val i_9 = new ItemStack(i.getItem, 9, i.getItemDamage)
    decompressionCraft(i, o)
  }
}
