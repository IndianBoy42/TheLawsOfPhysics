package geek.lawsof.physics.lib.block

import java.util

import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.item.ItemDescriptor
import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.world.{IBlockAccess, World}
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.{IIcon, MathHelper}
import geek.lawsof.physics.lib.info.BlockInfo
import net.minecraft.tileentity.TileEntity
import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.Reference
import net.minecraft.client.renderer.texture.IIconRegister
import java.util.Random
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import cpw.mods.fml.client.registry.ClientRegistry
import geek.lawsof.physics.lib.util.Coord
import net.minecraft.entity.player.EntityPlayer
import geek.lawsof.physics.lib.block.traits.{singleSided, IconArray}
import geek.lawsof.physics.lib.CreativeTabBase

import scala.collection.mutable.MutableList
import scala.collection.mutable

/**
 * Created by anshuman on 26-05-2014.
 */
class BlockBase(intName: String, blockMaterial: Material = Material.iron, ctab: CreativeTabBase = CTabs.mainTab, hardness: Float = 1.0F, blastResistance: Float = 1.0F, toolType: String = "pickaxe", toolLevel: Int = 1) extends Block(blockMaterial) {
  setBlockName(intName)
  setCreativeTab(ctab)
  setStrength(hardness, blastResistance)
  setHarvestLevel(toolType, toolLevel)

  var metaCount = 0
  val blocks = mutable.HashMap.empty[Int, BlockDescriptor]

  def setStrength(hardness: Float, blastResistance: Float) = this.setHardness(hardness).setResistance(blastResistance)

  def newItemStack(size: Int = 1, meta: Int = 0) = new ItemStack(this, size, meta)

  override def registerBlockIcons(reg: IIconRegister): Unit = {
    for (block <- blocks) block._2.registerIcons(reg)
    errorIcon = reg.registerIcon("error")
  }

  override def getSubBlocks(item : Item, ctab : CreativeTabs, list : util.List[_]): Unit = for (i <- 1 to blocks.size) blocks.get(i) match {
    case Some(block) => list.asInstanceOf[util.List[ItemStack]].add(newItemStack(meta = i))
    case None => {}
  }

  var errorIcon: IIcon = null

  override def getIcon(side: Int, meta: Int): IIcon = blocks.get(meta) match {
    case Some(block) => block.icons(side)
    case None => errorIcon
  }

  def getInternalName(stack: ItemStack) = blocks.get(stack.getItemDamage) match {
    case Some(block) => block.intName
    case None => "error"
  }
}

