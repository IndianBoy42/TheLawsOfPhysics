package geek.lawsof.physics.lib.metals

import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.block.{BlockBase, BlockDescriptor}
import geek.lawsof.physics.lib.item.{ItemBase, ItemDescriptor}
import geek.lawsof.physics.lib.util.handler.WorldGenerator
import net.minecraft.item.ItemStack

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

object MetalOres extends MetalBlock("ore") {
  override def add(metal: MetalInfo): Unit = {
    super.add(metal)
    WorldGenerator += this -> getMeta(metal) -> metal.getOreGenInfo
  }
}