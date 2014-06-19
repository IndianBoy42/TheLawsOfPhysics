package lawsof.physics.lib.objects.item

import net.minecraft.util.IIcon
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.client.renderer.texture.IIconRegister

/**
 * Created by anshuman on 26-05-2014.
 */
trait IMetaSubItem {
  def getIcon: IIcon

  def getUnlocalizedName(stack: ItemStack): String

  def hitEntity(itemStack: ItemStack, target: EntityLivingBase, player: EntityLivingBase): Boolean

  def onItemUse(itemStack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, par8: Float, par9: Float, par10: Float): Boolean

  def onItemRightClick(itemStack: ItemStack, player: EntityPlayer, world: World): ItemStack

  def registerIcons(register: IIconRegister, prefix: String)

  def addToCreativeList(item: Item, meta: Int, result: java.util.List[ItemStack])

  def hasEffect(renderPass: Int): Boolean
}
