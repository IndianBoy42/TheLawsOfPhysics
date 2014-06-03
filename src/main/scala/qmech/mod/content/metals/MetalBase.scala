package qmech.mod.content.metals

import qmech.lib.objects.{ItemBase, BlockBase}
import net.minecraft.block.material.Material
import qmech.lib.handler.WorldGenerator
import qmech.mod.init.CTabs
import qmech.lib.objects.fluid.FluidBase
import qmech.lib.objects.equip.types.{ToolTypeBase, ArmorTypeBase}
import net.minecraft.item.ItemStack

/**
 * Created by anshuman on 26-05-2014.
 */
abstract class MetalBase(val metal: MetalInfo) {
  def register()

  var blocks: Map[String, BlockBase] = Map.empty
  def getBlock(name: String): BlockBase = blocks(name)
  def addBlock(block: BlockBase, prefix: String) = blocks += (prefix -> block)
  def getBlocks = for (block <- blocks.values) yield block
  def getOres = for (block <- blocks; if block._1 == "ore") yield block._2

  var items: Map[String, ItemBase] = Map.empty
  def getItem(name: String): ItemBase = items(name)
  def addItem(item: ItemBase, prefix: String) = items += (prefix -> item)
  def getItems = for (item <- items.values) yield item

  var fluids: Map[String, FluidBase] = Map.empty
  def getFluid(name: String): FluidBase = fluids(name)
  def addFluid(fluid: FluidBase, prefix: String) = fluids += (prefix -> fluid)
  def getFluids = for (fluid <- fluids.values) yield fluid

  var armors: Map[String, ArmorTypeBase] = Map.empty
  def getArmor(name: String): ArmorTypeBase = armors(name)
  def addArmor(armor: ArmorTypeBase, prefix: String) = armors += (prefix -> armor)
  def getArmors = for (armor <- armors.values) yield armor
  def getAllArmorPieces = for (armor <- armors.values; piece <- armor.armorPieces) yield piece
  def getArmorPieces (piece: Int) = for (armorPiece <- getAllArmorPieces; if armorPiece.armorPart == piece) yield armorPiece

  var tools: Map[String, ToolTypeBase] = Map.empty
  def getTool(name: String): ToolTypeBase = tools(name)
  def addTools(tool: ToolTypeBase, prefix: String) = tools+= (prefix -> tool)
  def getTools = for (tool <- tools.values) yield tool
  def getPickaxes = for (tool <- tools.values) yield tool.pickaxe
  def getShovels = for (tool <- tools.values) yield tool.shovel
  def getAxes = for (tool <- tools.values) yield tool.axe
  def getSwords = for (tool <- tools.values) yield tool.sword
  def getHoes = for (tool <- tools.values) yield tool.hoe

  def createBlock(prefix: String): Unit = createBlock(prefix, Material.iron)

  def createBlock(prefix: String, mat: Material) =
    addBlock(new BlockBase(prefix + metal.name, mat, CTabs.Metals, metal.getBlockInfo), prefix)

  def createItem(prefix: String): Unit = createItem(prefix, 64)

  def createItem(prefix: String, stack: Int) =
    addItem(new ItemBase(prefix + metal.name, CTabs.Metals, stack), prefix)

  def createFluid(prefix: String, mat: Material) =
    addFluid(new FluidBase(prefix + metal.name, mat, CTabs.Metals, metal.getFluidInfo), prefix)

  def createFluid(prefix: String): Unit = createFluid(prefix, Material.lava)

  def createArmor(prefix: String, mat: ItemStack) = {
    addArmor(new ArmorTypeBase(prefix + metal.name, metal.getArmorInfo, mat), prefix)
    getArmor(prefix).createArmorSet(CTabs.Metals)
  }

  def createArmor(prefix: String): Unit = createArmor(prefix, "ingot")

  def createArmor(prefix: String, mat: String): Unit = createArmor(prefix, new ItemStack(getItem(mat)))

  def createTools(prefix: String, mat: ItemStack) = {
    addTools(new ToolTypeBase(prefix + metal.name, metal.getToolInfo, mat), prefix)
    getTool(prefix).createToolSet(CTabs.Metals)
  }

  def createTools(prefix: String, mat: String): Unit = createTools(prefix, new ItemStack(getItem(mat)))

  def createTools(prefix: String): Unit = createTools(prefix, "ingot")

  def createOre() = {
    createBlock("ore")
    WorldGenerator.default.add(getBlock("ore"), metal.getOreGenInfo)
  }
}
