package lawsof.physics.lib.objects.block

import net.minecraft.block.material.Material
import lawsof.physics.lib.objects.block.traits.ICustomRenderedBlock
import lawsof.physics.mod.init.Reference
import net.minecraft.world.{IBlockAccess, World}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.AxisAlignedBB
import net.minecraft.tileentity.TileEntity
import net.minecraft.block.{Block, ITileEntityProvider}

/**
 * Created by anshuman on 14-06-2014.
 */
abstract class TileBlockBase(blockMaterial: Material, intName: String) extends BlockBase(blockMaterial, intName) with ITileEntityProvider{
  override def registerBlock(): Unit = {
    super.registerBlock()
    registerTE()
    registerRenderer()
  }

  def registerTE()

  def registerRenderer() = {}

  def hasCustomRenderer = this.isInstanceOf[ICustomRenderedBlock]

  override def renderAsNormalBlock: Boolean = !this.hasCustomRenderer

  override def isOpaqueCube: Boolean = !this.hasCustomRenderer

  override def getRenderType: Int = if (this.hasCustomRenderer) Reference.RENDER_ID else 0

  def checkTileExists(w: IBlockAccess, x: Int, y: Int, z: Int): Boolean = Coord(x, y, z).tileExistsAt(w)

  def checkTileInstance(te: TileEntity): Boolean = te.isInstanceOf[TileEntityBase]

  def checkTileInstance(w: IBlockAccess, x: Int, y: Int, z: Int): Boolean = checkTileInstance(Coord(x, y, z).getTileAt(w))

  def getTileAs(w: IBlockAccess, x: Int, y: Int, z: Int) = Coord(x, y, z).getTileAtAs[TileEntityBase](w)

  override def onBlockActivated(w: World, x: Int, y: Int, z: Int, p: EntityPlayer, s: Int, px: Float, py: Float, pz: Float): Boolean =
    checkTileExists(w, x, y, z) && checkTileInstance(w, x, y, z) && getTileAs(w, x, y, z).onBlockActivated(p, s, px, py, pz)

  override def onNeighborChange(w: IBlockAccess, x: Int, y: Int, z: Int, tileX: Int, tileY: Int, tileZ: Int): Unit =
    if (checkTileExists(w, x, y, z) && checkTileInstance(w, x, y, z)) getTileAs(w, x, y, z).onNeighbourBlockChanged(tileX,tileY,tileZ)

  override def removedByPlayer(w: World, player: EntityPlayer, x: Int, y: Int, z: Int): Boolean =
    checkTileExists(w, x, y, z) && checkTileInstance(w, x, y, z) && getTileAs(w, x, y, z).onBlockBroken(player)

  override def onBlockEventReceived(w: World, x: Int, y: Int, z: Int, evtID: Int, evtPar: Int): Boolean =
    checkTileExists(w, x, y, z) && checkTileInstance(w, x, y, z) && getTileAs(w, x, y, z).onBlockEventRecieved(evtID, evtPar)
}
