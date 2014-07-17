package geek.lawsof.physics.lib.item

import java.util

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.item.traits._
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{EnumRarity, Item, ItemStack}
import net.minecraft.util.IIcon
import net.minecraft.world.World

import scala.collection.mutable

/**
 * Created by anshuman on 26-05-2014.
 */
class ItemBase(ctab: CreativeTabs = CTabs.mainTab, stackSize: Int = 64) extends Item {
  setCreativeTab(ctab)
  setMaxStackSize(stackSize)
  setMaxDamage(0)

  var metaCount = 0
  val items = mutable.HashMap.empty[Int, ItemDescriptor]

  def registerItem() = GameRegistry.registerItem(this, getInternalName())

  def getInternalName(stack: ItemStack = newItemStack()) = items.get(stack.getItemDamage) match {
    case Some(item) => item.intName
    case None => "error"
  }

  override def getUnlocalizedName(stack: ItemStack): String = "item." + getInternalName(stack)

  override def getSubItems(item: Item, ctab: CreativeTabs, list: util.List[_]): Unit = items.foreach(o => list.asInstanceOf[util.List[ItemStack]].add(newItemStack(dmg = o._1)))

  def newItemStack(size: Int = 1, dmg: Int = 0) = new ItemStack(this, size, dmg)

  def newStack(item: ItemDescriptor, size: Int = 1) = newItemStack(size, getMeta(item))

  def getMeta(item: ItemDescriptor) = items.map(_.swap).get(item).get

  override def registerIcons(reg: IIconRegister): Unit = {
    items.foreach(_._2.registerIcon(reg))
    errorIcon = reg.registerIcon(s"${Reference.MOD_ID}:ErrorItem")
  }

  var errorIcon: IIcon = null

  override def getIconFromDamage(dmg: Int): IIcon = items.get(dmg) match {
    case Some(item) => item.icon
    case None => errorIcon
  }

  override def getRarity(stack: ItemStack): EnumRarity = items.get(stack.getItemDamage) match {
    case Some(item) => item.txtColor.color
    case None => whiteColor().color
  }

  override def addInformation(stack: ItemStack, p_77624_2_ : EntityPlayer, list: util.List[_], p_77624_4_ : Boolean): Unit = items.get(stack.getItemDamage) match {
    case Some(item) => item.tooltipInfo(list)
    case None => list.asInstanceOf[util.List[String]].add("This Item Is Invalid, This Is Probably Due To Some Corruption Or a Recent Update, Throw This Away, Sorry")
  }

  override def hasEffect(stack: ItemStack, pass: Int): Boolean = items.get(stack.getItemDamage) match {
    case Some(item) => item.shiny
    case None => false
  }

  override def doesContainerItemLeaveCraftingGrid(stack: ItemStack): Boolean = items(stack.getItemDamage).containerStack._2

  override def hasContainerItem(stack: ItemStack): Boolean = items(stack.getItemDamage).hasContainer

  override def getContainerItem(stack: ItemStack): ItemStack = items(stack.getItemDamage).containerStack._1

  override def onUpdate(stack: ItemStack, w: World, e: Entity, i: Int, b: Boolean): Unit = items(stack.getItemDamage).tick(stack, w, e, i, b)

  override def onCreated(stack: ItemStack, w: World, p: EntityPlayer): Unit = items(stack.getItemDamage).initNBT(stack, w, p)
}

