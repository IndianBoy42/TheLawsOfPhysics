package geek.lawsof.physics.lib.block.te

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.lib.block.te.nbt.SyncMap
import geek.lawsof.physics.lib.block.te.traits.{ICustomRenderedTile, IGuiTile, ITickingTile}
import geek.lawsof.physics.lib.util.info.Coord
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.play.server.S35PacketUpdateTileEntity
import net.minecraft.network.{NetworkManager, Packet}
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * Created by anshuman on 28-05-2014.
 */
class TileEntityBase extends TileEntity {
  def registerTE(intName: String) = {
    GameRegistry.registerTileEntity(this.getClass, intName)
    if (this.isInstanceOf[ICustomRenderedTile]) this.asInstanceOf[ICustomRenderedTile].registerRenderer()
  }

  override def canUpdate: Boolean = this.isInstanceOf[ITickingTile]

  //ISyncTile
  def syncMap: SyncMap = null

  override def getDescriptionPacket: Packet = {
    var nbt = new NBTTagCompound()
    this writeToNBT nbt
    new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt)
  }

  override def onDataPacket(net: NetworkManager, pkt: S35PacketUpdateTileEntity): Unit = {
    if (syncMap != null) {
      this readFromNBT pkt.func_148857_g()
      syncMap.markAllClean()
    }
    updateGui()
  }

  def coord = Coord(xCoord, yCoord, zCoord)

  override def readFromNBT(nbt: NBTTagCompound): Unit = if (syncMap != null) syncMap.readAllNBT(nbt)

  override def writeToNBT(nbt: NBTTagCompound): Unit = if (syncMap != null) syncMap.writeAllNBT(nbt)

  override def updateEntity(): Unit = if (this.isInstanceOf[ITickingTile]) this.asInstanceOf[ITickingTile].tick()

  def updateGui() = if (this.isInstanceOf[IGuiTile]) this.asInstanceOf[IGuiTile].updateGUI()

  def hasRenderer = isInstanceOf[ICustomRenderedTile]

  def thisClass = this.getClass
}