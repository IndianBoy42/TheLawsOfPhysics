package geek.lawsof.physics.lib.block

import geek.lawsof.physics.lib.block.traits.{IconArray, singleSided}
import geek.lawsof.physics.lib.item.ItemDescriptor
import net.minecraft.client.renderer.texture.IIconRegister

/**
 * Created by anshuman on 15-07-2014.
 */
class BlockDescriptor (val intName: String, val icons: IconArray, val item: ItemDescriptor) {
  def this(intName: String) = this(intName, IconArray(intName, singleSided()), new ItemDescriptor(intName))

  var block: BlockBase = null

  def +: (reg: BlockBase)= {
    block = reg
    block.blocks += this
  }

  def register (reg: BlockBase)= reg +: this

  def registerIcons(reg: IIconRegister) = icons.register(reg)
}
