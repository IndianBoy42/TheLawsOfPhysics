package geek.lawsof.physics.lib.util

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

/**
 * Created by anshuman on 17-07-2014.
 */
object NBTHelper {
  def initNBTTagCompound(itemStack: ItemStack) {
    if (itemStack.stackTagCompound == null) {
      itemStack.setTagCompound(new NBTTagCompound)
    }
  }

  def hasTag(itemStack: ItemStack, keyName: String): Boolean = itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName)

  def removeTag(itemStack: ItemStack, keyName: String) {
    if (itemStack.stackTagCompound != null) {
      itemStack.stackTagCompound.removeTag(keyName)
    }
  }

  def getString(itemStack: ItemStack, keyName: String, default: String = ""): String = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setString(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getString(keyName)
  }

  def setString(itemStack: ItemStack, keyName: String, keyValue: String) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setString(keyName, keyValue)
  }

  def getBoolean(itemStack: ItemStack, keyName: String, default: Boolean = false): Boolean = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setBoolean(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getBoolean(keyName)
  }

  def setBoolean(itemStack: ItemStack, keyName: String, keyValue: Boolean) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setBoolean(keyName, keyValue)
  }

  def getByte(itemStack: ItemStack, keyName: String, default: Byte = 0): Byte = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setByte(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getByte(keyName)
  }

  def setByte(itemStack: ItemStack, keyName: String, keyValue: Byte) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setByte(keyName, keyValue)
  }

  def getShort(itemStack: ItemStack, keyName: String, default: Short = 0): Short = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setShort(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getShort(keyName)
  }

  def setShort(itemStack: ItemStack, keyName: String, keyValue: Short) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setShort(keyName, keyValue)
  }

  def getInt(itemStack: ItemStack, keyName: String, default: Int = 0): Int = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setInteger(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getInteger(keyName)
  }

  def setInteger(itemStack: ItemStack, keyName: String, keyValue: Int) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setInteger(keyName, keyValue)
  }

  def getLong(itemStack: ItemStack, keyName: String, default: Long = 0): Long = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setLong(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getLong(keyName)
  }

  def setLong(itemStack: ItemStack, keyName: String, keyValue: Long) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setLong(keyName, keyValue)
  }

  def getFloat(itemStack: ItemStack, keyName: String, default: Float = 0): Float = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setFloat(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getFloat(keyName)
  }

  def setFloat(itemStack: ItemStack, keyName: String, keyValue: Float) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setFloat(keyName, keyValue)
  }

  def getDouble(itemStack: ItemStack, keyName: String, default: Double = 0): Double = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setDouble(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getDouble(keyName)
  }

  def setDouble(itemStack: ItemStack, keyName: String, keyValue: Double) {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setDouble(keyName, keyValue)
  }

  def getByteArray(itemStack: ItemStack, keyName: String, default: Array[Byte] = Array.empty[Byte]) = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setByteArray(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getByteArray(keyName)
  }

  def setByteArray(itemStack: ItemStack, keyName: String, keyValue: Array[Byte]) = {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setByteArray(keyName, keyValue)
  }

  def getIntArray(itemStack: ItemStack, keyName: String, default: Array[Int] = Array.empty[Int]) = {
    initNBTTagCompound(itemStack)
    if (!itemStack.stackTagCompound.hasKey(keyName)) {
      setIntArray(itemStack, keyName, default)
    }
    itemStack.stackTagCompound.getIntArray(keyName)
  }

  def setIntArray(itemStack: ItemStack, keyName: String, keyValue: Array[Int]) = {
    initNBTTagCompound(itemStack)
    itemStack.stackTagCompound.setIntArray(keyName, keyValue)
  }

  def getStringInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: String = ""): String = {
    if (!stackTagCompound.hasKey(keyName)) {
      setStringInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getString(keyName)
  }

  def setStringInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: String) {
    stackTagCompound.setString(keyName, keyValue)
  }

  def getBooleanInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Boolean = false): Boolean = {
    if (!stackTagCompound.hasKey(keyName)) {
      setBooleanInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getBoolean(keyName)
  }

  def setBooleanInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Boolean) {
    stackTagCompound.setBoolean(keyName, keyValue)
  }

  def getByteInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Byte = 0): Byte = {
    if (!stackTagCompound.hasKey(keyName)) {
      setByteInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getByte(keyName)
  }

  def setByteInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Byte) {
    stackTagCompound.setByte(keyName, keyValue)
  }

  def getShortInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Short = 0): Short = {
    if (!stackTagCompound.hasKey(keyName)) {
      setShortInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getShort(keyName)
  }

  def setShortInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Short) {
    stackTagCompound.setShort(keyName, keyValue)
  }

  def getIntInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Int = 0): Int = {
    if (!stackTagCompound.hasKey(keyName)) {
      setIntegerInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getInteger(keyName)
  }

  def setIntegerInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Int) {
    stackTagCompound.setInteger(keyName, keyValue)
  }

  def getLongInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Long = 0): Long = {
    if (!stackTagCompound.hasKey(keyName)) {
      setLongInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getLong(keyName)
  }

  def setLongInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Long) {
    stackTagCompound.setLong(keyName, keyValue)
  }

  def getFloatInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Float = 0): Float = {
    if (!stackTagCompound.hasKey(keyName)) {
      setFloatInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getFloat(keyName)
  }

  def setFloatInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Float) {
    stackTagCompound.setFloat(keyName, keyValue)
  }

  def getDoubleInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Double = 0): Double = {
    if (!stackTagCompound.hasKey(keyName)) {
      setDoubleInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getDouble(keyName)
  }

  def setDoubleInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Double) {
    stackTagCompound.setDouble(keyName, keyValue)
  }

  def getByteArrayInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Array[Byte] = Array.empty[Byte]) = {
    if (!stackTagCompound.hasKey(keyName)) {
      setByteArrayInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getByteArray(keyName)
  }

  def setByteArrayInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Array[Byte]) = {
    stackTagCompound.setByteArray(keyName, keyValue)
  }
  
  def getIntArrayInCompound(stackTagCompound: NBTTagCompound, keyName: String, default: Array[Int] = Array.empty[Int]) = {
    if (!stackTagCompound.hasKey(keyName)) {
      setIntArrayInCompound(stackTagCompound, keyName, default)
    }
    stackTagCompound.getIntArray(keyName)
  }

  def setIntArrayInCompound(stackTagCompound: NBTTagCompound, keyName: String, keyValue: Array[Int]) = {
    stackTagCompound.setIntArray(keyName, keyValue)
  }
}
