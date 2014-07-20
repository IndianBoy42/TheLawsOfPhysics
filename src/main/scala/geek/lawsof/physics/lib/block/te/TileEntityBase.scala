package geek.lawsof.physics.lib.block.te

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.lib.block.nbt.SyncMap
import geek.lawsof.physics.lib.block.te.traits.{ICustomRenderedTile, IGuiTile, ITickingTile}
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
    this.ifInstanceOf[ICustomRenderedTile](_.registerRenderer())
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
    this readFromNBT pkt.func_148857_g()
    syncMap.markAllClean()
    updateGui()
  }

  override def readFromNBT(nbt: NBTTagCompound): Unit = if (syncMap != null) syncMap.readAllNBT(nbt)

  override def writeToNBT(nbt: NBTTagCompound): Unit = if (syncMap != null) syncMap.writeAllNBT(nbt)

  def ifInstanceOf[T](f: T => Unit) = this match {
    case t: T => f(t)
    case _ =>
  }

  override def updateEntity(): Unit = ifInstanceOf[ITickingTile](_.tick())

  def updateGui() = ifInstanceOf[IGuiTile](_.updateGUI())

  def hasRenderer = isInstanceOf[ICustomRenderedTile]

  def thisClass = this.getClass
}