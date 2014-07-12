package geek.lawsof.physics.lib.fluid

import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import geek.lawsof.physics.lib.CreativeTabBase
import net.minecraftforge.fluids._
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.player.FillBucketEvent
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.util.MovingObjectPosition
import cpw.mods.fml.common.eventhandler.Event.Result
import net.minecraft.block.Block

/**
 * Created by anshuman on 23-06-2014.
 */
class FluidBucketContainer(intName: String, ctab: CreativeTabBase) extends FluidContainerBase(intName, FluidContainerRegistry.BUCKET_VOLUME, ctab){
  MinecraftForge.EVENT_BUS.register(this)

  override def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack = itemStack
  //todo place fluid if canPlaceFluid(==true)

  @SubscribeEvent
  def onBucketFill(evt: FillBucketEvent): Unit = {
    var res: ItemStack = fillContainer(evt.world, evt.target)
    if (res != null) {
      evt.result = res;
      evt.setResult(Result.ALLOW)
    }
  }
}
