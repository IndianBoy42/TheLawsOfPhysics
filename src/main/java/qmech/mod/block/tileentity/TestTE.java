package qmech.mod.block.tileentity;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.nbt.NBTTagCompound;
import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.gui.IHasGUI;
import qmech.lib.tileentity.render.CustomRendererBase;
import qmech.lib.tileentity.render.IHasCustomRenderer;
import qmech.lib.tileentity.render.ModelRendererBase;
import qmech.lib.tileentity.render.model.BlockModelBase;
import qmech.lib.tileentity.syncable.SyncableInt;
import qmech.lib.util.LoggingHelper;

/**
 * Created by anshuman on 16-05-2014.
 */
public class TestTE extends TileEntityBase implements IHasCustomRenderer, IHasGUI {
    private SyncableInt integer;

    public TestTE() {
        super();
    }

    @Override
    public String intName() {
        return "TestTE";
    }

    @Override
    public void update() {
        this.integer.modify(1);
        if (this.integer.getValue() >= 100) {
            this.integer.setValue(0);
            LoggingHelper.getInstance().info("Tick Tock");
        }
    }

    @Override
    public void registerFields() {
        this.integer = new SyncableInt(0);

        this.registerField(this.integer, "number1");
    }

    @Override
    public CustomRendererBase customRenderer() {
        return new ModelRendererBase(new BlockModelBase("testMachine"));
    }

    @Override
    public void registerRenderer() {
        ClientRegistry.bindTileEntitySpecialRenderer(TestTE.class, this.customRenderer());
    }

    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        LoggingHelper.getInstance().info(this.integer.getValue());
    }

    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        LoggingHelper.getInstance().info(this.integer.getValue());
    }

    @Override
    public void openGUI() {

    }

    @Override
    public void registerGUI() {

    }

    @Override
    public void updateGUI() {

    }
}
