package geek.lawsof.physics.init

import geek.lawsof.physics.lib.materials.metals._
import geek.lawsof.physics.lib.util.helpers.{Log, Recipes}

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMaterials {

  def preInit() = {
    Log.info("Registering Metal Objects")

    MetalIngots.registerItem()
    MetalBlocks.registerBlock()
    MetalOres.registerBlock()

    Log.info("Creating Metal Sets")

    initMetal(MetalPresets.copperMetal)

  }

  def init() = {
    Log.info("Adding Recipes for Metal Sets")

    initMetalRecipes(MetalPresets.copperMetal)
  }


  def initMetal(info: MetalInfo) {
    MetalIngots.add(info)
    MetalBlocks.add(info)
    MetalOres.add(info)
  }

  def initMetalRecipes(info: MetalInfo) {
    //ingots -> blocks
    Recipes.shapedRecipe(MetalBlocks.newMetalStack(info, 1), "iii", "iii", "iii", char2Character('i'), MetalIngots.newMetalStack(info, 1))
    //blocks -> ingots
    Recipes.shapedRecipe(MetalIngots.newMetalStack(info, 9), "b", char2Character('b'), MetalBlocks.newMetalStack(info, 1))
    //ores -> ingots
    Recipes.smeltingRecipe(MetalIngots.newMetalStack(info, 1), MetalOres.newMetalStack(info, 1))
  }

}
