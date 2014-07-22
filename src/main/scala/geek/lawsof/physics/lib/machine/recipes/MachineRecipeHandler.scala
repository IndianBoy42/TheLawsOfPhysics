package geek.lawsof.physics.lib.machine.recipes

import net.minecraft.item.crafting.IRecipe

import scala.collection.mutable.MutableList

/**
 * Created by anshuman on 22-07-2014.
 */
trait MachineRecipeHandler[R <: MachineRecipe[I, O], I <: MachineRecipeInput, O <: MachineRecipeOutput] {
  val recipes = MutableList.empty[R]

  def matches(input: I) = recipes.filter(_.matches(input)).get(0) match {
    case Some(r) => true
    case None => false
  }

  def result(input: I) = recipes.filter(_.matches(input)).get(0) match {
    case Some(r) => r.result(input)
    case None => null
  }
}
