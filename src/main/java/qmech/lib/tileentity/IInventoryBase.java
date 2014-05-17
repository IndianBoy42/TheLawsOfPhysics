package qmech.lib.tileentity;

import net.minecraft.inventory.IInventory;
import org.apache.commons.lang3.tuple.Pair;
import qmech.lib.tileentity.syncable.SyncableInventory;

/**
 * Created by anshuman on 17-05-2014.
 */
public interface IInventoryBase extends IInventory {

    public SyncableInventory inventory();

    public Pair<Integer, Integer> getSlotPos(int Slot);

}
