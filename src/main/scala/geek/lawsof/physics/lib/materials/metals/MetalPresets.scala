package geek.lawsof.physics.lib.materials.metals

import geek.lawsof.physics.lib.util.info._

/**
 * Created by anshuman on 19-06-2014.
 */
object MetalPresets {

  val TO_HARDNESS: Double = 0.001
  val TO_ARMOR_DURABILITY: Double = 0.025
  val TO_TOOL_DURABILITY: Double = 1
  val TO_TOOL_SPEED: Double = 1
  val TO_TOOL_DAMAGE: Double = 1
  val TO_ENCHANTABILITY: Double = 1

  def MINING_LEVEL(yieldStrength: Double) = (Math.log(yieldStrength / 2) / Math.log(2)).toInt

  def add(arr: Array[Int], num: Int): Array[Int] = for (obj <- arr) yield obj + num

  def round(num: Double, to: Double = 1.0): Double = ((num / to) + 0.5).toInt * to

  def getMetalInfo(name: String, props: MetalProperties) = new SimpleMetalInfo(name,
    new BlockInfo((props.tensileStrength * TO_HARDNESS).toFloat, (props.tensileStrength * TO_HARDNESS).toFloat, "pickaxe", MINING_LEVEL(props.yieldStrength)),
    new FluidInfo(0, 5000, props.density.toInt, props.meltingPoint.toInt),
    new GenStats(8, 64, 8, 8),
    new ArmorInfo((props.tensileStrength * TO_ARMOR_DURABILITY).toInt, add(Array(1, 3, 2, 1), round(props.yieldStrength * TO_HARDNESS).toInt), (props.electroNegativity * TO_ENCHANTABILITY).toInt),
    new ToolInfo(MINING_LEVEL(props.yieldStrength), (props.tensileStrength * TO_TOOL_DURABILITY).toInt, (props.yieldStrength * TO_TOOL_SPEED).toFloat, (props.yieldStrength * TO_TOOL_DAMAGE).toInt, (props.electroNegativity * TO_ENCHANTABILITY).toInt),
    props)

  private val copperProps = new SimpleMetalProperties(63.546, 1357.77, 2835, 8960, 13.26, 300.4, 24.44, 401, 16.78, 220, 70, 745.5, 1.9)
  val copperMetal = getMetalInfo("Copper", copperProps)
}
