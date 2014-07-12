package geek.lawsof.physics.lib.item

import java.util

import com.sun.javaws.exceptions.InvalidArgumentException
import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.item.traits._
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{EnumRarity, Item, ItemStack}
import net.minecraft.util.IIcon
import net.minecraftforge.oredict.OreDictionary
import org.lwjgl.input.Keyboard

import scala.collection.mutable

/**
 * Created by anshuman on 26-05-2014.
 */
class ItemBase(item: ItemDescriptor, ctab: CreativeTabs = CTabs.mainTab, stackSize: Int = 64) extends Item {
  setCreativeTab(ctab)
  setMaxStackSize(64)

  this +: item

  val items = mutable.MutableList.empty[ItemDescriptor]

  def registerItem() {
    GameRegistry.registerItem(this, getInternalName())
  }

  def getInternalName(stack: ItemStack = newItemStack()) = items.get(stack.getItemDamage) match {
    case Some(item) => item.intName
    case None => "error"
  }

  override def getUnlocalizedName(stack : ItemStack): String = "item." + getInternalName(stack)

  override def getHasSubtypes: Boolean = items.length > 1

  override def getSubItems(item : Item, ctab : CreativeTabs, list : util.List[_]): Unit = for(i <- 0 until items.length) items.get(i) match {
    case Some(item) => list.asInstanceOf[util.List[ItemStack]].add(newItemStack(dmg = i))
    case None => {}
  }

  def newItemStack(size: Int = 1, dmg: Int = 0) = new ItemStack(this, size, dmg)

  override def registerIcons(reg: IIconRegister): Unit = {
    items.foreach(_.registerIcon(reg))
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
}

class ItemDescriptor(val intName: String, val shiny: Boolean = false, val txtColor: TextColor = whiteColor(), val tooltip: CustomTooltip = new CustomTooltip()) {

  def registered = master != null
  var master: ItemBase = null

  def +: (item: ItemBase)= {
    master = item
    item.items += this
  }

  var icon: IIcon = null

  def registerIcon(reg: IIconRegister) = icon = reg.registerIcon(s"${Reference.MOD_ID}:${intName}")

  def tooltipInfo (info: util.List[_]) = {
    for (str <- tooltip.mainTooltip) info.asInstanceOf[util.List[String]].add(str)
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
      for (str <- tooltip.shiftTooltip) info.asInstanceOf[util.List[String]].add(str)
    else info.asInstanceOf[util.List[String]].add("Hold Shift For More Information")
    if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
      for (str <- tooltip.ctrlToolTip) info.asInstanceOf[util.List[String]].add(str)
    }
    else info.asInstanceOf[util.List[String]].add("Hold For Detailed Description")
  }

}