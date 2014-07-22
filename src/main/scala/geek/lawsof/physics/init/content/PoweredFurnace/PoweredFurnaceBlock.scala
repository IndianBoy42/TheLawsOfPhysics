package geek.lawsof.physics.init.content.PoweredFurnace

import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.init.CTabs
import geek.lawsof.physics.lib.block.te.TileEntityBase
import geek.lawsof.physics.lib.block.traits.{singleSided, IconArray}
import geek.lawsof.physics.lib.block.{ItemBlockBase, BlockDescriptor, BlockBase}
import geek.lawsof.physics.lib.item.ItemDescriptor
import geek.lawsof.physics.lib.item.traits.CustomTooltip
import net.minecraft.block.Block

/**
 * Created by anshuman on 22-07-2014.
 */
class PoweredFurnaceBlock extends BlockBase("PoweredFurnace", ctab = CTabs.techTab) {
  this +: PoweredFurnaceDescriptor

  def register() = {
    GameRegistry.registerBlock(this, classOf[ItemBlockBase], "PoweredFurnace")
    registerTiles()
  }
}

object PoweredFurnaceDescriptor
  extends BlockDescriptor("PoweredFurnace",
    IconArray.apply("PoweredFurnace"),
    new ItemDescriptor("PoweredFurnace",
      tooltip = CustomTooltip.apply(
        List("A Furnace Powered By Stuff And Things"),
        List("Smelts Stuff Just Like A Normal Furnace", "Requires Power To Do So"),
        List("Requires --==N/A==-- Power To Functions", "Consumes --==N/A==-- Power While Smelting")
      )
    )
  ) {
  override def teClass: Class[_ <: TileEntityBase] = classOf[PoweredFurnaceTile]
}