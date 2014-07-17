package geek.lawsof.physics.lib.item.traits

import net.minecraft.item.EnumRarity

/**
 * Created by anshuman on 23-06-2014.
 */
class TextColor(val color: EnumRarity)

case class whiteColor() extends TextColor(EnumRarity.common)

case class yellowColor() extends TextColor(EnumRarity.uncommon)

case class purpleColor() extends TextColor(EnumRarity.epic)

case class blueColor() extends TextColor(EnumRarity.rare)