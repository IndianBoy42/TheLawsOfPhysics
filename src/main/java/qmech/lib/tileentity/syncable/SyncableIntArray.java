package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Arrays;

public class SyncableIntArray extends SyncableObjectBase {

    private int[] value;

    private SyncableIntArray(int[] value) {
        this.value = value;
    }

    public SyncableIntArray() {
        this(new int[0]);
    }

    public void setValue(int offset, int newValue) {
        if (this.value[offset] != newValue) {
            this.value[offset] = newValue;
            this.markDirty();
        }
    }

    public int getValue(int offset) {
        return this.value[offset];
    }

    public int[] getValue() {
        return this.value;
    }

    public void setValue(int[] newValue) {
        if (!Arrays.equals(this.value, newValue)) {
            this.value = newValue;
            this.markDirty();
        }
    }

    int size() {
        if (this.value == null) {
            return 0;
        }
        return this.value.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		int length = stream.readInt();
		value = new int[length];
		for (int i = 0; i < length; i++) {
			value[i] = stream.readInt();
		}
	}
	
	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeInt(size());
		for (int i = 0; i < size(); i++) {
			stream.writeInt(value[i]);
		}
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setIntArray(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getIntArray(name);
    }

    public void clear() {
        this.value = new int[0];
        this.markDirty();
    }
}
