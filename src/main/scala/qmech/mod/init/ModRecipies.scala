package qmech.mod.init

import net.minecraft.item.ItemStack
import cpw.mods.fml.common.registry.GameRegistry

/**
 * Created by anshuman on 26-05-2014.
 */
object ModRecipies {
  def preInit() = {}

  def shapedRecipe(output: ItemStack, recipePars: AnyRef*) {
    GameRegistry.addRecipe(output, recipePars)
  }

  def shapelessRecipe(output: ItemStack, recipePars: AnyRef*) {
    GameRegistry.addShapelessRecipe(output, recipePars)
  }

  def smeltingRecipe(output: ItemStack, input: ItemStack, xp: Float) {
    GameRegistry.addSmelting(input, output, xp)
  }

}
