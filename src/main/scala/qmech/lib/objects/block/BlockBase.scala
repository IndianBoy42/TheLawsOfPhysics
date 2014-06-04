package qmech.lib.objects.block

import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.world.World
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.MathHelper
import qmech.mod.init.{Reference, ModConfigs}
import qmech.lib.objects.info.BlockInfo
import qmech.lib.objects.CreativeTabBase

/**
 * Created by anshuman on 26-05-2014.
 */
class BlockBase(blockMaterial: Material, val intName: String) extends Block(blockMaterial) {
  this.setBlockTextureName(Reference.MOD_ID + ":" + intName)
  this.setInternalName(intName)

  def this(intName: String, blockMat: Material, ctab: CreativeTabs, hardness: Float, blastResistance: Float, toolType: String, toolLevel: Int) {
    this(blockMat, intName)
    val info: BlockInfo = ModConfigs.getBlockInfo(this, hardness, blastResistance, toolType, toolLevel)
    setCreativeTabs(ctab)
    setStrength(info.hardness, info.blastResistance).setHarvestLevel(info.toolType, info.toolLevel)
    registerBlock()
  }

  def this(intName: String, blockMat: Material, ctab: CreativeTabBase, nfo: BlockInfo) {
    this(blockMat, intName)
    val info: BlockInfo = ModConfigs.getBlockInfo(this, nfo.hardness, nfo.blastResistance, nfo.toolType, nfo.toolLevel)
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
}
