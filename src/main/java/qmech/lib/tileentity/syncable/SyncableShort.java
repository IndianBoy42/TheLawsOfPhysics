package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableShort extends SyncableObjectBase {

    private short value = 0;

    public SyncableShort(short value) {
        this.value = value;
    }

    public SyncableShort() {
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readShort();
	}
	*/

    public void modify(short by) {
        this.setValue((short) (this.value + by));
    }

    public short getValue() {
        return this.value;
    }

    void setValue(short val) {
        if (val != this.value) {
            this.value = val;
            this.markDirty();
        }
    }

	/*
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
