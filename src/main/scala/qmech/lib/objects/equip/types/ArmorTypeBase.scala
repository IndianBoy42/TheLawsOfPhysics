package qmech.lib.objects.equip.types

import net.minecraft.item.ItemStack
import net.minecraftforge.common.util.EnumHelper
import net.minecraft.item.ItemArmor.ArmorMaterial
import qmech.lib.objects.info.ArmorInfo
import qmech.lib.objects.equip.ArmorBase
import qmech.lib.objects.CreativeTabBase

/**
 * Created by anshuman on 28-05-2014.
 */
object ArmorTypeBase {
  val craftingRecipes = Array(
    Array("xxx", "x x"),
    Array("x x", "xxx", "xxx"),
    Array("xxx", "x x", "x x"),
    Array("x x", "x x")
  )
}

class ArmorTypeBase(var armorName: String, var durability: Int, var reductionAmounts: Array[Int], var enchantability: Int, var craftMaterial: ItemStack) {
  armorType = EnumHelper.addArmorMaterial(armorName, durability, reductionAmounts, enchantability)

  def this(name: String, info: ArmorInfo, mat: ItemStack) = this(name, info.durability, info.reductionAmounts, info.enchantability, mat)

  var armorType: ArmorMaterial = ArmorMaterial.IRON

  var armorPieces: List[ArmorBase] = List.empty

  def createArmorSet (ctab: CreativeTabBase) = for (i <- 0 until 4) new ArmorBase(this, i, ctab) +: armorPieces
}
