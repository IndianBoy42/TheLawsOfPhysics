package geek.lawsof.physics.lib.block.nbt

import net.minecraft.nbt.NBTTagCompound

/**
 * Created by anshuman on 28-05-2014.
 */
trait ISyncableObject {
  def writeToNBT(nbt: NBTTagCompound, name: String)

  def readFromNBT(nbt: NBTTagCompound, name: String)

  var dirty = false

  def markDirty() = dirty = true

  def markClean() = dirty = false

  def value()
}
