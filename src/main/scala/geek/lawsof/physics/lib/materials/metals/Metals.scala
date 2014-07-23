package geek.lawsof.physics.lib.materials.metals

import geek.lawsof.physics.init.{ModFluids, CTabs}
import geek.lawsof.physics.lib.block.{BlockBase, BlockDescriptor}
import geek.lawsof.physics.lib.fluid.{FluidBlockBase, FluidBase}
import geek.lawsof.physics.lib.item.{ItemBase, ItemDescriptor}
import geek.lawsof.physics.lib.util.handler.WorldGenerator
import geek.lawsof.physics.lib.util.info.FluidInfoModifier
import net.minecraft.block.material.Material
import net.minecraft.item.ItemStack

import scala.collection.mutable

/**
 * Created by anshuman on 26-05-2014.
 */
class MetalItem(prefix: String) extends ItemBase(CTabs.metalsTab) {
  def add(metal: MetalInfo) = this +: new ItemDescriptor(prefix + metal.name)

  def get(metal: MetalInfo) = items.find(_._2.intName == prefix + metal.name).get._2

  def getMeta(metal: MetalInfo) = items.map(_.swap).get(get(metal)).get

  def newMetalStack(metal: MetalInfo, size: Int = 1): ItemStack = newItemStack(size, getMeta(metal))
}

class MetalBlock(prefix: String) extends BlockBase(prefix, ctab = CTabs.metalsTab) {
  def add(metal: MetalInfo) = this +: new MetalBlockDescriptor(prefix, metal)

  class MetalBlockDescriptor(prefix: String, val metal: MetalInfo) extends BlockDescriptor(prefix + metal.name)

  def get(metal: MetalInfo) = blocks.find(_._2.asInstanceOf[MetalBlockDescriptor].metal == metal).get._2

  def getMeta(metal: MetalInfo) = blocks.map(_.swap).get(get(metal)).get

  def newMetalStack(metal: MetalInfo, size: Int = 1): ItemStack = newItemStack(size, getMeta(metal))
}

class MetalFluid(prefix: String, material: Material = Material.lava, fluidInfo: FluidInfoModifier = new FluidInfoModifier()) {
  val fluids = mutable.MutableList.empty[FluidBase]

  def add(info: MetalInfo) = {
    val fluid = new FluidBase(prefix + info.name, material, CTabs.metalsTab, fluidInfo + info.fluidInfo)
    fluids += fluid
    ModFluids.registerFluid(fluid)
  }
}

object MetalIngots extends MetalItem("ingot")

object MetalNuggets extends MetalItem("nugget")

object MetalBlocks extends MetalBlock("block")

object MetalOres extends MetalBlock("ore") {
  override def add(metal: MetalInfo): Unit = {
    super.add(metal)
    WorldGenerator += this -> getMeta(metal) -> metal.oreGenInfo
  }
}

object MoltenMetal extends MetalFluid("molten")

object MetalSlurry extends MetalFluid("slurry", Material.water)