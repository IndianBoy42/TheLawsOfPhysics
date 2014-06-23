package geek.lawsof.physics.lib.item.traits

import net.minecraft.item.ItemStack

/**
 * Created by anshuman on 23-06-2014.
 */
trait IHasContainerItem {
  def getContainerItem(itemStack: ItemStack): ItemStack
  def doesContainerItemLeaveCraftingGrid(par1ItemStack: ItemStack): Boolean
}
