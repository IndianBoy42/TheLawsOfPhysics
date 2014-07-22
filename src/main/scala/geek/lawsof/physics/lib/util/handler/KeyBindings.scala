package geek.lawsof.physics.lib.util.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent
import geek.lawsof.physics.lib.util.helpers.Log
import geek.lawsof.physics.{Reference, LawsOfPhysicsMod}
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard

import scala.collection.mutable

/**
 * Created by anshuman on 22-07-2014.
 */
object KeyBindings {
  private val bindings = mutable.MutableList.empty[KeyBindingBase]

  def registerKeyBinding(name: String, category: String, key: Int, onKeyPressed: () => Unit = () => {}) = bindings += new KeyBindingBase(name, category, key, onKeyPressed)

  def onModeSwitchKeyPressed() = {
    //todo switch modes or something
  }

  def init() = {
    Log("Register KeyBindings And KeyInputHandler")
    FMLEventBus += this

    registerKeyBinding("key.modeSwitch", s"key.category.${Reference.MOD_ID}",  Keyboard.KEY_M, onModeSwitchKeyPressed)
  }

  @SubscribeEvent
  def onKeyPressed(evt: KeyInputEvent) = bindings.filter(_.getIsKeyPressed).foreach(_.onKeyPressed)
}

class KeyBindingBase(name: String, category: String, key: Int, val onKeyPressed: () => Unit = () => {}) extends KeyBinding(name, key, category)