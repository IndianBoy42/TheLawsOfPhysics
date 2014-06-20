package geek.lawsof.physics.init

import geek.lawsof.physics.lib.objects.fluid.FluidContainerBase
import net.minecraftforge.fluids.{Fluid, FluidContainerRegistry}

/**
 * Created by anshuman on 26-05-2014.
 */
object ModFluids {
  var cell: FluidContainerBase = null

  def preInit() = {
    cell = new FluidContainerBase("cell", FluidContainerRegistry.BUCKET_VOLUME, CTabs.Tech, false)
  }

  def registerFluid (fluid: Fluid) = {
    cell.registerFluid(fluid)
  }
}
