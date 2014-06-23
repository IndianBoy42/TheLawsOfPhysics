package geek.lawsof.physics.lib.item.traits

import net.minecraft.item.{EnumRarity, ItemStack}

/**
 * Created by anshuman on 23-06-2014.
 */
trait IColoredText {
  def getRarity(par1ItemStack: ItemStack): EnumRarity
}

object TextColor {
  val colorWhite = EnumRarity.common
  val colorYellow = EnumRarity.uncommon
  val colorPurple = EnumRarity.epic
  val colorBlue = EnumRarity.rare
}
