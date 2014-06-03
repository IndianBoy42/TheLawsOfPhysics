package qmech.mod.content.metals

/**
 * Created by anshuman on 01-06-2014.
 */
trait MetalProperties {

  //Weight of one mole of this Material
  //g
  def atomicWeight: Double

  //Amount of Heat Energy Required to/Lost While Changing the State Of Matter of 1 Gram of this Material
  //J/mol (joules per mole)
  def latentHeat: Double

  //Amount of Heat Energy Required to Heat 1 Gram of this Material by 1 degree
  //J/molK (joules per mole degrees kelvin)
  def heatCapacity: Double

  //Amount of Heat Energy that passes through a Unit Cube of this Material
  //When a temperature gradient of 1 Degrees Kelvin Exist between 2 opposite faces
  //W/mK (watts per meter kelvin)
  def thermalConductivity: Double

  //The Resistance of a Square-Prism of unit length and cross-sectional area
  //ohm-meters
  def electricalResistance: Double

  //Melting/Freezing Point of this Material
  //K (degrees in kelvin scale)
  def meltingPoint: Double

  //Boiling/Condensation Point of this Material
  //K (degrees in kelvin scale)
  def boilingPoint: Double

  //Amount of Mass in 1 Cubic-Meter of this Material
  //Kg/m^3 (kilograms per cubic meter)
  def density: Double

  //The Amount of Stress before the material breaks
  //MegaPascals (Mega - N/m^2 (newtons per square meter) )
  def tensileStrength: Double

  //The Amount of Stress before the material starts deforming
  //Pascals (N/m^2 (newtons per square meter) )
  def yieldStrength: Double

  //Electrical Energy Lost/Gain when an atom of this Material Gains/Loses and Electron
  //kJ/mol
  def ionizationEnergy: Double

  //Tendency for this Material to gain/attract electrons
  //Pauling's Scale
  def electroNegativity: Double

}

class SimpleMetalProperties(val atomicWeight: Double = 63.546,
                            val meltingPoint: Double = 1357.77, val boilingPoint: Double = 2835,
                            val density: Double = 8960,
                            val latentHeat: Double = 13.26, val heatCapacity: Double = 24.44,
                            val thermalConductivity: Double = 401, val electricalResistance: Double = 16.78,
                            val tensileStrength: Double = 220, val yieldStrength: Double = 70,
                            val ionizationEnergy: Double = 745.5, val electroNegativity: Double = 1.90)
  extends MetalProperties
