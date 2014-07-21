package geek.lawsof.physics.lib.block.nbt

import net.minecraft.nbt.NBTTagCompound

import scala.collection.mutable

/**
 * Created by anshuman on 18-06-2014.
 */
trait SyncMap {
  val fields = mutable.HashMap.empty[String, ISyncableObject]

  def readAllNBT(nbt: NBTTagCompound) = fields.foreach(s => s._2.readFromNBT(nbt, s._1))

  def writeAllNBT(nbt: NBTTagCompound) = fields.foreach(s => s._2.writeToNBT(nbt, s._1))

  def markAllClean() = fields.foreach(_._2.markClean())
}
