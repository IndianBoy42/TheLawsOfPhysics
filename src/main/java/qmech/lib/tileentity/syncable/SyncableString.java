package qmech.lib.tileentity.syncable;

import net.minecraft.nbt.NBTTagCompound;

public class SyncableString extends SyncableObjectBase {

    private String value;

    public SyncableString() {
        this("");
    }

    private SyncableString(String val) {
        this.value = val;
    }

    public String getValue() {
        return this.value;
    }

    void setValue(String val) {
        if (!val.equals(this.value)) {
            this.value = val;
            this.markDirty();
        }
    }

	/*
    @Override
	public void readFromStream(DataInput stream) throws IOException {
		value = stream.readUTF();
	}

	@Override
	public void writeToStream(DataOutput stream, boolean fullData)
			throws IOException {
		stream.writeUTF(value);
	}
	*/

    @Override
    public void writeToNBT(NBTTagCompound nbt, String name) {
        nbt.setString(name, this.value);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt, String name) {
        this.value = nbt.getString(name);
    }

    public void clear() {
        this.setValue("");
    }

}
