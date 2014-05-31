package qmech.lib.tileentity.syncable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Created by anshuman on 17-05-2014.
 */
public class SyncableInventory implements ISyncableObject {

    private ItemStack[] inventory;
    private final String name;

    private final int stackLimit = 64;
    private boolean dirty = false;

    public SyncableInventory(int length, String name) {
        this.inventory = new ItemStack[length];
        this.name = name;
    }

    public int getSizeInventory() {
        return this.inventory.length;
    }

    ItemStack getStackInSlot(int slotIndex) {
        return this.inventory[slotIndex];
    }

    public ItemStack decrStackSize(int slotIndex, int decrementAmount) {
        ItemStack itemStack = this.getStackInSlot(slotIndex);
        if (itemStack != null) {
            if (itemStack.stackSize <= decrementAmount) {
                this.setInventorySlotContents(slotIndex, null);
            } else {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0) {
                    this.setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        if (this.inventory[slotIndex] != null) {
            ItemStack itemStack = this.inventory[slotIndex];
            this.inventory[slotIndex] = null;
            return itemStack;
        } else {
            return null;
        }
    }

    void setInventorySlotContents(int slotIndex, ItemStack itemStack) {
        this.inventory[slotIndex] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }


        this.markDirty();
    }

    int getInventoryStackLimit() {
        return this.stackLimit;
    }

    @Override
    public void markDirty() {
        this.dirty = true;
    }

    @Override
    public boolean isDirty() {
        return this.dirty;
    }

    @Override
    public void markClean() {
        this.dirty = false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound, String key) {
        NBTTagList tagList = nbtTagCompound.getTagList(key, 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < this.inventory.length) {
                this.inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound, String key) {
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < this.inventory.length; ++currentIndex) {
            if (this.inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                this.inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag(key, tagList);
    }
}
