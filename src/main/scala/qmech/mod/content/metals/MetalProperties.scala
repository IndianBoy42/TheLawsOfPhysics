package qmech.mod.content.metals

/**
 * Created by anshuman on 01-06-2014.
 */
trait MetalProperties {

  //Amount of Heat Energy Required to/Lost While Changing the State Of Matter of 1 Gram of this Material
  //J/g (joules per gram)
  def latentHeat: Double

  //Amount of Heat Energy Required to Heat 1 Gram of this Material by 1 degree
  //J/gK (joules per gram degrees kelvin)
  def heatCapacity: Double

  //Amount of Heat Energy that passes through a Unit Cube of this Material
  //When a temperature gradient of 1 Degrees Kelvin Exist between 2 opposite faces
  //J (Joules)
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
  //Pascals (N/m^2 (newtons per square meter) )
  def tensileStrength: Double

  //The Amount of Stress before the material starts deforming
  //Pascals (N/m^2 (newtons per square meter) )
  def yieldStrength: Double

  //Electrical Energy Lost/Gain when an atom of this Material Gains/Loses and Electron
  //kJ/mol
  def ionizationEnergy: Double

  //Tendency for this Material to gain/attract electrons
  //Arbitrary Units
  def electroNegativity: Double

  //The Limit to which this Material can be magnetized (in terms of Teslas)
  //when a Magnetic Field is Applied (of unit Strength (in terms of Teslas) )
  //Arbitrary Units
  def magneticSusceptibility: Double

  //The Limit to which this Material can be polarized (in terms of Coulumb-metres)
  //when an Electric Field is Applied (of unit Strength (in terms of Newtons per Coulumb) )
  def electricSusceptibility: Double

}

class SimpleMetalProperties(val meltingPoint: Double, val boilingPoint: Double,
                            val density: Double,
                            val latentHeat: Double, val heatCapacity: Double,
                            val thermalConductivity: Double, val electricalResistance: Double,
                            val tensileStrength: Double, val yieldStrength: Double,
                            val ionizationEnergy: Double, val electroNegativity: Double,
                            val magneticSusceptibility: Double, val electricSusceptibility: Double)
  extends MetalProperties
