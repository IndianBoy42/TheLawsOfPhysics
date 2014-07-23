package geek.lawsof.physics.lib.energy.electric

import geek.lawsof.physics.lib.energy.electric.ElectricalUnits.{Ampere, Volt, Ohm}

/**
 * Created by anshuman on 23-07-2014.
 */
object ElectricityHelper {
  def conduct(current: Ampere, voltage: Volt, resistance: Ohm) = new ElectricalUnits(current, voltage - (current * resistance))

  def conduct(electricity: ElectricalUnits, resistance: Ohm): ElectricalUnits = conduct(electricity.current, electricity.voltage, resistance)
}
