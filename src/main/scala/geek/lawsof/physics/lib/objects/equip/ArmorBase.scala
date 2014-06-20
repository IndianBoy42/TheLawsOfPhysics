package geek.lawsof.physics.lib.objects.equip

import net.minecraft.item.{ItemStack, ItemArmor}
import net.minecraft.entity.player.EntityPlayer
import java.util
import net.minecraft.entity.Entity
import geek.lawsof.physics.lib.objects.equip.types.ArmorTypeBase
import geek.lawsof.physics.lib.objects.CreativeTabBase
import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.Reference

/**
 * Created by anshuman on 28-05-2014.
 */
object ArmorBase {
  val suffixes = Array("helmet", "chestplate", "leggings", "boots")
}

class ArmorBase(val armorMaterial: ArmorTypeBase, val armorPart: Int, ctab: CreativeTabBase) extends ItemArmor(armorMaterial.armorType, 0, armorPart) {
  val intName = s"${armorMaterial.armorName}_${ArmorBase.suffixes(armorPart)}"
  setTextureName(s"${Reference.MOD_ID}:$intName")
  setUnlocalizedName(intName)
  setCreativeTab(ctab)

  //  Recipes.shapedRecipe(new ItemStack(this), ArmorTypeBase.craftingRecipes(armorPart), 'x', armorMaterial.craftMaterial)

  GameRegistry.registerItem(this, intName)

  override def addInformation(stack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean) = {
    var list = par3List.asInstanceOf[util.List[String]]
    list.add(s"HP : ${stack.getMaxDamage - stack.getItemDamage}/${stack.getMaxDamage}")
    list.add(s"Protection : ${armorMaterial.reductionAmounts(armorPart)}")
  }

  override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String = {
    val layer = slot match {
      case 2 => "_2"
      case _ => "_1"
    }
    val armorName = stack.getItem.asInstanceOf[ArmorBase].getArmorMaterial.name()
    //    val armorName = this.getArmorMaterial.name()
    s"${Reference.MOD_ID}:/textures/models/armor/$armorName$layer.png"
  }

  def newItemStack (amt: Int = 1) = new ItemStack(this, amt)
}
