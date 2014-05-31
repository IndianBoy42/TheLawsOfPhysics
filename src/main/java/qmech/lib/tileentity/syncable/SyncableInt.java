package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableInt extends SyncableObjectBase {

    int value = 0;

    public SyncableInt(int value) {
        this.value = value;
    }

    SyncableInt() {
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readInt();
	}
	*/

    public void modify(int by) {
        this.setValue(this.value + by);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int val) {
        if (val != this.value) {
            this.value = val;
            this.markDirty();
        }
    }

	/*
	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeInt(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setInteger(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        if (tag.hasKey(name)) {
            this.value = tag.getInteger(name);
        }
    }

}
