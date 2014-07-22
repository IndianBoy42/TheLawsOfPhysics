package geek.lawsof.physics.lib.block

import java.util
import java.util.Random

import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.CreativeTabBase
import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.block.te.traits.{IActivateAwareTile, INeighbourAwareTile}
import geek.lawsof.physics.lib.util.info.Coord
import net.minecraft.block.Block
import net.minecraft.block.Block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IIcon
import net.minecraft.world.{IBlockAccess, World}

import scala.collection.mutable
import scala.reflect.runtime.universe

/**
 * Created by anshuman on 26-05-2014.
 */
class BlockBase(intName: String, blockMaterial: Material = Material.iron, ctab: CreativeTabBase = CTabs.mainTab, hardness: Float = 1.0F, blastResistance: Float = 1.0F, toolType: String = "pickaxe", toolLevel: Int = 1, sound: SoundType = Block.soundTypeMetal) extends Block(blockMaterial) {
  setBlockName(intName)
  setCreativeTab(ctab)
  setStrength(hardness, blastResistance)
  setHarvestLevel(toolType, toolLevel)
  setStepSound(sound)

  var metaCount = 0
  val blocks = mutable.HashMap.empty[Int, BlockDescriptor]

  override def hasTileEntity(metadata: Int): Boolean = blocks(metadata).hasTE

  def registerTiles() = blocks.foreach(_._2.registerTE())

  override def createTileEntity(world: World, metadata: Int): TileEntity = blocks(metadata).createTE(world)

  def setStrength(hardness: Float, blastResistance: Float) = this.setHardness(hardness).setResistance(blastResistance)

  def newItemStack(size: Int = 1, meta: Int = 0) = new ItemStack(this, size, meta)

  override def registerBlockIcons(reg: IIconRegister): Unit = {
    for (block <- blocks) block._2.registerIcons(reg)
    errorIcon = reg.registerIcon("error")
  }

  override def getSubBlocks(item: Item, ctab: CreativeTabs, list: util.List[_]): Unit = blocks.foreach(b => list.asInstanceOf[util.List[ItemStack]].add(newItemStack(meta = b._1)))

  var errorIcon: IIcon = null

  override def getIcon(side: Int, meta: Int): IIcon = blocks.get(meta) match {
    case Some(block) => block.icons(side)
    case None => errorIcon
  }

  def getInternalName(stack: ItemStack) = blocks.get(stack.getItemDamage) match {
    case Some(block) => block.intName
    case None => "error"
  }

  override def onNeighborBlockChange(w: World, x: Int, y: Int, z: Int, b: Block): Unit =
    Coord(x, y, z).getTileAtAs[TileEntityBase](w).ifInstanceOf[INeighbourAwareTile](_.neighbourBlockChange(w, x, y, z, b))

  override def onNeighborChange(w: IBlockAccess, x: Int, y: Int, z: Int, tileX: Int, tileY: Int, tileZ: Int): Unit =
    Coord(x, y, z).getTileAtAs[TileEntityBase](w).ifInstanceOf[INeighbourAwareTile](_.neighbourTileChange(w, x, y, z, tileX, tileY, tileZ))

  override def onBlockActivated(w: World, x: Int, y: Int, z: Int, p: EntityPlayer, pi: Int, px: Float, py: Float, pz: Float): Boolean = {
    if (!p.isSneaking) {
      Coord(x, y, z).getTileAtAs[TileEntityBase](w).ifInstanceOf[IActivateAwareTile](_.blockActivated(w, x, y, z, p, pi, px, py, pz))
      true
    }
    else false
  }
}

