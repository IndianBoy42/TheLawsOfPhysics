package geek.lawsof.physics.lib.util.helpers

import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by anshuman on 20-07-2014.
 */
object OreDict {
  def apply(oreName: String) = OreDictionary.getOres(oreName)

  def apply(stack: ItemStack) = OreDictionary.getOreIDs(stack).map(OreDictionary.getOreName)

  def apply(stack1: ItemStack, stack2: ItemStack, strict: Boolean = false) = OreDictionary.itemMatches(stack1, stack2, strict)

  def apply(stack: ItemStack, name: String) = OreDictionary.registerOre(name, stack)
}
