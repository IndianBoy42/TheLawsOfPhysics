package geek.lawsof.physics.lib.fluid

import geek.lawsof.physics.lib.CreativeTabBase
import geek.lawsof.physics.lib.info.FluidInfo
import net.minecraft.block.material.Material
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.{Fluid, FluidContainerRegistry, FluidRegistry, FluidStack}

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
