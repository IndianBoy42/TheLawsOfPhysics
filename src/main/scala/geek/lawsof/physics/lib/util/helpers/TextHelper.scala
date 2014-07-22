package geek.lawsof.physics.lib.util.helpers

import net.minecraft.util.StatCollector

object TextHelper {
  //Call these to color your Strings. Remember to call the format before color.
  /** Color Coding **/
  final val BLACK: String = 167.asInstanceOf[Char] + "0"
  final val BLUE: String = 167.asInstanceOf[Char] + "1"
  final val GREEN: String = 167.asInstanceOf[Char] + "2"
  final val TEAL: String = 167.asInstanceOf[Char] + "3"
  final val RED: String = 167.asInstanceOf[Char] + "4"
  final val PURPLE: String = 167.asInstanceOf[Char] + "5"
  final val ORANGE: String = 167.asInstanceOf[Char] + "6"
  final val LIGHT_GRAY: String = 167.asInstanceOf[Char] + "7"
  final val GRAY: String = 167.asInstanceOf[Char] + "8"
  final val LIGHT_BLUE: String = 167.asInstanceOf[Char] + "9"
  final val BRIGHT_GREEN: String = 167.asInstanceOf[Char] + "a"
  final val BRIGHT_BLUE: String = 167.asInstanceOf[Char] + "b"
  final val LIGHT_RED: String = 167.asInstanceOf[Char] + "c"
  final val PINK: String = 167.asInstanceOf[Char] + "d"
  final val YELLOW: String = 167.asInstanceOf[Char] + "e"
  final val WHITE: String = 167.asInstanceOf[Char] + "f"
  //Call these to format your Strings. Remember to call the format before color.
  /** Text formatting **/
  final val OBFUSCATED: String = 167.asInstanceOf[Char] + "k"
  final val BOLD: String = 167.asInstanceOf[Char] + "l"
  final val STRIKETHROUGH: String = 167.asInstanceOf[Char] + "m"
  final val UNDERLINE: String = 167.asInstanceOf[Char] + "n"
  final val ITALIC: String = 167.asInstanceOf[Char] + "o"
  final val END: String = 167.asInstanceOf[Char] + "r"
  //Call this to localize your text with a lang file.
  /** Enable Localizationizing **/
  def localize(key: String): String = {
    return StatCollector.translateToLocal(key)
  }
}
