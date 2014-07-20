package geek.lawsof.physics.lib.energy.electric

/**
 * Created by anshuman on 19-07-2014.
 */
class ElectricalUnit(val current: Double, val voltage: Double)

object ElectricalUnit {
  def conduct(current: Ampere, voltage: Volt, resistance: Ohm) = new ElectricalUnit(current, voltage - (current * resistance))

  def conduct(electricity: ElectricalUnit, resistance: Ohm): ElectricalUnit = conduct(electricity.current, electricity.voltage, resistance)

  def split(electricity: ElectricalUnit, branches: Int) = for (i <- 1 to branches) yield new ElectricalUnit(electricity.current / branches, electricity.voltage)

  type Ampere = Double
  type Volt = Double
  type Ohm = Double
  type Faraday = Double
}
