package geek.lawsof.physics.lib.util

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

/**
 * Created by anshuman on 17-07-2014.
 */
object NBTHelper {
  /**
   * Initializes the NBT Tag Compound for the given ItemStack if it is null
   *
   * @param itemStack
     * The ItemStack for which its NBT Tag Compound is being checked for initialization
   */
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
}
