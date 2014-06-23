package geek.lawsof.physics.lib.block.meta

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon

/**
 * Created by anshuman on 22-06-2014.
 */
trait IMetaSubBlock {
  def getIcon(side: Int): IIcon
  def registerBlockIcons(reg: IIconRegister)
  def internalName: String
}
