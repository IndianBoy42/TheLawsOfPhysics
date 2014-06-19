package lawsof.physics.lib.objects

import net.minecraft.item.Item
import net.minecraft.creativetab.CreativeTabs

/**
 * Created by anshuman on 26-05-2014.
 */
class CreativeTabBase(val tabLabel: String, var icon: Item) extends CreativeTabs(CreativeTabs.getNextID, tabLabel) {
  override def getTabIconItem: Item = icon
}
