package geek.lawsof.physics.lib.item

import net.minecraft.item.{EnumAction, EnumRarity, ItemStack, Item}
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference
import net.minecraft.util.IIcon
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.client.renderer.texture.IIconRegister
import java.util
import org.lwjgl.input.Keyboard
import geek.lawsof.physics.lib.item.traits.{TextColor, IHasContainerItem, IShinyItem}
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.block.Block
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by anshuman on 26-05-2014.
 */
class ItemBase(intName: String) extends Item {
  this.setInternalName(intName)

  def this(intName: String, ctab: CreativeTabs, stackSize: Int) = {
    this(intName)
    setCreativeTabs(ctab)
    setStackSize(stackSize)
    registerItem()
  }

  def setCreativeTabs(ctab: CreativeTabs): ItemBase = {
    this.setCreativeTab(ctab)
    this
  }

  def setStackSize(size: Int): ItemBase = {
    this.setMaxStackSize(size).asInstanceOf[ItemBase]
  }

  def setInternalName(name: String): ItemBase = {
    this.setUnlocalizedName(name)
    this
  }

  def registerItem() {
    GameRegistry.registerItem(this, this.getUnlocalizedName.substring(5))
  }

  def newItemStack(size: Int = 1) = new ItemStack(this, size)

  override def registerIcons(reg: IIconRegister): Unit = this.itemIcon = reg.registerIcon(s"${Reference.MOD_ID}:$intName")

  override def getIconFromDamage(dmg: Int): IIcon = itemIcon

  override def hasEffect(itemStack: ItemStack, pass: Int): Boolean = this.isInstanceOf[IShinyItem]

  def tooltipInfo = List[String](this.intName)

  def tooltipShiftInfo = List[String]("This Item Has No Extra Information")

  def tooltipCtrlInfo = List[String](s"This Is An Item Called $intName")

  override def addInformation(itemStack: ItemStack, player: EntityPlayer, info: util.List[_], flag: Boolean): Unit = {
    for (str <- tooltipInfo) info.asInstanceOf[util.List[String]].add(str)
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) for (str <- tooltipShiftInfo) info.asInstanceOf[util.List[String]].add(str) else info.asInstanceOf[util.List[String]].add("Hold Shift For More Information")
    if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) for (str <- tooltipCtrlInfo) info.asInstanceOf[util.List[String]].add(str) else info.asInstanceOf[util.List[String]].add("Hold For Detailed Description")
  }

  override def onItemUse(itemStack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, f1: Float, f2: Float, f3: Float): Boolean = false

  override def onPlayerStoppedUsing(itemStack: ItemStack, world: World, player: EntityPlayer, count: Int): Unit = {}

  override def getMaxItemUseDuration(itemStack: ItemStack): Int = 0

  override def getItemUseAction(itemStack: ItemStack): EnumAction = EnumAction.none

  override def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack = itemStack

  override def hitEntity(itemStack: ItemStack, entityHit: EntityLivingBase, entityHitting: EntityLivingBase): Boolean = false

  override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean = false

  override def onUsingTick(itemStack: ItemStack, player: EntityPlayer, count: Int): Unit = {}

  override def doesContainerItemLeaveCraftingGrid(par1ItemStack: ItemStack): Boolean = false

  override def hasContainerItem(stack: ItemStack): Boolean = this.isInstanceOf[IHasContainerItem] && this.getContainerItem(stack) != null

  override def getContainerItem(itemStack: ItemStack): ItemStack = null

  override def getShareTag: Boolean = true

  override def onCreated(itemStack: ItemStack, world: World, player: EntityPlayer): Unit = {}

  override def onUpdate(itemStack: ItemStack, world: World, entity: Entity, int: Int, flag: Boolean): Unit = {}

  override def getRarity(stack: ItemStack): EnumRarity = TextColor.colorWhite
}
