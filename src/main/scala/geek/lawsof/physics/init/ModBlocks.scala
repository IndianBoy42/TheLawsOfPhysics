package geek.lawsof.physics.init

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.util.Log

/**
 * Created by anshuman on 26-05-2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
object ModBlocks {
  def preInit() = {
    Log.info("Creating Blocks")

    Log.info("Creating Machines")

  }

  def init() = {
    Log.info("Registering TileEntities")
  }
}
