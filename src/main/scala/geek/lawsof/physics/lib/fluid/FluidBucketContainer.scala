package geek.lawsof.physics.lib.fluid

import cpw.mods.fml.common.eventhandler.Event.Result
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import geek.lawsof.physics.init.CTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.player.FillBucketEvent
import net.minecraftforge.fluids._

/**
 * Created by anshuman on 23-06-2014.
 */
object FluidBucketContainer extends FluidContainerBase("bucket", FluidContainerRegistry.BUCKET_VOLUME, CTabs.mainTab) {
  MinecraftForge.EVENT_BUS.register(this)

  override def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack = itemStack

  //todo place fluid if canPlaceFluid(==true)

  @SubscribeEvent
  def onBucketFill(evt: FillBucketEvent): Unit = {
    var res: ItemStack = fillContainer(evt.world, evt.target)
    if (res != null) {
      evt.result = res
      evt.setResult(Result.ALLOW)
    }
  }
}
