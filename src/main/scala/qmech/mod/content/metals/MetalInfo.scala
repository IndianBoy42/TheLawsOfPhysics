package qmech.mod.content.metals

import qmech.lib.objects.equip.types.ArmorTypeBase
import qmech.lib.objects.info._

/**
 * Created by anshuman on 28-05-2014.
 */
trait MetalInfo {
  def name: String

  def getBlockInfo: BlockInfo

  def getFluidInfo: FluidInfo

  def getOreGenInfo: GenStats

  def getArmorInfo: ArmorInfo

  def getToolInfo: ToolInfo

  def getMetalProperties: MetalProperties

//  def getMineralComposition: MineralComposition
}

class SimpleMetalInfo(val name: String,
                      val getBlockInfo: BlockInfo, val getFluidInfo: FluidInfo,
                      val getOreGenInfo: GenStats,
                      val getArmorInfo: ArmorInfo, val getToolInfo: ToolInfo,
                      val getMetalProperties: MetalProperties)
  extends MetalInfo
