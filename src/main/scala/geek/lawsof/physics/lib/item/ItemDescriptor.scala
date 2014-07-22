package geek.lawsof.physics.lib.item

import java.util._

import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.item.traits.{CustomTooltip, TextColor, whiteColor}
import geek.lawsof.physics.lib.util.helpers.NBTHelper
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.IIcon
import net.minecraft.world.World
import org.lwjgl.input.Keyboard

/**
 * Created by anshuman on 15-07-2014.
 */
class ItemDescriptor(val intName: String, val shiny: Boolean = false, val txtColor: TextColor = whiteColor(), val tooltip: CustomTooltip = new CustomTooltip()) {

  def registered = item != null

  var item: ItemBase = null

  def +:(reg: ItemBase): Unit = {
    if (reg.metaCount != 32767) {
      item = reg
      item.items += (item.metaCount -> this)
      item.metaCount += 1
    }
    else throw new IndexOutOfBoundsException("The Amount Of SubItems Is OVER 32767!")
  }

  def register(reg: ItemBase) = reg +: this

  var icon: IIcon = null

  def registerIcon(reg: IIconRegister) = icon = reg.registerIcon(s"${Reference.MOD_ID}:$intName")

  def tooltipInfo(info: List[_]) = {
    for (str <- tooltip.mainTooltip) info.asInstanceOf[List[String]].add(str)
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
      for (str <- tooltip.shiftTooltip) info.asInstanceOf[List[String]].add(str)
    else info.asInstanceOf[List[String]].add(tooltip.shiftMessage)
    if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
      for (str <- tooltip.ctrlToolTip) info.asInstanceOf[List[String]].add(str)
    }
    else info.asInstanceOf[List[String]].add(tooltip.ctrlMessage)
  }

  def hasContainer = containerStack != null

  def containerStack: (ItemStack, Boolean) = null

  def initNBT(stack: ItemStack, w: World, p: EntityPlayer) = NBTHelper.initNBTTagCompound(stack)

}
