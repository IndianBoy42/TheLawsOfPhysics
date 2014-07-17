package geek.lawsof.physics.lib.energy.electric

/**
 * Created by anshuman on 24-06-2014.
 */
trait IElectricProducer extends IElectricBlock {
  def currentSupply: Double

  def voltageSupply: Double
}
