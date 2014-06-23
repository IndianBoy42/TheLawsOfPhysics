package geek.lawsof.physics.init

import geek.lawsof.physics.lib.fluid.{FluidBucketContainer, FluidContainerBase}
import net.minecraftforge.fluids.{Fluid, FluidContainerRegistry}
import geek.lawsof.physics.lib.helper.Log

/**
 * Created by anshuman on 26-05-2014.
 */
object ModFluids {
  var cell: FluidContainerBase = null
  var bucket: FluidBucketContainer = null

  def preInit() = {
    Log.info("Creating Fluid Containers")

    cell = new FluidContainerBase("cell", FluidContainerRegistry.BUCKET_VOLUME, CTabs.techTab)
    bucket = new FluidBucketContainer("bucket", CTabs.techTab)

    Log.info("Creating Fluids")

  }

  def init() = {
    Log.info("Registering Fluid Containers")

  }

  def registerFluid (fluid: Fluid) = {
    cell.registerFluid(fluid)
  }
}
