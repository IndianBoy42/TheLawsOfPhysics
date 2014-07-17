package geek.lawsof.physics.lib.block

import java.util

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.item.ItemDescriptor
import geek.lawsof.physics.lib.item.traits.whiteColor
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{EnumRarity, ItemStack, ItemBlock}
import net.minecraft.util.IIcon
import net.minecraft.world.World

/**
 * Created by anshuman on 15-07-2014.
 */
class ItemBlockBase(val block: BlockBase, stackSize:Int = 64) extends ItemBlock(block){
  def items = block.blocks.map(o => (o._1, o._2.item))

  override def getMetadata(dmg : Int): Int = dmg

  def getInternalName(dmg: Int = 0) = block.getInternalName(newItemStack(dmg = dmg))
  override def getUnlocalizedName(stack : ItemStack): String = getInternalName(stack.getItemDamage)

  def registerItem = {
    GameRegistry.registerItem(this, getInternalName())
  }

  def newItemStack(size: Int = 1, dmg: Int = 0) = new ItemStack(this, size, dmg)

  def newStack(item: ItemDescriptor, size: Int = 1) = newItemStack(size, getMeta(item))

  def getMeta(item: ItemDescriptor) = items.map(_.swap).get(item).get

  override def onCreated(p_77622_1_ : ItemStack, p_77622_2_ : World, p_77622_3_ : EntityPlayer): Unit = super.onCreated(p_77622_1_, p_77622_2_, p_77622_3_)

  override def registerIcons(reg: IIconRegister): Unit = {
    items.foreach(_._2.registerIcon(reg))
    errorIcon = reg.registerIcon(s"${Reference.MOD_ID}:ErrorItem")
  }

  var errorIcon: IIcon = null

  override def getIconFromDamage(dmg: Int): IIcon = items.get(dmg) match {
    case Some(item) => item.icon
    case None => errorIcon
  }

  override def getRarity(stack : ItemStack): EnumRarity = items.get(stack.getItemDamage) match {
    case Some(item) => item.txtColor.color
    case None => whiteColor().color
  }

  override def addInformation(stack : ItemStack, p_77624_2_ : EntityPlayer, list : util.List[_], p_77624_4_ : Boolean): Unit = items.get(stack.getItemDamage) match {
    case Some(item) => item.tooltipInfo(list)
    case None => list.asInstanceOf[util.List[String]].add("This Item Is Invalid, This Is Probably Due To Some Corruption Or a Recent Update, Throw This Away, Sorry")
  }

  override def hasEffect(stack: ItemStack, pass: Int): Boolean = items.get(stack.getItemDamage) match {
    case Some(item) => item.shiny
    case None => false
  }

  override def doesContainerItemLeaveCraftingGrid(stack : ItemStack): Boolean = items(stack.getItemDamage).containerStack._2

  override def hasContainerItem(stack: ItemStack): Boolean = items(stack.getItemDamage).hasContainer

  override def getContainerItem(stack: ItemStack): ItemStack = items(stack.getItemDamage).containerStack._1
}
