package geek.lawsof.physics.lib.config

import java.util

import cpw.mods.fml.client.IModGuiFactory
import cpw.mods.fml.client.IModGuiFactory.{RuntimeOptionCategoryElement, RuntimeOptionGuiHandler}
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiScreen

/**
 * Created by anshuman on 03-07-2014.
 */
object ConfigGUIFactory extends IModGuiFactory {
  override def initialize(minecraftInstance: Minecraft): Unit = {}

  override def runtimeGuiCategories(): util.Set[RuntimeOptionCategoryElement] = null

  override def getHandlerFor(element: RuntimeOptionCategoryElement): RuntimeOptionGuiHandler = null

  override def mainConfigGuiClass(): Class[_ <: GuiScreen] = null
}
