package geek.lawsof.physics.lib.config

import net.minecraft.client.gui.GuiScreen
import cpw.mods.fml.client.config.{IConfigElement, GuiConfig}
import java.util
import geek.lawsof.physics.Reference
import geek.lawsof.physics.init.ModConfigs
import net.minecraftforge.common.config.ConfigElement
import scala.collection.JavaConverters._
import scala.collection.mutable

/**
 * Created by anshuman on 26-06-2014.
 */
class ConfigGUI(parent: GuiScreen, elements: util.List[IConfigElement[_]]) extends
  GuiConfig(parent, elements, Reference.MOD_ID, false, false, Reference.MOD_NAME){
}

object ConfigGUI {
  def apply(parent: GuiScreen): ConfigGUI = {
    val propsAsElemsInList: List[IConfigElement[_]] = for {
      cfg <- ModConfigs.getAllFiles
      name <- cfg.getCategoryNames.asScala
      cat: ConfigElement[_] = new ConfigElement(cfg.getCategory(name))
      prop <- cat.getChildElements.asScala
    } yield prop
    new ConfigGUI(parent, propsAsElemsInList.asJava)
  }
}
