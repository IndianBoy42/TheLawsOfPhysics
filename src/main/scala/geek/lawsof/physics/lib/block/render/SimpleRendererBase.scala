package geek.lawsof.physics.lib.block.render

import cpw.mods.fml.client.registry.{RenderingRegistry, ISimpleBlockRenderingHandler}
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.world.IBlockAccess

/**
 * Created by anshuman on 22-07-2014.
 */
abstract class SimpleRendererBase extends ISimpleBlockRenderingHandler{
  override def getRenderId: Int = RenderingRegistry.getNextAvailableRenderId

  override def shouldRender3DInInventory(modelId: Int): Boolean = true
}
