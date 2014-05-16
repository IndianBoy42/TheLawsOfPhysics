package qmech.helper.tileentity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.network.NetworkManager;
import net.minecraft.world.IBlockAccess;
import org.apache.commons.lang3.Validate;
import qmech.helper.LoggingHelper;
import qmech.helper.tileentity.syncable.ISyncableObject;
import qmech.helper.CoordTriplet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import qmech.mod.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class TileEntityBase extends TileEntity {
	
	protected Map<String, ISyncableObject> syncableObjects = new HashMap<String, ISyncableObject>();

    public void registerField (ISyncableObject obj, String name) {
        syncableObjects.put(name, obj);
    }

    public abstract String intName();

	public TileEntityBase() {
        registerFields();
	}
	
	public void updateEntity () {
		update();
		
		for (ISyncableObject obj : syncableObjects.values()) {
			if (obj != null && obj.isDirty()) {
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                break;
			}
		}
	}

    @SideOnly(Side.SERVER)
	public Packet getDescriptionPacket () {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		Packet pkt = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
		return pkt;
	}

    public void onDataPacket (NetworkManager net, S35PacketUpdateTileEntity packet) {
        this.readFromNBT(packet.func_148857_g());
        for (ISyncableObject obj : syncableObjects.values()) {
            if (obj.isDirty()) {
                obj.markClean();
            }
        }
    }
	
	public void writeToNBT (NBTTagCompound nbt) {
		for (Entry<String, ISyncableObject> obj : syncableObjects.entrySet()) {
            if (obj != null) {
                obj.getValue().writeToNBT(nbt, obj.getKey());
            }
		}
		super.writeToNBT(nbt);
	}
	
	public void readFromNBT (NBTTagCompound nbt) {
		for (Entry<String, ISyncableObject> obj : syncableObjects.entrySet()) {
            if (obj != null) {
                obj.getValue().readFromNBT(nbt, obj.getKey());
            }
		}
		super.readFromNBT(nbt);
	}
	
	public CoordTriplet getCoords() {
		return new CoordTriplet(xCoord, yCoord, zCoord);
	}

    public abstract void update();

    public abstract void registerFields();

}
