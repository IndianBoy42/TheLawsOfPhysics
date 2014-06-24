package geek.lawsof.physics.lib.energy.electric

/**
 * Created by anshuman on 24-06-2014.
 */
trait IElectricGrid {
  def connect(conductor: IConductor)

  def connect(block: IElectricBlock)
}
