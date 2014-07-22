package geek.lawsof.physics.lib.energy.electric

import geek.lawsof.physics.lib.energy.electric.ElectricalUnit.Ohm
import geek.lawsof.physics.lib.util.info.Coord
import net.minecraft.world.World

/**
 * Created by anshuman on 24-06-2014.
 */
trait ElectricConductor extends ElectricNode{
  def resistance: Ohm

  def conduct(electricity: ElectricalUnit)
}
