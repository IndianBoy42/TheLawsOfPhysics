package geek.lawsof.physics.init

import geek.lawsof.physics.lib.metals._
import geek.lawsof.physics.lib.util.{Recipes, Log}

/**
 * Created by anshuman on 01-06-2014.
 */
object ModMetals {

  def preInit() = {
    Log.info("Creating Metal Sets")

  }

  def init() = {
    Log.info("Adding Recipes for Metal Sets")
  }

  def initMetal(info: MetalInfo) {
    MetalIngots.add(info)
    MetalBlocks.add(info)
  }

  def initMetalRecipes(info: MetalInfo) {
    Recipes.shapedRecipe(MetalBlocks.newMetalStack(info, 1), "iii", "iii", "iii", char2Character('i'), MetalIngots.newMetalStack(info, 1))
    Recipes.shapelessRecipe(MetalIngots.newMetalStack(info, 9), MetalBlocks.newMetalStack(info, 1))
  }

}
