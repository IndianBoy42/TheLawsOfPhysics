package qmech.lib.tileentity.syncable;

import com.google.common.primitives.SignedBytes;
import net.minecraft.nbt.NBTTagCompound;

public class SyncableByte extends SyncableObjectBase {

    private byte value;

    public SyncableByte(byte value) {
        this.value = value;
    }

    public SyncableByte() {
    }

    public byte getValue() {
        return this.value;
    }

    void setValue(byte newValue) {
        if (newValue != this.value) {
            this.value = newValue;
            this.markDirty();
        }
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readByte();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeByte(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setByte(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getByte(name);
    }

    public void modify(int by) {
        this.setValue(SignedBytes.checkedCast(this.value + by));
    }
}
