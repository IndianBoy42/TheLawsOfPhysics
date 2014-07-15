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
    Ingots.add(info)
    Blocks.add(info)
  }

  def initMetalRecipes(info: MetalInfo) {
    Recipes.shapedRecipe(Blocks.newItemStack(info, 1), "iii", "iii", "iii", char2Character('i'), Ingots.newItemStack(info, 1))
    Recipes.shapelessRecipe(Ingots.newItemStack(info, 9), Blocks.newItemStack(info, 1))
  }

}
