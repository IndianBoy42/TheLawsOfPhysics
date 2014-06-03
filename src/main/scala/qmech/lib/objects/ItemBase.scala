package qmech.lib.objects

import net.minecraft.item.Item
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import qmech.mod.init.Reference

/**
 * Created by anshuman on 26-05-2014.
 */
class ItemBase(intName: String) extends Item {
  this.setTextureName(Reference.MOD_ID + ":" + intName)
  this.setInternalName(intName)

  def this(intName: String, ctab: CreativeTabs, stackSize: Int) = {
    this(intName)
    setCreativeTabs(ctab)
    setStackSize(stackSize)
    registerItem()
  }

  def setCreativeTabs(ctab: CreativeTabs): ItemBase = {
    this.setCreativeTab(ctab)
    this
  }

  def setStackSize(size: Int): ItemBase = {
    this.setMaxStackSize(size).asInstanceOf[ItemBase]
  }

  def setInternalName(name: String): ItemBase = {
    this.setUnlocalizedName(name)
    this
  }

  def registerItem() {
    GameRegistry.registerItem(this, this.getUnlocalizedName.substring(5))
  }
}
