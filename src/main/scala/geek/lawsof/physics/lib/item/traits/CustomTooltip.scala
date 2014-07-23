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

object CustomTooltip {
  def apply(mainTooltip: List[String] = List.empty,
            shiftTooltip: List[String] = List("<No More Information Available>"),
            ctrlToolTip: List[String] = List("<No More Information Available>"),
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
    val shiftMessage = StatCollector.translateToLocal(shiftUnlocalizedMessage)
    val ctrlMessge = StatCollector.translateToLocal(ctrlUnlocalizedMessage)
    CustomTooltip(mainTooltip, shiftTooltip, ctrlTooltip, shiftMessage, ctrlMessge)
  }
}
