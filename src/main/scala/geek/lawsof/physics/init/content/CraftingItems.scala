package geek.lawsof.physics.init.content

import geek.lawsof.physics.lib.item.{ItemBase, ItemDescriptor}

/**
 * Created by anshuman on 03-07-2014.
 */
object CraftingItems extends ItemBase() {
  registerItem("circuit")

  def registerItem(itemName: String) = this +: new ItemDescriptor(itemName)

  def registerItems(itemNames: String*) = itemNames.foreach(this +: new ItemDescriptor(_))
}