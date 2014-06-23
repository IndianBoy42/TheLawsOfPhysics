package geek.lawsof.physics.lib.block

import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.world.{IBlockAccess, World}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.{IIcon, AxisAlignedBB, MathHelper}
import geek.lawsof.physics.init.ModConfigs
import geek.lawsof.physics.lib.info.BlockInfo
import net.minecraft.tileentity.TileEntity
import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.Reference
import net.minecraft.client.renderer.texture.IIconRegister
import java.util
import java.util.Random
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import cpw.mods.fml.client.registry.ClientRegistry
import geek.lawsof.physics.lib.util.Coord
import net.minecraft.entity.player.EntityPlayer
import geek.lawsof.physics.lib.block.traits.ICustomRenderedBlock
import geek.lawsof.physics.lib.CreativeTabBase

/**
 * Created by anshuman on 26-05-2014.
 */
class BlockBase(blockMaterial: Material, val intName: String) extends Block(blockMaterial) {
  this.setInternalName(intName)

  def this(intName: String, blockMat: Material, ctab: CreativeTabs, hardness: Float, blastResistance: Float, toolType: String, toolLevel: Int) {
    this(blockMat, intName)
    setCreativeTabs(ctab)
    setStrength(hardness, blastResistance).setHarvestLevel(toolType, toolLevel)
    registerBlock()
  }

  def this(intName: String, blockMat: Material, ctab: CreativeTabBase, info: BlockInfo) {
    this(blockMat, intName)
    setCreativeTabs(ctab)
    setStrength(info.hardness, info.blastResistance).setHarvestLevel(info.toolType, info.toolLevel)
    registerBlock()
  }

  def setStrength(hardness: Float, blastResistance: Float): BlockBase = {
    this.setHardness(hardness)
    this.setResistance(blastResistance)
    this
  }

  def setCreativeTabs(creativeTab: CreativeTabs): BlockBase = {
    this.setCreativeTab(creativeTab)
    this
  }

  def setInternalName(name: String): BlockBase = {
    this.setBlockName(name)
    this
  }

  def registerBlock() {
    GameRegistry.registerBlock(this, this.getUnlocalizedName.substring(5))
    registerTE()
    registerRenderer()
  }

  override def setHarvestLevel(toolType: String, toolLevel: Int) {
    super.setHarvestLevel(toolType, toolLevel)
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, player: EntityLivingBase, stack: ItemStack) {
    val dir: Int = MathHelper.floor_double(((player.rotationYaw * 4F) / 360F).asInstanceOf[Double] + 0.5D) & 3
    world.setBlockMetadataWithNotify(x, y, z, dir, 0)
  }

  def newItemStack(size: Int = 1) = new ItemStack(this, size)

  override def quantityDropped(rand : Random): Int = 1

  override def quantityDroppedWithBonus(fortune : Int, rand : Random): Int = quantityDropped(rand)

  override def getItemDropped(meta : Int, rand : Random, fortune : Int): Item = Item.getItemFromBlock(this)

  override def damageDropped(meta : Int): Int = 0

  override def registerBlockIcons(reg : IIconRegister): Unit = this.blockIcon = reg.registerIcon(Reference.MOD_ID + ":" + intName)

  override def getIcon(side : Int, meta : Int): IIcon = this.blockIcon

  def registerTE(te: Class[_ <: TileEntityBase]) = GameRegistry.registerTileEntity(te, te.newInstance().name)

  def registerRenderer(tileEntityClass: Class[_ <: TileEntity], specialRenderer: TileEntitySpecialRenderer) =
    ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer)

  def registerTE() = {}

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
