package geek.lawsof.physics.lib.item.traits

import net.minecraft.item.{EnumAction, ItemStack}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.entity.EntityLivingBase

/**
 * Created by anshuman on 23-06-2014.
 */
trait IUsableItem {
   def onItemUse(itemStack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, f1: Float, f2: Float, f3: Float): Boolean

   def onPlayerStoppedUsing(itemStack: ItemStack, world: World, player: EntityPlayer, count: Int): Unit

   def getMaxItemUseDuration(itemStack: ItemStack): Int

   def getItemUseAction(itemStack: ItemStack): EnumAction

   def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack

   def hitEntity(itemStack: ItemStack, entityHit: EntityLivingBase, entityHitting: EntityLivingBase): Boolean

   def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean

   def onUsingTick(itemStack: ItemStack, player: EntityPlayer, count: Int): Unit
}
