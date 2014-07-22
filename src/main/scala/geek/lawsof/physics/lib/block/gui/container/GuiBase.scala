package geek.lawsof.physics.lib.block.gui.container

import net.minecraft.client.gui.inventory.GuiContainer

/**
 * Created by anshuman on 28-05-2014.
 */
class GuiBase(container: ContainerBase, val drawTitle: Boolean = true, val drawInventory: Boolean = true, override val doesGuiPauseGame: Boolean = false) extends GuiContainer(container){
  val mouseX: Int = 0
  val mouseY: Int = 0

  override def drawGuiContainerBackgroundLayer(partialTick : Float, x : Int, y : Int): Unit = {}

  override def drawGuiContainerForegroundLayer(x : Int, y : Int): Unit = {}
}
