package geek.lawsof.physics.lib.block.gui.container

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container

/**
 * Created by anshuman on 28-05-2014.
 */
class ContainerBase extends Container{
  override def canInteractWith(p : EntityPlayer): Boolean = true
}
