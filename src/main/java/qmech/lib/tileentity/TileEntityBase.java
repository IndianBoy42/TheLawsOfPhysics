package qmech.lib.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.lib.multiblock.CoordTriplet;
import qmech.lib.tileentity.gui.IHasGUI;
import qmech.lib.tileentity.render.IHasCustomRenderer;
import qmech.lib.tileentity.syncable.ISyncableObject;
import qmech.mod.ModBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public abstract class TileEntityBase extends TileEntity {

    private static boolean registered = false;

    private final Map<String, ISyncableObject> syncableObjects = new HashMap<String, ISyncableObject>();

    public TileEntityBase() {
        this.registerFields();
        if (!registered) {
            this.registerTE(this.intName());
            registered = true;
        }
    }

    protected void registerField(ISyncableObject obj, String name) {
        this.syncableObjects.put(name, obj);
    }

    protected abstract String intName();

    void registerTE(String teName) {
        GameRegistry.registerTileEntity(this.getClass(), teName);
        if (this instanceof IHasCustomRenderer) {
            ((IHasCustomRenderer) this).registerRenderer();
        }
        if (this instanceof IHasGUI) {
            ((IHasGUI) this).registerGUI();
        }
    }

    public void updateEntity() {
        this.update();

        for (ISyncableObject obj : this.syncableObjects.values()) {
            if (obj != null && obj.isDirty()) {
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                break;
            }
        }
    }

    @SideOnly(Side.SERVER)
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbt);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        this.readFromNBT(packet.func_148857_g());

        for (ISyncableObject obj : this.syncableObjects.values()) {
            if (obj.isDirty()) {
                obj.markClean();
            }
        }

        if (this instanceof IHasGUI) {
            ((IHasGUI) this).updateGUI();
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        for (Entry<String, ISyncableObject> obj : this.syncableObjects.entrySet()) {
            if (obj != null) {
                obj.getValue().writeToNBT(nbt, obj.getKey());
            }
        }
        super.writeToNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        for (Entry<String, ISyncableObject> obj : this.syncableObjects.entrySet()) {
            if (obj != null) {
                obj.getValue().readFromNBT(nbt, obj.getKey());
            }
        }
        super.readFromNBT(nbt);
    }

    public CoordTriplet getCoords() {
        return new CoordTriplet(this.xCoord, this.yCoord, this.zCoord);
    }

    protected abstract void update();

    protected abstract void registerFields();

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public abstract void onNeighborChange(int tX, int tY, int tZ);

    public void getDrops() {
        IInventory inventory;
        Random rand = new Random();

        if (this instanceof IInventory) {
            inventory = (IInventory) this;
        } else {
            return;
        }

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(this.getWorldObj(),
                        this.xCoord + rx, this.yCoord + ry, this.zCoord + rz,
                        item);

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                this.getWorldObj().spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }

    public boolean onActivation(World w, int x, int y, int z, EntityPlayer p, int meta, float par7, float par8, float par9) {
        if (this instanceof IHasGUI) {
            if (!p.isSneaking()) {
                ((IHasGUI) this).openGUI();
                return true;
            }
        }
        return false;
    }

    public void openGUIPlayer(World w, EntityPlayer p, int x, int y, int z, int GuiID) {
        p.openGui(ModBase.getInstance(), GuiID, w, x, y, z);
    }

}
