package geek.lawsof.physics.lib.metals

import net.minecraft.block.material.Material
import geek.lawsof.physics.lib.handler.WorldGenerator
import geek.lawsof.physics.init.{ModFluids, CTabs}
import geek.lawsof.physics.lib.fluid.FluidBase
import geek.lawsof.physics.lib.equip.types.{ToolTypeBase, ArmorTypeBase}
import net.minecraft.item.ItemStack
import geek.lawsof.physics.lib.info._
import geek.lawsof.physics.lib.item.{ItemDescriptor, ItemBase}
import geek.lawsof.physics.lib.block.{BlockDescriptor, BlockBase}
import net.minecraftforge.oredict.OreDictionary.registerOre
import geek.lawsof.physics.lib.util.Recipes._
import net.minecraftforge.fluids.FluidStack
import net.minecraft.init.Items
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by anshuman on 26-05-2014.
 */
class MetalItem(prefix: String) extends ItemBase(CTabs.metalsTab) {
  def add(metal: MetalInfo) = this +: new ItemDescriptor(prefix + metal.name)

  def get(metal: MetalInfo) = items.find(_._2.intName == prefix + metal.name).get._2
  def getMeta(metal: MetalInfo) = items.map(_.swap).get(get(metal)).get

  def newMetalStack(metal: MetalInfo, size: Int = 1): ItemStack = newItemStack(size, getMeta(metal))
}
class MetalBlock(prefix: String) extends BlockBase(prefix) {
  def add(metal: MetalInfo) = this +: new BlockDescriptor(prefix + metal.name)

  def get(metal: MetalInfo) = blocks.find(_._2.intName == prefix + metal.name).get._2
  def getMeta(metal: MetalInfo) = blocks.map(_.swap).get(get(metal)).get

  def newMetalStack(metal: MetalInfo, size: Int = 1): ItemStack = newItemStack(size, getMeta(metal))
}

object MetalIngots extends MetalItem("ingot")
object MetalBlocks extends MetalBlock("block")
