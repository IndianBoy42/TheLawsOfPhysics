package geek.lawsof.physics.init

import geek.lawsof.physics.init.content.PoweredFurnace.{PoweredFurnaceDescriptor, PoweredFurnaceBlock}
import geek.lawsof.physics.lib.materials.metals._
import geek.lawsof.physics.lib.util.helpers.{Log, Recipes}

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMaterials {

  def preInit() = {
    Log.info("Creating Metal Sets")

    initMetal(MetalPresets.copperMetal)

    Log.info("Registering Metal Objects")

    MetalIngots.registerItem()
    MetalNuggets.registerItem()
    MetalBlocks.registerBlock()
    MetalOres.registerBlock()
  }

  def init() = {
    Log.info("Adding Recipes for Metal Sets")

    initMetalRecipes(MetalPresets.copperMetal)
  }


  def initMetal(info: MetalInfo) {
    MetalIngots.add(info)
    MetalNuggets.add(info)
    MetalBlocks.add(info)
    MetalOres.add(info)
    MoltenMetal.add(info)

    PoweredFurnaceBlock +: new PoweredFurnaceDescriptor(info)
  }

  def initMetalRecipes(info: MetalInfo) {
    Recipes.reversibleCompressionCraft(MetalBlocks.newMetalStack(info), MetalIngots.newMetalStack(info))
    Recipes.reversibleCompressionCraft(MetalIngots.newMetalStack(info), MetalNuggets.newMetalStack(info))
    Recipes.smeltingRecipe(MetalIngots.newMetalStack(info), MetalOres.newMetalStack(info))
  }

}
