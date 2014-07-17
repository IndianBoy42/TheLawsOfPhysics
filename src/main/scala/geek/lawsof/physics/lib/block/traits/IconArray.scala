package geek.lawsof.physics.lib.block.traits

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon

/**
 * Created by anshuman on 22-06-2014.
 */
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

  def apply(side: Int) = side match {
    case 0 => topIcon
    case 1 => bottomIcon
    case 2 => leftIcon
    case 3 => rightIcon
    case 4 => frontIcon
    case 5 => backIcon
  }

  var topIcon: IIcon = null
  var bottomIcon: IIcon = null
  var leftIcon: IIcon = null
  var rightIcon: IIcon = null
  var frontIcon: IIcon = null
  var backIcon: IIcon = null

}

object IconArray {
  def apply(top: String,
            bottom: String,
            left: String,
            right: String,
            front: String,
            back: String) = new IconArray(top, bottom, left, right, front, back)

  def apply(name: String, iconType: IconArrayType = ezMultiSided()): IconArray = iconType match {
    case ezMultiSided() => IconArray(s"${name}_top", s"${name}_bottom", s"${name}_left", s"${name}_right", s"${name}_front", s"${name}_back")
    case singleSided() => IconArray(name, name, name, name, name, name)
  }
}

class IconArrayType

case class ezMultiSided() extends IconArrayType

case class singleSided() extends IconArrayType