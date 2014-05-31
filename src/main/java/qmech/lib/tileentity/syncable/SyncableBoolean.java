package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableBoolean extends SyncableObjectBase {

    private boolean value;

    public SyncableBoolean(boolean value) {
        this.value = value;
    }

    public SyncableBoolean() {
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean newValue) {
        if (newValue != this.value) {
            this.value = newValue;
            this.markDirty();
        }
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readBoolean();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData) throws IOException {
		stream.writeBoolean(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound tag, String name) {
        tag.setBoolean(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag, String name) {
        this.value = tag.getBoolean(name);
    }

    public void toggle() {
        this.value = !this.value;
        this.markDirty();
    }
}
