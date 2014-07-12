package geek.lawsof.physics.lib.item.traits

/**
 * Created by anshuman on 23-06-2014.
 */
trait ICustomTooltipInfo {
  def mainTooltip: List[String]
  def shiftTooltip: List[String]
  def ctrlTooltip: List[String]
}

class CustomTooltip (val mainTooltip: List[String] = List.empty,
                     val shiftTooltip: List[String] = List.empty,
                     val ctrlToolTip: List[String] = List.empty)
