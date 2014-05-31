package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableFloat extends SyncableObjectBase {

    private static final float EPSILON = 0.0001f;
    private float value;

    public SyncableFloat(float value) {
        this.value = value;
    }

    public SyncableFloat() {
    }

    public float getValue() {
        return this.value;
    }

    void setValue(float newValue) {
        if (!this.equals(newValue)) {
            this.value = newValue;
            this.markDirty();
        }
    }

    boolean equals(float otherValue) {
        return Math.abs(otherValue - this.value) < EPSILON;
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readFloat();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeFloat(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setFloat(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getFloat(name);
    }

    public void modify(float by) {
        this.setValue(this.value + by);
    }
}
