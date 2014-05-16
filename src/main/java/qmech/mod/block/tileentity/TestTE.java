package qmech.mod.block.tileentity;

import qmech.helper.LoggingHelper;
import qmech.helper.tileentity.TileEntityBase;
import qmech.helper.tileentity.syncable.SyncableInt;

/**
 * Created by anshuman on 16-05-2014.
 */
public class TestTE extends TileEntityBase {

    SyncableInt integer;

    @Override
    public String intName() {
        return "TestTE";
    }

    @Override
    public void update() {

    }

    @Override
    public void registerFields() {
        integer = new SyncableInt(0);

        registerField(integer, "number1");
    }

}
