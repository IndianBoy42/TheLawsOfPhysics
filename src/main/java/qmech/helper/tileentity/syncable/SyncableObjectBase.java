package qmech.helper.tileentity.syncable;

import net.minecraft.world.World;

public abstract class SyncableObjectBase implements ISyncableObject {

	protected long lastChangeTime = 0;
	protected boolean dirty = false;

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public void markClean() {
		dirty = false;
	}

	@Override
	public void markDirty() {
		dirty = true;
	}
}
