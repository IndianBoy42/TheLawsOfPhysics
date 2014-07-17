package geek.lawsof.physics.lib

import net.minecraft.init.Items
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.creativetab.CreativeTabs

/**
 * Created by anshuman on 26-05-2014.
 */
class CreativeTabBase(val tabLabel: String, var icon: ItemStack = new ItemStack(Items.iron_ingot)) extends CreativeTabs(CreativeTabs.getNextID, tabLabel) {
  override def getTabIconItem: Item = null

  def setTabIcon(ico: ItemStack) = icon = ico

  override def getIconItemStack: ItemStack = icon
}
