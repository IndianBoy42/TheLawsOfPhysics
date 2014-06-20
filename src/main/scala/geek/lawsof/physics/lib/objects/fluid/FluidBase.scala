package geek.lawsof.physics.lib.objects.fluid

import net.minecraftforge.fluids.{FluidStack, FluidContainerRegistry, FluidRegistry, Fluid}
import net.minecraft.block.material.Material
import geek.lawsof.physics.lib.objects.info.FluidInfo
import geek.lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.item.ItemStack

class FluidBase(fluidName: String, material: Material, ctab: CreativeTabBase) extends Fluid(fluidName) {
  FluidRegistry.registerFluid(this)
  this.block = new FluidBlockBase(this, material, ctab)

  def this(fluidName: String, material: Material, ctab: CreativeTabBase, temp: Int, density: Int, viscosity: Int, luminescence: Int) = {
    this(fluidName, material, ctab)
    this setTemperature temp
    this setDensity density
    this setViscosity viscosity
    this setLuminosity luminescence
    isGaseous = density < 0
  }

  def this(fluidName: String, material: Material, ctab: CreativeTabBase, info: FluidInfo) = this(fluidName, material, ctab, info.temperature, info.density, info.viscosity, info.luminosity)

  def newFluidStack(vol: Int = FluidContainerRegistry.BUCKET_VOLUME) = new FluidStack(this, vol)

  def newItemStack(size: Int = 1) = new ItemStack(this.block, size)
}
