package geek.lawsof.physics.init.content.PoweredFurnace

import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.block.te.nbt.{SyncableProgress, SyncMap}

/**
 * Created by anshuman on 22-07-2014.
 */
class PoweredFurnaceTile extends TileEntityBase{

}

object PoweredFurnaceSyncMap extends SyncMap{
  this += ("progress" -> new SyncableProgress(100))
}