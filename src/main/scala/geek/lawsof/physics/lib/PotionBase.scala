package geek.lawsof.physics.lib

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import geek.lawsof.physics.lib.util.handler.MinecraftForgeEventBus
import net.minecraft.potion.Potion
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent

/**
 * Created by anshuman on 22-07-2014.
 */
class PotionBase(name: String, id: Int, val potionEffectUpdate: LivingUpdateEvent => Unit, neg: Boolean = false, color: Int = 0, iconIndex: (Int, Int)) extends Potion(id, neg, color) {
  setPotionName(name)
  setIconIndex(iconIndex._1, iconIndex._2)
  MinecraftForgeEventBus += this

  @SubscribeEvent
  def entityLivingUpdate(evt: LivingUpdateEvent) = {
    if (evt.entityLiving.isPotionActive(this)) potionEffectUpdate(evt)
    if (evt.entityLiving.getActivePotionEffect(this).getDuration == 0) evt.entityLiving.removePotionEffect(this.id)
  }
}
