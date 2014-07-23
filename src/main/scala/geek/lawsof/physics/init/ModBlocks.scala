package geek.lawsof.physics.init

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.init.content.PoweredFurnace.PoweredFurnaceBlock
import geek.lawsof.physics.lib.util.helpers.Log

/**
 * Created by anshuman on 26-05-2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
object ModBlocks {

  def preInit() = {
    Log.info("Creating Blocks")

    Log.info("Creating Machines")

    PoweredFurnaceBlock.registerBlock()
  }

  def init() = {
    Log.info("Registering TileEntities")
  }
}
