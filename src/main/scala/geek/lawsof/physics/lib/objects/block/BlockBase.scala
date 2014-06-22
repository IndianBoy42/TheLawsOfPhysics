package geek.lawsof.physics.lib.objects.block

import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.world.World
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.{IIcon, AxisAlignedBB, MathHelper}
import geek.lawsof.physics.init.ModConfigs
import geek.lawsof.physics.lib.objects.info.BlockInfo
import geek.lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.tileentity.TileEntity
import geek.lawsof.physics.lib.objects.block.te.ICustomRenderedBlock
import geek.lawsof.physics.Reference
import net.minecraft.client.renderer.texture.IIconRegister

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
  }

  override def setHarvestLevel(toolType: String, toolLevel: Int) {
    super.setHarvestLevel(toolType, toolLevel)
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, player: EntityLivingBase, stack: ItemStack) {
    val dir: Int = MathHelper.floor_double(((player.rotationYaw * 4F) / 360F).asInstanceOf[Double] + 0.5D) & 3
    world.setBlockMetadataWithNotify(x, y, z, dir, 0)
  }

  def newItemStack(size: Int = 1) = new ItemStack(this, size)

  override def registerBlockIcons(reg : IIconRegister): Unit = this.blockIcon = reg.registerIcon(Reference.MOD_ID + ":" + intName)

  override def getIcon(side : Int, meta : Int): IIcon = this.blockIcon
}
