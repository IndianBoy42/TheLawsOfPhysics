package geek.lawsof.physics.lib.objects.block.nbt

import net.minecraft.nbt.NBTTagCompound

/**
 * Created by anshuman on 18-06-2014.
 */
trait ISyncMap {

  def readAllNBT (nbt: NBTTagCompound)

  def writeAllNBT (nbt: NBTTagCompound)

  def markAllClean

}
