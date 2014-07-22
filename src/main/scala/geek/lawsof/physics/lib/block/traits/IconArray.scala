package geek.lawsof.physics.lib.block.traits

import geek.lawsof.physics.Reference
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon

/**
 * Created by anshuman on 22-06-2014.
 */
class IconArray(var top: String,
                var bottom: String,
                var south: String,
                var north: String,
                var west: String,
                var east: String) {

  def register(reg: IIconRegister) = {
    topIcon = reg.registerIcon(s"${Reference.MOD_ID}:$top")
    bottomIcon = reg.registerIcon(s"${Reference.MOD_ID}:$bottom")
    southIcon = reg.registerIcon(s"${Reference.MOD_ID}:$south")
    northIcon = reg.registerIcon(s"${Reference.MOD_ID}:$north")
    eastIcon = reg.registerIcon(s"${Reference.MOD_ID}:$west")
    westIcon = reg.registerIcon(s"${Reference.MOD_ID}:$east")
  }

  def apply(side: Int) = side match {
    case 0 => bottomIcon
    case 1 => topIcon
    case 2 => northIcon
    case 3 => southIcon
    case 4 => westIcon
    case 5 => eastIcon
  }

  var topIcon: IIcon = null
  var bottomIcon: IIcon = null
  var southIcon: IIcon = null
  var northIcon: IIcon = null
  var eastIcon: IIcon = null
  var westIcon: IIcon = null

}

object IconArray {
  def apply(top: String,
            bottom: String,
            south: String,
            north: String,
            east: String,
            west: String) = new IconArray(top, bottom, south, north, east, west)

  def apply(name: String, iconType: IconArrayType = ezMultiSided()): IconArray = iconType match {
    case ezMultiSided() => IconArray(s"${name}_top", s"${name}_bottom", s"${name}_south", s"${name}_north", s"${name}_east", s"${name}_west")
    case singleSided() => IconArray(name, name, name, name, name, name)
  }
}

class IconArrayType
case class ezMultiSided() extends IconArrayType
case class singleSided() extends IconArrayType