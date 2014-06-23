package geek.lawsof.physics.lib.block.meta

import geek.lawsof.physics.lib.block.BlockBase
import net.minecraft.util.IIcon
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.creativetab.CreativeTabs
import java.util
import net.minecraft.block.material.Material

/**
 * Created by anshuman on 22-06-2014.
 */
abstract class MetaBlockBase(blockMaterial: Material, intName: String) extends BlockBase(blockMaterial, intName) {
  def subBlocks: List[IMetaSubBlock]

  override def registerBlockIcons(reg: IIconRegister): Unit = for (subBlock <- subBlocks) subBlock.registerBlockIcons(reg)

  override def getIcon(side: Int, meta: Int): IIcon = subBlocks(meta % subBlocks.length).getIcon(side)

  override def getSubBlocks(item: Item, ctab: CreativeTabs, list: util.List[_]): Unit = {
    for (i <- 0 until subBlocks.length) {
      list.asInstanceOf[util.List[ItemStack]].add(new ItemStack(item, 1, i))
    }
  }

  override def damageDropped(meta: Int): Int = meta

  override def registerBlock(): Unit = {}

  def getInternalName(itemStack: ItemStack) = subBlocks(itemStack.getItemDamage).internalName
}
