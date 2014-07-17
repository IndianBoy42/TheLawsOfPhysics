package geek.lawsof.physics.init

import geek.lawsof.physics.lib.fluid.FluidContainerBase
import geek.lawsof.physics.lib.util.Log
import net.minecraftforge.fluids.{Fluid, FluidContainerRegistry}

/**
 * Created by anshuman on 26-05-2014.
 */
object ModFluids {
  var cell: FluidContainerBase = null

  def preInit() = {
    Log.info("Creating Fluid Containers")

    cell = new FluidContainerBase("cell", FluidContainerRegistry.BUCKET_VOLUME, CTabs.techTab)

    Log.info("Creating Fluids")

  }

  def init() = {
    Log.info("Registering Fluid Containers")

  }

  def registerFluid(fluid: Fluid) = {
    cell.registerFluid(fluid)
  }
}
