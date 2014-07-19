package geek.lawsof.physics.lib.metals

import geek.lawsof.physics.lib.energy.heat.ThermalUnit.Kelvin
import geek.lawsof.physics.lib.metals.MetalUnits._

/**
 * Created by anshuman on 01-06-2014.
 */
trait MetalProperties {
  //Weight of one mole of this Material
  //g
  def atomicWeight: Gram

  //Amount of Heat Energy Required to/Lost While Changing the State Of Matter of 1 Gram of this Material
  //J/mol (joules per mole)
  def latentHeatOfFusion: JoulesPerMole

  def latentHeatOfVaporization: JoulesPerMole

  //Amount of Heat Energy Required to Heat 1 Gram of this Material by 1 degree
  //J/molK (joules per mole degrees kelvin)
  def heatCapacity: JoulesPerMoleKelvin

  //Amount of Heat Energy that passes through a Unit Cube of this Material
  //When a temperature gradient of 1 Degrees Kelvin Exist between 2 opposite faces
  //W/mK (watts per meter kelvin)
  def thermalConductivity: WattsPerMeterKelvin

  //The Resistance of a Square-Prism of unit length and cross-sectional area
  //ohm-meters
  def electricalResistance: OhmMeters

  //Melting/Freezing Point of this Material
  //K (degrees in kelvin scale)
  def meltingPoint: Kelvin

  //Boiling/Condensation Point of this Material
  //K (degrees in kelvin scale)
  def boilingPoint: Kelvin

  //Amount of Mass in 1 Cubic-Meter of this Material
  //Kg/m^3 (kilograms per cubic meter)
  def density: KgPerMetersSquared

  //The Amount of Stress before the material breaks
  //MegaPascals (Mega - N/m^2 (newtons per square meter) )
  def tensileStrength: Pascal

  //The Amount of Stress before the material starts deforming
  //Pascals (N/m^2 (newtons per square meter) )
  def yieldStrength: Pascal

  //Electrical Energy Lost/Gain when an atom of this Material Gains/Loses and Electron
  //kJ/mol
  def ionizationEnergy: KJPerMole

  //Tendency for this Material to gain/attract electrons
  //Pauling's Scale
  def electroNegativity: PaulingScaleUnit
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

object MetalUnits {
  type Gram = Double
  type JoulesPerMole = Double
  type JoulesPerMoleKelvin = Double
  type WattsPerMeterKelvin = Double
  type OhmMeters = Double
  type KgPerMetersSquared = Double
  type Pascal = Double
  type MegaPascal = Double
  type KJPerMole = Double
  type PaulingScaleUnit = Double
}