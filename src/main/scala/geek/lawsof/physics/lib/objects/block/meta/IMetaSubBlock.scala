package geek.lawsof.physics.lib.objects.block.meta

import net.minecraft.client.renderer.texture.IIconRegister

/**
 * Created by anshuman on 22-06-2014.
 */
trait IMetaSubBlock {
  def getIcon(side: Int)
  def registerBlockIcons(reg: IIconRegister)
  def internalName: String
}
