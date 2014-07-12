package geek.lawsof.physics.init

import net.minecraftforge.common.config.Configuration
import java.io.File
import geek.lawsof.physics.{Reference, LawsOfPhysicsMod}
import geek.lawsof.physics.lib.util.Log
import net.minecraftforge.common.MinecraftForge
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent
import cpw.mods.fml.common.FMLCommonHandler
import net.minecraft.client.gui.GuiScreen
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionCategoryElement
import net.minecraft.client.Minecraft

object ModConfigs {
  var options = new configFile("GameOptions", syncOptions(_))

  def syncOptions(evt: OnConfigChangedEvent) = {

  }

  def preInit() {
    Log.info("Creating Config Files")
  }
}


class configFile(name: String,
                 val sync: (OnConfigChangedEvent) => Unit = (evt) => {})
  extends Configuration(new File(LawsOfPhysicsMod.preInitEvt.getModConfigurationDirectory, s"${Reference.MOD_ID}$name")) {
  FMLCommonHandler.instance().bus().register(this)

  override def save(): Unit = if (this.hasChanged) super.save()

  def onConfigChanged(evt: OnConfigChangedEvent) = if (evt.modID == Reference.MOD_ID) sync(evt)
}