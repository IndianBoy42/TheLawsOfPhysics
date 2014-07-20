package geek.lawsof.physics.lib.equip.types

import geek.lawsof.physics.lib.CreativeTabBase
import geek.lawsof.physics.lib.equip._
import geek.lawsof.physics.lib.util.info.ToolInfo
import net.minecraft.item.Item.ToolMaterial
import net.minecraft.item.ItemStack
import net.minecraftforge.common.util.EnumHelper

/**
 * Created by anshuman on 28-05-2014.
 */
object ToolTypeBase {
  var shovelCraftingShape = Array("x", "s", "s")
  var pickaxeCraftingShape = Array("xxx", " s ", " s ")
  var axeCraftingShape = Array("xx", "xs", " s")
  var hoeCraftingShape = Array("xx", " s", " s")
  var swordCraftingShape = Array("x", "x", "s")
}

class ToolTypeBase(var toolName: String, var harvestLevel: Int, var durability: Int, var efficiency: Float, var damage: Int, var enchantability: Int, var craftMaterial: ItemStack) {
  toolType = EnumHelper.addToolMaterial(toolName, harvestLevel, durability, efficiency, damage, enchantability)

  def this(name: String, info: ToolInfo, mat: ItemStack) = this(name, info.harvestLevel, info.durability, info.efficiency, info.damage, info.enchantability, mat)

  var toolType = ToolMaterial.IRON

  val levels = Array("Stone", "Iron", "Diamond", "Obsidian")

  def toolLevel = if (harvestLevel < 4) levels(harvestLevel) else harvestLevel.toString

  var pickaxe: ToolPickaxe = null
  var shovel: ToolShovel = null
  var axe: ToolAxe = null
  var sword: ToolSword = null
  var hoe: ToolHoe = null

  def createToolSet(ctab: CreativeTabBase) = {
    pickaxe = new ToolPickaxe(this, ctab)
    shovel = new ToolShovel(this, ctab)
    axe = new ToolAxe(this, ctab)
    sword = new ToolSword(this, ctab)
    hoe = new ToolHoe(this, ctab)
  }
}
