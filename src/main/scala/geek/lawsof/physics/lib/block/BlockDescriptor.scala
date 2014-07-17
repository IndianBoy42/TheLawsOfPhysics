package geek.lawsof.physics.lib.block

import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.block.traits.{IconArray, singleSided}
import geek.lawsof.physics.lib.item.ItemDescriptor
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.world.World

/**
 * Created by anshuman on 15-07-2014.
 */
class BlockDescriptor(val intName: String, val icons: IconArray, val item: ItemDescriptor) {
  def this(intName: String) = this(intName, IconArray(intName, singleSided()), new ItemDescriptor(intName))

  var block: BlockBase = null

  def +:(reg: BlockBase) = {
    if (reg.metaCount == 15) {
      block = reg
      block.blocks += block.metaCount -> this
      block.metaCount += 1
    }
  }

  def register(reg: BlockBase) = reg +: this

  def registerIcons(reg: IIconRegister) = icons.register(reg)

  def hasTE = teClass != null

  def teClass: Class[_ <: TileEntityBase] = null

  def registerTE() = teClass.newInstance().registerTE(intName)

  def createTE(w: World): TileEntityBase = if (hasTE) teClass.newInstance() else null

}
