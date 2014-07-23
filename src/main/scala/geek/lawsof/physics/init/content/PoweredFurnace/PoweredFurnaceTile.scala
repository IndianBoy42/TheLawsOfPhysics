package geek.lawsof.physics.init.content.PoweredFurnace

import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.block.te.nbt.{SyncableProgress, SyncMap}
import geek.lawsof.physics.lib.machine.metallic.IMetallicMachine

/**
 * Created by anshuman on 22-07-2014.
 */
class PoweredFurnaceTile extends TileEntityBase with IMetallicMachine{
  //ISyncTile
  override def syncMap: SyncMap = new PoweredFurnaceSyncMap
}

class PoweredFurnaceSyncMap extends SyncMap{
  this += ("progress" -> new SyncableProgress(100))
}