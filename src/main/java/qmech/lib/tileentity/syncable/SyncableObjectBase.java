package qmech.lib.tileentity.syncable;

public abstract class SyncableObjectBase implements ISyncableObject {

    protected long lastChangeTime = 0;
    boolean dirty = false;

    @Override
    public boolean isDirty() {
        return this.dirty;
    }

    @Override
    public void markClean() {
        this.dirty = false;
    }

    @Override
    public void markDirty() {
        this.dirty = true;
    }
}
