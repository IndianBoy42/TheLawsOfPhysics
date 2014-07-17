package geek.lawsof.physics.lib.item

import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.item.traits.{whiteColor, CustomTooltip, TextColor}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import org.lwjgl.input.Keyboard
import java.util._

/**
 * Created by anshuman on 15-07-2014.
 */
class ItemDescriptor(val intName: String, val shiny: Boolean = false, val txtColor: TextColor = whiteColor(), val tooltip: CustomTooltip = new CustomTooltip()) {

  def registered = item != null
  var item: ItemBase = null

  def +: (reg: ItemBase): Unit = {
    if(reg.metaCount == 32767) {
      item = reg
      item.items += (item.metaCount -> this)
      item.metaCount += 1
    }
  }

  def register (reg: ItemBase)= reg +: this

  var icon: IIcon = null

  def registerIcon(reg: IIconRegister) = icon = reg.registerIcon(s"${Reference.MOD_ID}:${intName}")

  def tooltipInfo (info: List[_]) = {
    for (str <- tooltip.mainTooltip) info.asInstanceOf[List[String]].add(str)
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
      for (str <- tooltip.shiftTooltip) info.asInstanceOf[List[String]].add(str)
    else info.asInstanceOf[List[String]].add(tooltip.shiftMessage)
    if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
      for (str <- tooltip.ctrlToolTip) info.asInstanceOf[List[String]].add(str)
    }
    else info.asInstanceOf[List[String]].add(tooltip.ctrlMessage)
  }

}
