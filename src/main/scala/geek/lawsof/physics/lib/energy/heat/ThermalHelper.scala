package geek.lawsof.physics.lib.energy.heat

import geek.lawsof.physics.lib.energy.heat.ThermalUnits.Kelvin
import geek.lawsof.physics.lib.materials.MetalUnits._

/**
 * Created by anshuman on 23-07-2014.
 */
object ThermalHelper {
  def energyTransfer(origin: Kelvin, destination: Kelvin, conductance: WattsPerMeterKelvin) = {
    val gradient = origin - destination
    val direction = flowDirection(origin < destination)
    val energy = conductance * gradient
    (energy, direction)
  }
}

class flowDirection
object flowDirection {
  def apply(bool: Boolean) = if (bool) forward() else reverse()
}
case class forward() extends flowDirection
case class reverse() extends flowDirection