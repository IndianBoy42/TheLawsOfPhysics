package geek.lawsof.physics.lib.energy.heat

import geek.lawsof.physics.lib.energy.heat.ThermalUnit.Kelvin

/**
 * Created by anshuman on 20-07-2014.
 */
trait ThermalConductor {
  def conduct(temperature: Kelvin)
}
