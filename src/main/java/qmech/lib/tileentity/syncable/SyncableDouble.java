package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableDouble extends SyncableObjectBase {

    private double value;

    public SyncableDouble(double value) {
        this.value = value;
    }

    public SyncableDouble() {
    }

    public double getValue() {
        return this.value;
    }

    void setValue(double newValue) {
        if (newValue != this.value) {
            this.value = newValue;
            this.markDirty();
        }
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readDouble();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeDouble(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setDouble(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getDouble(name);
    }

    public void modify(float by) {
        this.setValue(this.value + by);
    }
}
