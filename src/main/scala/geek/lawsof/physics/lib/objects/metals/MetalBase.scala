package geek.lawsof.physics.lib.objects.metals

import net.minecraft.block.material.Material
import geek.lawsof.physics.lib.handler.WorldGenerator
import geek.lawsof.physics.init.{ModFluids, CTabs}
import geek.lawsof.physics.lib.objects.fluid.FluidBase
import geek.lawsof.physics.lib.objects.equip.types.{ToolTypeBase, ArmorTypeBase}
import net.minecraft.item.ItemStack
import geek.lawsof.physics.lib.objects.info._
import geek.lawsof.physics.lib.objects.item.ItemBase
import geek.lawsof.physics.lib.objects.block.BlockBase
import net.minecraftforge.oredict.OreDictionary.registerOre
import geek.lawsof.physics.lib.helper.Recipes._
import net.minecraftforge.fluids.FluidStack
import net.minecraft.init.Items
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by anshuman on 26-05-2014.
 */
abstract class MetalBase(val metal: MetalInfo) {
  def register()

  def oreDict() = {
    for (obj <- blocks) OreDictionary.registerOre(s"${obj._1}${metal.name}", obj._2)
    for (obj <- items) OreDictionary.registerOre(s"${obj._1}${metal.name}", obj._2)
    for (obj <- fluids) OreDictionary.registerOre(s"${obj._1}${metal.name}", obj._2.getBlock)
  }

  def recipes()

  var blocks: Map[String, BlockBase] = Map.empty

  def getBlock(name: String): BlockBase = blocks(name)

  def getBlockStack(name: String): ItemStack = blocks(name).newItemStack()

  def addBlock(block: BlockBase, prefix: String) = blocks += (prefix -> block)

  def getBlocks = for (block <- blocks.values) yield block

  def getOres = for (block <- blocks; if block._1 == "ore") yield block._2

  var items: Map[String, ItemBase] = Map.empty

  def getItem(name: String): ItemBase = items(name)

  def getItemStack(name: String): ItemStack = items(name).newItemStack()

  def addItem(item: ItemBase, prefix: String) = items += (prefix -> item)

  def getItems = for (item <- items.values) yield item

  var fluids: Map[String, FluidBase] = Map.empty

  def getFluid(name: String): FluidBase = fluids(name)

  def getFluidStack(name: String): FluidStack = fluids(name).newFluidStack()

  def getFluidBlockStack(name: String): ItemStack = fluids(name).newItemStack()

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

  def createBlock(prefix: String, mat: Material) = {
    addBlock(new BlockBase(s"${prefix}_${metal.name}", mat, CTabs.Metals, metal.getBlockInfo), prefix)
  }

  def createItem(prefix: String): Unit = createItem(prefix, 64)

  def createItem(prefix: String, stack: Int) =
    addItem(new ItemBase(s"${prefix}_${metal.name}", CTabs.Metals, stack), prefix)

  def createFluid(prefix: String, mat: Material) = {
    addFluid(new FluidBase(s"${prefix}_${metal.name}", mat, CTabs.Metals, metal.getFluidInfo), prefix)
    ModFluids.registerFluid(getFluid(prefix))
  }

  def createFluid(prefix: String): Unit = createFluid(prefix, Material.lava)

  def createArmor(prefix: String, mat: ItemStack) = {
    val fix = prefix match {
      case "armor" | "" => ""
      case _ => prefix
    }
    addArmor(new ArmorTypeBase(s"${fix}${metal.name}", metal.getArmorInfo, mat), prefix)
    getArmor(prefix).createArmorSet(CTabs.Metals)
  }

  def createArmor(prefix: String): Unit = createArmor(prefix, "ingot")

  def createArmor(prefix: String = "armor", mat: String = "ingot"): Unit = createArmor(prefix, new ItemStack(getItem(mat)))

  def createTools(prefix: String, mat: ItemStack) = {
    val fix = prefix match {
      case "tool" | "" => ""
      case _ => prefix
    }
    addTools(new ToolTypeBase(s"${fix}${metal.name}", metal.getToolInfo, mat), prefix)
    getTool(prefix).createToolSet(CTabs.Metals)
  }

  def createTools(prefix: String = "tool", mat: String = "ingot"): Unit = createTools(prefix, new ItemStack(getItem(mat)))

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

    createItem("powder")

    createOre()
    //createOre("netherOre")
    //createOre("enderOre")
    //createOre("gravelOre")

    //semi processed forms of ore will be readded once more finalized
    //createItem("dust")
    //createItem("dirtyDust")
    //createItem("clump")
    //createItem("oreChunks")
    //createItem("oreGravel")
    //createItem("oreSand")
    //createFluid("oreSlurry")
    //createFluid("cleanSlurry")
    //createFluid("enrichedSlurry")

    createFluid("molten")

    createArmor()
    createArmor("reinforced", "plate")

    createTools()
    createTools("reinforced", "plate")

    oreDict()
  }

  override def recipes(): Unit = {
    for (block <- blocks) registerOre(s"${block._1}${this.metal.name}", block._2)
    for (item <- items) registerOre(s"${item._1}${this.metal.name}", item._2)

    shapedRecipe(getBlock("block").newItemStack(),
      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("ingot").newItemStack())
    shapedRecipe(getBlock("bricks").newItemStack(),
      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("brick").newItemStack())
    shapedRecipe(getItem("ingot").newItemStack(),
      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("nugget").newItemStack())
    shapedRecipe(getItem("plate").newItemStack(2),
      grid2, 'x'.asInstanceOf[java.lang.Character], getItem("ingot").newItemStack())
    shapedRecipe(getItem("brick").newItemStack(5),
      cross3, 'x'.asInstanceOf[java.lang.Character], getItem("powder").newItemStack(), 'y'.asInstanceOf[java.lang.Character], new ItemStack(Items.clay_ball))
    shapedRecipe(getItem("brick").newItemStack(2),
      cross2, 'x'.asInstanceOf[java.lang.Character], getItem("powder").newItemStack(), 'y'.asInstanceOf[java.lang.Character], new ItemStack(Items.clay_ball))

    smeltingRecipe(getItem("ingot").newItemStack(), getBlock("ore").newItemStack())
    smeltingRecipe(getItem("ingot").newItemStack(), getItem("powder").newItemStack())
    //smeltingRecipe(getItem("ingot").newItemStack(), getBlock("netherOre").newItemStack())
    //smeltingRecipe(getItem("ingot").newItemStack(), getBlock("gravelOre").newItemStack())
    //smeltingRecipe(getItem("ingot").newItemStack(), getBlock("enderOre").newItemStack())

    val armorIngotComposition = Array(5, 8, 7 ,4)
    for (armor <- getAllArmorPieces)
      smeltingRecipe(getItem("ingot").newItemStack(armorIngotComposition(armor.armorPart)), armor.newItemStack())

    for (tool <- getTools) {
      smeltingRecipe(getItem("ingot").newItemStack(3), tool.pickaxe.newItemStack())
      smeltingRecipe(getItem("ingot").newItemStack(3), tool.axe.newItemStack())
      smeltingRecipe(getItem("ingot").newItemStack(2), tool.sword.newItemStack())
      smeltingRecipe(getItem("ingot").newItemStack(1), tool.shovel.newItemStack())
      smeltingRecipe(getItem("ingot").newItemStack(2), tool.hoe.newItemStack())
    }

  }

  def this(name: String,
           getBlockInfo: BlockInfo, getFluidInfo: FluidInfo,
           getOreGenInfo: GenStats,
           getArmorInfo: ArmorInfo, getToolInfo: ToolInfo,
           getMetalProperties: MetalProperties) =
    this(new SimpleMetalInfo(name, getBlockInfo, getFluidInfo, getOreGenInfo, getArmorInfo, getToolInfo, getMetalProperties))
}