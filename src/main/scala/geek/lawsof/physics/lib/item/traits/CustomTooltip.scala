package geek.lawsof.physics.lib.item.traits

import net.minecraft.util.StatCollector

/**
 * Created by anshuman on 23-06-2014.
 */
class CustomTooltip(val mainTooltip: List[String] = List.empty,
                    val shiftTooltip: List[String] = List.empty,
                    val ctrlToolTip: List[String] = List.empty,
                    val shiftMessage: String = "Hold Shift For More Info",
                    val ctrlMessage: String = "Hold Ctrl For Description")

class LocalizedCustomTooltip(val mainUnlocalizedTooltip: List[String] = List.empty,
                             val shiftUnlocalizedTooltip: List[String] = List.empty,
                             val ctrlUnlocalizedToolTip: List[String] = List.empty,
                             val shiftUnlocalizedMessage: String = "tooltip.shift.message",
                             val ctrlUnlocalizedMessage: String = "tooltip.ctrl.message") extends CustomTooltip {}

object CustomTooltip {
  def apply(mainTooltip: List[String] = List.empty,
            shiftTooltip: List[String] = List.empty,
            ctrlToolTip: List[String] = List.empty,
            shiftMessage: String = "Hold Shift For More Info",
            ctrlMessage: String = "Hold Ctrl For Description") = new CustomTooltip(mainTooltip, shiftTooltip, ctrlToolTip, shiftMessage, ctrlMessage)

  def localized(mainUnlocalizedTooltip: List[String] = List.empty,
                shiftUnlocalizedTooltip: List[String] = List.empty,
                ctrlUnlocalizedToolTip: List[String] = List.empty,
                shiftUnlocalizedMessage: String = "tooltip.shift.message",
                ctrlUnlocalizedMessage: String = "tooltip.ctrl.message") = {
    val mainTooltip = mainUnlocalizedTooltip.filter(StatCollector.canTranslate).map(StatCollector.translateToLocal)
    val shiftTooltip = shiftUnlocalizedTooltip.filter(StatCollector.canTranslate).map(StatCollector.translateToLocal)
    val ctrlTooltip = ctrlUnlocalizedToolTip.filter(StatCollector.canTranslate).map(StatCollector.translateToLocal)
  }
}
