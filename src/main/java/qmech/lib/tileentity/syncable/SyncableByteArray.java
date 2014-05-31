package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableByteArray extends SyncableObjectBase {

    private byte[] value = new byte[0];

    public SyncableByteArray() {
    }

    public SyncableByteArray(byte[] val) {
        this.value = val;
    }

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(byte[] newValue) {
        if (newValue != this.value) {
            this.value = newValue;
            this.markDirty();
        }
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		int length = stream.readInt();
		value = new byte[length];
		for (int i = 0; i < length; i++) {
			value[i] = stream.readByte();
		}
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData)
			throws IOException {
		if (value == null) {
			stream.writeInt(0);
		} else {
			stream.writeInt(value.length);
			for (byte element : value) {
				stream.writeByte(element);
			}
		}
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound nbt, String name) {
        nbt.setByteArray(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt, String name) {
        nbt.getByteArray(name);
    }

}
