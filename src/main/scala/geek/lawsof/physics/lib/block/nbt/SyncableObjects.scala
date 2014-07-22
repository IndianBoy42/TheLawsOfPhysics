package geek.lawsof.physics.lib.block.nbt

import geek.lawsof.physics.lib.util.helpers.NBTHelper
import NBTHelper._

class SyncableInt(value: Int) extends SyncableObjectImpl(value, getIntInCompound, setIntegerInCompound)
class SyncableString(value: String) extends SyncableObjectImpl(value, getStringInCompound, setStringInCompound)
class SyncableDouble(value: Double) extends SyncableObjectImpl(value, getDoubleInCompound, setDoubleInCompound)
class SyncableShort(value: Short) extends SyncableObjectImpl(value, getShortInCompound, setShortInCompound)
class SyncableFloat(value: Float) extends SyncableObjectImpl(value, getFloatInCompound, setFloatInCompound)
class SyncableLong(value: Long) extends SyncableObjectImpl(value, getLongInCompound, setLongInCompound)
class SyncableBoolean(value: Boolean) extends SyncableObjectImpl(value, getBooleanInCompound, setBooleanInCompound)
class SyncableByte(value: Byte) extends SyncableObjectImpl(value, getByteInCompound, setByteInCompound)
class SyncableByteArray(value: Array[Byte]) extends SyncableObjectImpl(value, getByteArrayInCompound, setByteArrayInCompound)
class SyncableIntArray(value: Array[Int]) extends SyncableObjectImpl(value, getIntArrayInCompound, setIntArrayInCompound)
class SyncableProgress(ticks: Int) extends SyncableInt(0) {
  def add(multiplier: Double = 1.0) = value += (1000 * multiplier).toInt
  def completed() = value < ticks * 1000
}