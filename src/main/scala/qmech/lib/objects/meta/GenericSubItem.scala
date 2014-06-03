package qmech.lib.objects.meta

import net.minecraft.util.IIcon
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.EntityLivingBase
import qmech.mod.init.Reference

/**
 * Created by anshuman on 26-05-2014.
 */
class GenericSubItem(val name: String) extends IMetaSubItem {

  def hideFromCreative: GenericSubItem = {
    visibleInCreative = false
    this
  }

  def getIcon: IIcon = {
    icon
  }

  def getUnlocalizedName(stack: ItemStack): String = {
    name
  }

  def hitEntity(itemStack: ItemStack, target: EntityLivingBase, player: EntityLivingBase): Boolean = {
    false
  }

  def onItemUse(itemStack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, par8: Float, par9: Float, par10: Float): Boolean = {
    false
  }

  def onItemRightClick(itemStack: ItemStack, player: EntityPlayer, world: World): ItemStack = {
    itemStack
  }

  def registerIcons(register: IIconRegister, prefix: String) {
    registerIcon(register, s"${prefix}_$name")
  }

  protected def registerIcon(register: IIconRegister, name: String) {
    icon = register.registerIcon(s"${Reference.MOD_ID}:$name")
  }

  def addToCreativeList(item: Item, meta: Int, result: java.util.List[ItemStack]) {
    if (visibleInCreative) result.add(new ItemStack(item, 1, meta))
  }

  def hasEffect(renderPass: Int): Boolean = {
    false
  }

  private var icon: IIcon = null
  private var recipes: Array[AnyRef] = null
  private var visibleInCreative: Boolean = true
}
