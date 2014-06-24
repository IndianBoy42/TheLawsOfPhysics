package geek.lawsof.physics.lib.energy.electric

/**
 * Created by anshuman on 24-06-2014.
 */
trait IElectricConsumer extends IElectricBlock {
  def currentDemand: Double
}
