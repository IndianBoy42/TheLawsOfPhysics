package geek.lawsof.physics.lib.block.te.nbt

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
}

class SyncableObjectImpl[T](var value: T, val get: (NBTTagCompound, String, T) => T, val set: (NBTTagCompound, String, T) => Unit) extends ISyncableObject{
  override def writeToNBT(nbt: NBTTagCompound, name: String): Unit = set(nbt, name, value)
  override def readFromNBT(nbt: NBTTagCompound, name: String): Unit = get(nbt, name, value)
}