package qmech.mod.block.te;

import qmech.helper.LoggingHelper;
import qmech.helper.tileentity.render.model.BlockModelBase;
import qmech.helper.tileentity.render.BlockRendererBase;
import qmech.helper.tileentity.TileEntityBase;
import qmech.helper.tileentity.syncable.SyncableInt;
import qmech.mod.ModBase;
import qmech.mod.network.ClientProxy;

/**
 * Created by anshuman on 14-05-2014.
 */
public class TileEntityTest extends TileEntityBase {
    LoggingHelper logger = LoggingHelper.getInstance();

    SyncableInt integer = new SyncableInt(1);

    BlockRendererBase renderer;

    @Override
    public String intName() {
        return "testTE";
    }

    public TileEntityTest() {
        super();
        registerRenderer();
    }

    public void registerRenderer() {
        if (ModBase.proxy instanceof ClientProxy) {
            renderer = new BlockRendererBase(new BlockModelBase(), this.intName());
            ModBase.proxy.registerRenderer(this.getClass(), renderer);
        }
    }

    @Override
    public void registerFields() {
        syncableObjects.put("intVal", integer);
    }

    public void update() {
        integer.modify(1);
        if (integer.getValue() > 100) {
            integer.setValue(0);
            logger.info("goes the clock");
        }
    }

    @Override
    public boolean customRendered() {
        return true;
    }
}
