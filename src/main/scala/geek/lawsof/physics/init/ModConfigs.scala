package geek.lawsof.physics.init

import java.io.File

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent
import cpw.mods.fml.common.FMLCommonHandler
import geek.lawsof.physics.lib.util.helpers.Log
import geek.lawsof.physics.{LawsOfPhysicsMod, Reference}
import net.minecraftforge.common.config.Configuration

object ModConfigs {
  var options = new configFile("GameOptions", syncOptions)

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