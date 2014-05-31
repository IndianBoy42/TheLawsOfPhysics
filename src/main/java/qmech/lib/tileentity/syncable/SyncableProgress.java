package qmech.lib.tileentity.syncable;

class SyncableProgress extends SyncableInt {

    private final int max;

    public SyncableProgress(int max) {
        this.max = max;
    }

    public double getPercent() {
        return (double) this.value / (double) this.max;
    }

    public boolean isComplete() {
        return this.value >= this.max;
    }

    public void reset() {
        this.setValue(0);
    }

    public void increase() {
        this.modify(1);
    }

}
