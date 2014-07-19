package geek.lawsof.physics.lib.energy.electric

/**
 * Created by anshuman on 24-06-2014.
 */
trait ElectricalNetwork {
  def connect(block: ElectricNode)
}

trait ElectricNode {
  var parent: ElectricalNetwork = null

  def connected = parent != null
}

