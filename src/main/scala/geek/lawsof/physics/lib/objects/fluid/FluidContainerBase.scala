package geek.lawsof.physics.lib.objects.fluid

import geek.lawsof.physics.lib.objects.item.{GenericSubItem, MetaItemBase}
import net.minecraftforge.fluids.{Fluid, FluidStack, FluidContainerRegistry, FluidRegistry}
import net.minecraft.item.ItemStack
import net.minecraft.util.MovingObjectPosition
import net.minecraft.block.Block
import geek.lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import geek.lawsof.physics.Reference

/**
 * Created by anshuman on 17-05-2014.
 */
class FluidContainerBase(intName: String, vol: Int, ctab: CreativeTabBase, registerAll: Boolean) extends MetaItemBase(intName) {
  this.setTextureName(Reference.MOD_ID + ":" + intName)
  this.setUnlocalizedName("")
  this.setCreativeTab(ctab)
  registerItem(0, new GenericSubItem("empty"))
  registerFluid(FluidRegistry.WATER)
  registerFluid(FluidRegistry.LAVA)

  def registerFluid(fluid: Fluid) {
    val fName: String = fluid.getName
    val fID: Int = FluidRegistry.getFluidID(fName)
    registerItem(fID, new GenericSubItem(fName))
    FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, vol), newItemStack(fID))
  }

  override def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack = {
    if (itemStack.getItemDamage != 0) {
      return itemStack
    }
    val mop: MovingObjectPosition = this.getMovingObjectPositionFromPlayer(world, player, true)
    val x: Int = mop.blockX
    val y: Int = mop.blockY
    val z: Int = mop.blockZ
    val block: Block = world.getBlock(x, y, z)
    val fluid: Fluid = FluidRegistry.lookupFluidForBlock(block)
    if (fluid == null) {
      return itemStack
    }
    val ID: Int = FluidRegistry.getFluidID(fluid.getName)
    if (world.getBlockMetadata(x, y, z) == 0) {
      world.setBlockToAir(x, y, z)
      player.inventory.addItemStackToInventory(newItemStack(ID))
      new ItemStack(itemStack.getItem, itemStack.stackSize - 1, 0)
    }
    else itemStack
  }

  var fluidVol: Int = FluidContainerRegistry.BUCKET_VOLUME
}