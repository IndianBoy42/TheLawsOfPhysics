package geek.lawsof.physics.lib.objects.block.te.traits

import net.minecraft.block.ITileEntityProvider

/**
 * Created by anshuman on 23-06-2014.
 */
trait ITileBlock extends ITileEntityProvider{
  def registerTE
}
