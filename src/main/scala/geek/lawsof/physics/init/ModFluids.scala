package geek.lawsof.physics.init

import geek.lawsof.physics.lib.fluid.FluidContainerBase
import geek.lawsof.physics.lib.util.helpers.Log
import net.minecraftforge.fluids.{Fluid, FluidContainerRegistry}

/**
 * Created by anshuman on 26-05-2014.
 */
object ModFluids {
  lazy val cell: FluidContainerBase = new FluidContainerBase("cell", FluidContainerRegistry.BUCKET_VOLUME, CTabs.techTab)

  def preInit() = {
    Log.info("Creating Fluid Containers")

    cell.registerItem()

    Log.info("Creating Fluids")



    Log.info("Registering Fluid Containers")

  }

  def init() = {

  }

  def registerFluid(fluid: Fluid) = {
    cell.registerFluid(fluid)
  }
}
