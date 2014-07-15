package geek.lawsof.physics.lib.metals

import net.minecraft.block.material.Material
import geek.lawsof.physics.lib.handler.WorldGenerator
import geek.lawsof.physics.init.{ModFluids, CTabs}
import geek.lawsof.physics.lib.fluid.FluidBase
import geek.lawsof.physics.lib.equip.types.{ToolTypeBase, ArmorTypeBase}
import net.minecraft.item.ItemStack
import geek.lawsof.physics.lib.info._
import geek.lawsof.physics.lib.item.{ItemDescriptor, ItemBase}
import geek.lawsof.physics.lib.block.{BlockDescriptor, BlockBase}
import net.minecraftforge.oredict.OreDictionary.registerOre
import geek.lawsof.physics.lib.util.Recipes._
import net.minecraftforge.fluids.FluidStack
import net.minecraft.init.Items
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by anshuman on 26-05-2014.
 */
object MetalsBase {
  type Ingot = MetalItem
}

class MetalItem extends ItemBase(CTabs.metalsTab)
//class MetalBlock(intName: String) extends BlockBase(intName)

//class SimpleMetal(metalInfo: MetalInfo) extends MetalBase(metalInfo) {
//  override def register(): Unit = {
//    createBlock("block")
//    createBlock("bricks")
//
//    createItem("ingot")
//    createItem("nugget")
//    createItem("brick")
//    createItem("plate")
//
//    createItem("powder")
//
//    createOre()
//    createOre("netherOre")
//    createOre("enderOre")
//    createOre("gravelOre")
//
//    semi processed forms of ore will be readded once more finalized
//    createItem("dust")
//    createItem("dirtyDust")
//    createItem("clump")
//    createItem("oreChunks")
//    createItem("oreGravel")
//    createItem("oreSand")
//    createFluid("oreSlurry")
//    createFluid("cleanSlurry")
//    createFluid("enrichedSlurry")
//
//    createFluid("molten")
//
//    createArmor()
//    createArmor("reinforced", "plate")
//
//    createTools()
//    createTools("reinforced", "plate")
//
//    oreDict()
//  }
//
//  override def recipes(): Unit = {
//    for (block <- blocks) registerOre(s"${block._1}${this.metal.name}", block._2)
//    for (item <- items) registerOre(s"${item._1}${this.metal.name}", item._2)
//
//    shapedRecipe(getBlock("block").newItemStack(),
//      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("ingot").newItemStack())
//    shapedRecipe(getBlock("bricks").newItemStack(),
//      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("brick").newItemStack())
//    shapedRecipe(getItem("ingot").newItemStack(),
//      grid3, 'x'.asInstanceOf[java.lang.Character], getItem("nugget").newItemStack())
//    shapedRecipe(getItem("plate").newItemStack(2),
//      grid2, 'x'.asInstanceOf[java.lang.Character], getItem("ingot").newItemStack())
//    shapedRecipe(getItem("brick").newItemStack(5),
//      cross3, 'x'.asInstanceOf[java.lang.Character], getItem("powder").newItemStack(), 'y'.asInstanceOf[java.lang.Character], new ItemStack(Items.clay_ball))
//    shapedRecipe(getItem("brick").newItemStack(2),
//      cross2, 'x'.asInstanceOf[java.lang.Character], getItem("powder").newItemStack(), 'y'.asInstanceOf[java.lang.Character], new ItemStack(Items.clay_ball))
//
//    smeltingRecipe(getItem("ingot").newItemStack(), getBlock("ore").newItemStack())
//    smeltingRecipe(getItem("ingot").newItemStack(), getItem("powder").newItemStack())
//    smeltingRecipe(getItem("ingot").newItemStack(), getBlock("netherOre").newItemStack())
//    smeltingRecipe(getItem("ingot").newItemStack(), getBlock("gravelOre").newItemStack())
//    smeltingRecipe(getItem("ingot").newItemStack(), getBlock("enderOre").newItemStack())
//
//    val armorIngotComposition = Array(5, 8, 7 ,4)
//    for (armor <- getAllArmorPieces)
//      smeltingRecipe(getItem("ingot").newItemStack(armorIngotComposition(armor.armorPart)), armor.newItemStack())
//
//    for (tool <- getTools) {
//      smeltingRecipe(getItem("ingot").newItemStack(3), tool.pickaxe.newItemStack())
//      smeltingRecipe(getItem("ingot").newItemStack(3), tool.axe.newItemStack())
//      smeltingRecipe(getItem("ingot").newItemStack(2), tool.sword.newItemStack())
//      smeltingRecipe(getItem("ingot").newItemStack(1), tool.shovel.newItemStack())
//      smeltingRecipe(getItem("ingot").newItemStack(2), tool.hoe.newItemStack())
//    }
//
//  }
//
//  def this(name: String,
//           getBlockInfo: BlockInfo, getFluidInfo: FluidInfo,
//           getOreGenInfo: GenStats,
//           getArmorInfo: ArmorInfo, getToolInfo: ToolInfo,
//           getMetalProperties: MetalProperties) =
//    this(new SimpleMetalInfo(name, getBlockInfo, getFluidInfo, getOreGenInfo, getArmorInfo, getToolInfo, getMetalProperties))
//}