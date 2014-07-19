package geek.lawsof.physics.lib.energy.heat

import geek.lawsof.physics.lib.metals.MetalUnits.WattsPerMeterKelvin

/**
 * Created by anshuman on 20-07-2014.
 */
object ThermalUnit {
  type Kelvin = Double

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