package qmech.mod.content.metals

import qmech.lib.objects.{ItemBase, BlockBase}
import net.minecraft.block.material.Material
import qmech.lib.handler.WorldGenerator
import qmech.mod.init.{ModFluids, CTabs}
import qmech.lib.objects.fluid.FluidBase
import qmech.lib.objects.equip.types.{ToolTypeBase, ArmorTypeBase}
import net.minecraft.item.ItemStack
import qmech.lib.objects.info._
import qmech.lib.helper.Recipes
import net.minecraft.init.Items

/**
 * Created by anshuman on 26-05-2014.
 */
abstract class MetalBase(val metal: MetalInfo) {
  def register()

  def recipes()

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

  def getArmorPieces(piece: Int) = for (armorPiece <- getAllArmorPieces; if armorPiece.armorPart == piece) yield armorPiece

  var tools: Map[String, ToolTypeBase] = Map.empty

  def getTool(name: String): ToolTypeBase = tools(name)

  def addTools(tool: ToolTypeBase, prefix: String) = tools += (prefix -> tool)

  def getTools = for (tool <- tools.values) yield tool

  def getPickaxes = for (tool <- tools.values) yield tool.pickaxe

  def getShovels = for (tool <- tools.values) yield tool.shovel

  def getAxes = for (tool <- tools.values) yield tool.axe

  def getSwords = for (tool <- tools.values) yield tool.sword

  def getHoes = for (tool <- tools.values) yield tool.hoe

  def createBlock(prefix: String): Unit = createBlock(prefix, Material.iron)

  def createBlock(prefix: String, mat: Material) =
    addBlock(new BlockBase(s"${prefix}_${metal.name}", mat, CTabs.Metals, metal.getBlockInfo), prefix)

  def createItem(prefix: String): Unit = createItem(prefix, 64)

  def createItem(prefix: String, stack: Int) =
    addItem(new ItemBase(s"${prefix}_${metal.name}", CTabs.Metals, stack), prefix)

  def createFluid(prefix: String, mat: Material) = {
    addFluid(new FluidBase(s"${prefix}_${metal.name}", mat, CTabs.Metals, metal.getFluidInfo), prefix)
    ModFluids.registerFluid(getFluid(prefix))
  }

  def createFluid(prefix: String): Unit = createFluid(prefix, Material.lava)

  def createArmor(prefix: String, mat: ItemStack) = {
    addArmor(new ArmorTypeBase(s"${prefix}_${metal.name}", metal.getArmorInfo, mat), prefix)
    getArmor(prefix).createArmorSet(CTabs.Metals)
  }

  def createArmor(prefix: String): Unit = createArmor(prefix, "ingot")

  def createArmor(prefix: String, mat: String): Unit = createArmor(prefix, new ItemStack(getItem(mat)))

  def createTools(prefix: String, mat: ItemStack) = {
    addTools(new ToolTypeBase(s"${prefix}_${metal.name}", metal.getToolInfo, mat), prefix)
    getTool(prefix).createToolSet(CTabs.Metals)
  }

  def createTools(prefix: String, mat: String): Unit = createTools(prefix, new ItemStack(getItem(mat)))

  def createTools(prefix: String): Unit = createTools(prefix, "ingot")

  def createOre(ore: String = "") = {
    ore match {
      case "" | "ore" => createBlock("ore")
        WorldGenerator.default.add(getBlock("ore"), metal.getOreGenInfo)
      case _ => createBlock(s"${ore}Ore")
    }
  }
}

class SimpleMetal(metalInfo: MetalInfo) extends MetalBase(metalInfo) {
  override def register(): Unit = {
    createBlock("block")
    createBlock("bricks")

    createItem("ingot")
    createItem("nugget")
    createItem("brick")
    createItem("plate")

    createOre()
    createOre("nether")
    createOre("ender")
    createOre("gravel")

    createItem("dust")
    createItem("powder")
    createItem("dirtyDust")
    createItem("clump")

    createFluid("molten")
    createFluid("slurry")
    createFluid("cleanSlurry")
    createFluid("enrichedSlurry")
  }

  override def recipes(): Unit = {
//    Recipes.shapedRecipe(getBlock("block").newItemStack(),
//      Recipes.grid3, 'x', getItem("ingot").newItemStack() )
//    Recipes.shapedRecipe(getBlock("bricks").newItemStack(),
//      Recipes.grid3, 'x', getItem("brick").newItemStack() )
//    Recipes.shapedRecipe(getItem("ingot").newItemStack(),
//      Recipes.grid3, 'x', getItem("nugget").newItemStack() )
//    Recipes.shapedRecipe(getItem("plate").newItemStack(2),
//      Recipes.grid2, 'x', getItem("ingot").newItemStack())
//    Recipes.shapedRecipe(getItem("brick").newItemStack(5),
//      Recipes.cross3, 'x', getItem("powder").newItemStack(), 'y', new ItemStack(Items.clay_ball))
//    Recipes.shapedRecipe(getItem("brick").newItemStack(2),
//      Recipes.cross2, 'x', getItem("powder").newItemStack(), 'y', new ItemStack(Items.clay_ball))
//
//    Recipes.smeltingRecipe(getItem("ingot").newItemStack(), getBlock("ore").newItemStack())
//    Recipes.smeltingRecipe(getItem("ingot").newItemStack(), getBlock("netherOre").newItemStack())
//    Recipes.smeltingRecipe(getItem("ingot").newItemStack(), getBlock("gravelOre").newItemStack())
//    Recipes.smeltingRecipe(getItem("ingot").newItemStack(), getBlock("enderOre").newItemStack())
  }

  def this(name: String,
           getBlockInfo: BlockInfo, getFluidInfo: FluidInfo,
           getOreGenInfo: GenStats,
           getArmorInfo: ArmorInfo, getToolInfo: ToolInfo,
           getMetalProperties: MetalProperties) =
    this(new SimpleMetalInfo(name, getBlockInfo, getFluidInfo, getOreGenInfo, getArmorInfo, getToolInfo, getMetalProperties))
}