package geek.lawsof.physics.lib.block.te.traits

import net.minecraft.block.Block
import net.minecraft.world.{IBlockAccess, World}

/**
 * Created by anshuman on 17-07-2014.
 */
trait INeighbourAwareTile {

  def neighbourBlockChange(w: World, x: Int, y: Int, z: Int, b: Block)

  def neighbourTileChange(world: IBlockAccess, x: Int, y: Int, z: Int, tileX: Int, tileY: Int, tileZ: Int)

}
