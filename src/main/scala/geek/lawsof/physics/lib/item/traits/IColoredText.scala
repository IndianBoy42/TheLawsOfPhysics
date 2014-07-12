package geek.lawsof.physics.lib.item.traits

import net.minecraft.item.{EnumRarity, ItemStack}

/**
 * Created by anshuman on 23-06-2014.
 */
trait IColoredText {
  def color: TextColor
}

//object TextColor {
//  val colorWhite = EnumRarity.common
//  val colorYellow = EnumRarity.uncommon
//  val colorPurple = EnumRarity.epic
//  val colorBlue = EnumRarity.rare
//}

class TextColor(val color: EnumRarity)
case class whiteColor() extends TextColor(EnumRarity.common)
case class yellowColor() extends TextColor(EnumRarity.uncommon)
case class purpleColor() extends TextColor(EnumRarity.epic)
case class blueColor() extends TextColor(EnumRarity.rare)