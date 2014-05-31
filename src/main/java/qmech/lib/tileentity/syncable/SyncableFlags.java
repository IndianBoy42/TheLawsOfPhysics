package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;
import qmech.lib.util.ByteUtils;

import java.util.HashSet;
import java.util.Set;

public class SyncableFlags extends SyncableObjectBase {

    private final long[] timeLastSet = new long[16];
    private final long[] timeLastUnset = new long[16];
    private short value;
    private short previousValue;

    public SyncableFlags() {
    }

    public void on(Enum<?> slot) {
        this.on(slot.ordinal());
    }

    void on(int slot) {
        this.set(slot, true);
    }

    public void off(Enum<?> slot) {
        this.off(slot.ordinal());
    }

    void off(int slot) {
        this.set(slot, false);
    }

    public void set(Enum<?> slot, boolean bool) {
        this.set(slot.ordinal(), bool);
    }

    void toggle(int slot) {
        this.set(slot, !this.get(slot));
    }

    public void toggle(Enum<?> slot) {
        this.toggle(slot.ordinal());
    }

    public Set<Integer> getActiveSlots() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 16; i++) {
            if (this.get(i)) {
                set.add(i);
            }
        }
        return set;
    }

    void set(int slot, boolean bool) {
        short newVal = ByteUtils.set(this.value, slot, bool);
        if (newVal != this.value) {
            if (bool) {
                this.timeLastSet[slot] = 0;
            } else {
                this.timeLastUnset[slot] = 0;
            }
            this.markDirty();
        }
        this.value = newVal;
    }

    public boolean get(Enum<?> slot) {
        return this.get(slot.ordinal());
    }

    boolean get(int slot) {
        return ByteUtils.get(this.value, slot);
    }

    public boolean hasSlotChanged(Enum<?> slot) {
        return this.hasSlotChanged(slot.ordinal());
    }

    boolean hasSlotChanged(int slot) {
        return ByteUtils.get(this.value, slot) != ByteUtils.get(this.previousValue, slot);
    }

    @Override
    public void markClean() {
        this.previousValue = this.value;
        this.dirty = false;
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readShort();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeShort(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setShort(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getShort(name);
    }
}
