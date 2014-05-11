package qmech.helper.tileentity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import qmech.helper.tileentity.syncable.ISyncableObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import qmech.mod.Reference;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityBase extends TileEntity {
	
	Map<String, ISyncableObject> syncableObjects = new HashMap<String, ISyncableObject>();

	public TileEntityBase() {
		GameRegistry.registerTileEntity(TileEntityBase.class, Reference.MOD_ID + ":TileEntityBase");
	}
	
	public void updateEntity () {
		tick();
		
		for (ISyncableObject obj : syncableObjects.values()) {
			if (obj.isDirty()) {
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
	}
	
	public void tick () {
		
	}
	
	/*
	public static Set<EntityPlayer> getPlayersWatchingChunk(WorldServer world, int chunkX, int chunkZ) {
		PlayerManager manager = world.getPlayerManager();

		Set<EntityPlayer> playerList = Sets.newHashSet();
		for (Object o : world.playerEntities) {
			EntityPlayerMP player = (EntityPlayerMP)o;
			if (manager.isPlayerWatchingChunk(player, chunkX, chunkZ)) playerList.add(player);
		}
		return playerList;
	}

	public static Set<EntityPlayer> getPlayersWatchingBlock(WorldServer world, int blockX, int blockZ) {
		return getPlayersWatchingChunk(world, blockX >> 4, blockZ >> 4);
	}
	public void sync () {
		Map<String, ISyncableObject> toSync = new HashMap<String, ISyncableObject>();
		for (Entry<String, ISyncableObject> obj : syncableObjects.entrySet()) {
			ISyncableObject syncObj = obj.getValue();
			String name = obj.getKey();
			if (syncObj.isDirty()) {
				toSync.put(name, syncObj);
			}
		}
		
		SyncPacketBase syncPkt;
		
		if (!this.worldObj.isRemote) {
			Set<EntityPlayer> players = getPlayersWatchingBlock((WorldServer) this.worldObj, this.xCoord, this.zCoord);
			for (EntityPlayer player : players) {
				ModBase.packetHandler.sendTo(message, player);
			}
		}
		
		for (ISyncableObject syncd : toSync.values()) {
			syncd.markClean();
		}
		
	}
	*/
	
	public Packet getDescriptionPacket () {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		Packet pkt = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
		for (ISyncableObject obj : syncableObjects.values()) {
			if (obj.isDirty()) {
				obj.markClean();
			}
		}
		return pkt;
	}
	
	public void writeToNBT (NBTTagCompound nbt) {
		for (Entry<String, ISyncableObject> obj : syncableObjects.entrySet()) {
			obj.getValue().writeToNBT(nbt, obj.getKey());
		}
		super.writeToNBT(nbt);
	}
	
	public void readFromNBT (NBTTagCompound nbt) {
		for (Entry<String, ISyncableObject> obj : syncableObjects.entrySet()) {
			obj.getValue().writeToNBT(nbt, obj.getKey());
		}
		super.readFromNBT(nbt);
	}

}
