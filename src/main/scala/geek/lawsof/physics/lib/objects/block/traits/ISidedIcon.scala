package geek.lawsof.physics.lib.objects.block.traits

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import cpw.mods.fml.relauncher.{Side, SideOnly}

/**
 * Created by anshuman on 22-06-2014.
 */
trait ISidedIcon {
  @SideOnly(Side.Client)
  def iconArray: IconArray

  def registerBlockIcons(reg: IIconRegister): Unit = iconArray.register(reg)

  def getIcon(side: Int, meta: Int): IIcon = {
    side match {
      case TOP_ICON => iconArray.topIcon
      case BOTTOM_ICON => iconArray.bottomIcon
      case LEFT_ICON => iconArray.leftIcon
      case RIGHT_ICON => iconArray.rightIcon
      case FRONT_ICON => iconArray.frontIcon
      case BACK_ICON => iconArray.backIcon
    }
  }

  val TOP_ICON = 1
  val BOTTOM_ICON = 0
  val LEFT_ICON = 4
  val RIGHT_ICON = 3
  val FRONT_ICON = 2
  val BACK_ICON = 5

}

class IconArray(var top: String,
                var bottom: String,
                var left: String,
                var right: String,
                var front: String,
                var back: String) {

  def register(reg: IIconRegister) = {
    topIcon = reg.registerIcon(top)
    bottomIcon = reg.registerIcon(bottom)
    leftIcon = reg.registerIcon(left)
    rightIcon = reg.registerIcon(right)
    frontIcon = reg.registerIcon(front)
    backIcon = reg.registerIcon(back)
  }

  var topIcon: IIcon
  var bottomIcon: IIcon
  var leftIcon: IIcon
  var rightIcon: IIcon
  var frontIcon: IIcon
  var backIcon: IIcon

}

object IconArray {
  def apply(top: String,
            bottom: String,
            left: String,
            right: String,
            front: String,
            back: String) = new IconArray(top, bottom, left, right, front, back)

  def apply (name: String) = {
    IconArray(s"${name}_top",s"${name}_bottom",s"${name}_left",s"${name}_right",s"${name}_front",s"${name}_back")
  }


}