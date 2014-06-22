package geek.lawsof.physics.lib.objects.block.meta

import net.minecraft.item.{ItemStack, ItemBlock}
import cpw.mods.fml.common.registry.GameRegistry

/**
 * Created by anshuman on 22-06-2014.
 */
class ItemBlockBase(var metaBlock: MetaBlockBase, var intName: String) extends ItemBlock(metaBlock) {
  setHasSubtypes(true)

  override def getMetadata(par1: Int): Int = par1

  override def getUnlocalizedName(itemStack: ItemStack): String = metaBlock.getInternalName(itemStack)

  def registerBlock() = GameRegistry.registerBlock(metaBlock, this.getClass, intName)
}
