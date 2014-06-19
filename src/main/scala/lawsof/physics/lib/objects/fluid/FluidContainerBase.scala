package lawsof.physics.lib.objects.fluid

import lawsof.physics.lib.objects.item.{GenericSubItem, MetaItemBase}
import net.minecraftforge.fluids.{Fluid, FluidStack, FluidContainerRegistry, FluidRegistry}
import net.minecraft.item.ItemStack
import net.minecraft.util.MovingObjectPosition
import net.minecraft.block.Block
import lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import lawsof.physics.mod.init.Reference

/**
 * Created by anshuman on 17-05-2014.
 */
class FluidContainerBase(intName: String, vol: Int, ctab: CreativeTabBase, registerAll: Boolean) extends MetaItemBase(intName) {
  this.setTextureName(Reference.MOD_ID + ":" + intName)
  this.setUnlocalizedName("")
  this.setCreativeTab(ctab)
  registerItem(0, new GenericSubItem("empty"))
  if (registerAll) {
    registerFluids()
  }
  else {
    registerFluid(FluidRegistry.WATER)
    registerFluid(FluidRegistry.LAVA)
  }

  def registerFluid(fluid: Fluid) {
    val fName: String = fluid.getName
    val fID: Int = FluidRegistry.getFluidID(fName)
    registerItem(fID, new GenericSubItem(fName))
    FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, vol), newItemStack(fID))
  }

  def registerFluids() {
    {
      var i: Int = 0
      while (i < FluidRegistry.getMaxID + 1) {
        val fluid: Fluid = FluidRegistry.getFluid(i)
        if (fluid != null) {
          registerFluid(fluid)
          i += 1
        }
      }
    }
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