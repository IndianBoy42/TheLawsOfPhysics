package geek.lawsof.physics.lib.item.traits

/**
 * Created by anshuman on 23-06-2014.
 */
class CustomTooltip (val mainTooltip: List[String] = List.empty,
                     val shiftTooltip: List[String] = List.empty,
                     val ctrlToolTip: List[String] = List.empty,
                     val shiftMessage: String = "Hold Shift For More Info",
                     val ctrlMessage: String = "Hold Ctrl For Description")
