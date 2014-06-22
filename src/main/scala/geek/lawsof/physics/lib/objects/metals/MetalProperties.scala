package geek.lawsof.physics.lib.objects.metals

/**
 * Created by anshuman on 01-06-2014.
 */
trait MetalProperties {

  //Weight of one mole of this Material
  //g
  def atomicWeight: Double

  //Amount of Heat Energy Required to/Lost While Changing the State Of Matter of 1 Gram of this Material
  //J/mol (joules per mole)
  def latentHeatOfFusion: Double
  def latentHeatOfVaporization: Double

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

class SimpleMetalProperties(var atomicWeight: Double,
                            var meltingPoint: Double, var boilingPoint: Double,
                            var density: Double,
                            var latentHeatOfFusion: Double, var latentHeatOfVaporization: Double,
                            var heatCapacity: Double,
                            var thermalConductivity: Double, var electricalResistance: Double,
                            var tensileStrength: Double, var yieldStrength: Double,
                            var ionizationEnergy: Double, var electroNegativity: Double)
  extends MetalProperties
