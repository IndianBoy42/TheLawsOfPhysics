package qmech.mod.content.metals

import qmech.lib.objects.equip.types.ArmorTypeBase
import qmech.lib.objects.info._
import net.minecraft.item.ItemArmor.ArmorMaterial
import scala.tools.cmd.gen.AnyVals.F

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

object MetalPresets {

  val TO_HARDNESS = 1 / 100
  val TO_ARMOR_DURABILITY = 1 / 40
  val TO_TOOL_DURABILITY = 1
  val TO_TOOL_SPEED = 1
  val TO_TOOL_DAMAGE = 1
  val TO_ENCHANTABILITY = 1

  def MINING_LEVEL (yieldStrength: Double) = (Math.log(yieldStrength/2) / Math.log(2)).toInt

  def add (arr: Array[Int], num: Int): Array[Int] = for (obj <- arr) yield obj + num

  def round (num: Int, to: Int = 1) = ((num / to) + 0.5).toInt

  private val copperProps = new SimpleMetalProperties(63.546, 1357.77, 2835, 8960, 13.26, 300.4, 24.44, 401, 16.78, 220, 70, 745.5, 1.9)

  def getMetalInfo (name: String, props: MetalProperties) =
    new SimpleMetalInfo(name,
      new BlockInfo((props.tensileStrength * TO_HARDNESS).toFloat, (props.tensileStrength * TO_HARDNESS).toFloat, "pickaxe", MINING_LEVEL(props.yieldStrength)),
      new FluidInfo(0, 5000, props.density.toInt, props.meltingPoint.toInt),
      new GenStats(8, 64, 8, 8),
      new ArmorInfo((props.tensileStrength * TO_TOOL_DURABILITY).toInt, add (Array(1, 3, 2, 1), round(props.yieldStrength.toInt * TO_HARDNESS)), (props.electroNegativity * TO_ENCHANTABILITY).toInt),
      new ToolInfo(MINING_LEVEL(props.yieldStrength), props.tensileStrength.toInt * TO_TOOL_DURABILITY, props.yieldStrength.toInt * TO_TOOL_SPEED, props.yieldStrength.toInt * TO_TOOL_DAMAGE, props.electroNegativity.toInt * TO_ENCHANTABILITY),
      props)

  val copper = getMetalInfo("Copper", copperProps)

}

class SimpleMetalInfo(val name: String,
                      val getBlockInfo: BlockInfo, val getFluidInfo: FluidInfo,
                      val getOreGenInfo: GenStats,
                      val getArmorInfo: ArmorInfo, val getToolInfo: ToolInfo,
                      val getMetalProperties: MetalProperties)
  extends MetalInfo
