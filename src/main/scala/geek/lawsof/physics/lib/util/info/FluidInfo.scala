package geek.lawsof.physics.lib.util.info

/**
 * Created by anshuman on 26-05-2014.
 */
class FluidInfo(var luminosity: Int = 0, var viscosity: Int = 1000, var density: Int = 1000, var temperature: Int = 295)

class FluidInfoModifier(var luminosity: Int = 0, var viscosity: Int = 0, var density: Int = 0, var temperature: Int = 0) {
  def + (fluid: FluidInfo) = new FluidInfo(fluid.luminosity + luminosity, fluid.viscosity + viscosity, fluid.density + density, fluid.temperature + temperature)
}