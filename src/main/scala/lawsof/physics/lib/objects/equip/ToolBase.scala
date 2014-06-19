package lawsof.physics.lib.objects.equip

import net.minecraft.item._
import net.minecraft.init.Items
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.entity.player.EntityPlayer
import java.util
import lawsof.physics.lib.objects.CreativeTabBase
import lawsof.physics.lib.objects.equip.types.ToolTypeBase
import lawsof.physics.lib.helper.Recipes
import lawsof.physics.mod.init.Reference

/**
 * Created by anshuman on 28-05-2014.
 */
trait ToolBase {
  def toolType: ToolTypeBase

  def prefix: String

  //override def suffix: String = this.getClass.getSimpleName.substring(4)
  def craftingShape: Array[String]

  def info(stack: ItemStack, list: java.util.List[String]) = {
    list.add(s"HP : ${stack.getMaxDamage - stack.getItemDamage}/${stack.getMaxDamage}")
    list.add(s"Efficiency : ${toolType.efficiency}")
    list.add(s"Harvest Level : ${toolType.toolLevel}")
  }

  def register[toolClass <: Item](tool: toolClass, toolType: ToolTypeBase, ctab: CreativeTabBase) = {
    tool.setTextureName(s"${Reference.MOD_ID}:${toolType.toolName}_$prefix")
    tool.setUnlocalizedName(s"${toolType.toolName}_$prefix")
    tool.setCreativeTab(ctab)
//    Recipes.shapedRecipe(new ItemStack(tool), craftingShape, 'x', toolType.craftMaterial, 's', Items.stick)
    GameRegistry.registerItem(tool, s"${toolType.toolName}_$prefix")
  }

  def newItemStack (amt: Int = 1) = new ItemStack(this.asInstanceOf[Item], amt)

}

class ToolAxe(val toolType: ToolTypeBase, ctab: CreativeTabBase) extends ItemAxe(toolType.toolType) with ToolBase {
  register(this, toolType, ctab)

  override def prefix: String = this.getClass.getSimpleName.substring(4)

  override def craftingShape = ToolTypeBase.axeCraftingShape

  override def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean): Unit = info(par1ItemStack, par3List.asInstanceOf[util.List[String]])
}

class ToolPickaxe(val toolType: ToolTypeBase, ctab: CreativeTabBase) extends ItemPickaxe(toolType.toolType) with ToolBase {
  register(this, toolType, ctab)

  override def prefix: String = this.getClass.getSimpleName.substring(4)

  override def craftingShape = ToolTypeBase.pickaxeCraftingShape

  override def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean): Unit = info(par1ItemStack, par3List.asInstanceOf[util.List[String]])
}

class ToolShovel(val toolType: ToolTypeBase, ctab: CreativeTabBase) extends ItemSpade(toolType.toolType) with ToolBase {
  register(this, toolType, ctab)

  override def prefix: String = this.getClass.getSimpleName.substring(4)

  override def craftingShape = ToolTypeBase.shovelCraftingShape

  override def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean): Unit = info(par1ItemStack, par3List.asInstanceOf[util.List[String]])
}

class ToolSword(val toolType: ToolTypeBase, ctab: CreativeTabBase) extends ItemSword(toolType.toolType) with ToolBase {
  register(this, toolType, ctab)

  override def prefix: String = this.getClass.getSimpleName.substring(4)

  override def craftingShape = ToolTypeBase.swordCraftingShape

  override def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean): Unit = info(par1ItemStack, par3List.asInstanceOf[util.List[String]])
}

class ToolHoe(val toolType: ToolTypeBase, ctab: CreativeTabBase) extends ItemHoe(toolType.toolType) with ToolBase {
  register(this, toolType, ctab)

  override def prefix: String = this.getClass.getSimpleName.substring(4)

  override def craftingShape = ToolTypeBase.pickaxeCraftingShape

  override def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: util.List[_], par4: Boolean): Unit = info(par1ItemStack, par3List.asInstanceOf[util.List[String]])
}