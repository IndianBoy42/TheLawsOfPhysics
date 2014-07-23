package geek.lawsof.physics.lib.materials.metals

import geek.lawsof.physics.lib.materials.MetalProperties
import geek.lawsof.physics.lib.util.info._

/**
 * Created by anshuman on 28-05-2014.
 */
trait MetalInfo {
  def name: String

  def fluidInfo: FluidInfo
  
  def oreGenInfo: GenStats

  def armorInfo: ArmorInfo

  def toolInfo: ToolInfo

  def metalProperties: MetalProperties

  //  def getMineralComposition: MineralComposition
}


class SimpleMetalInfo(val name: String,
                      val fluidInfo: FluidInfo,
                      val oreGenInfo: GenStats,
                      val armorInfo: ArmorInfo, val toolInfo: ToolInfo,
                      val metalProperties: MetalProperties)
  extends MetalInfo
