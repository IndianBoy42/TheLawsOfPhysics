package geek.lawsof.physics.lib.block.render

import cpw.mods.fml.relauncher.{Side, SideOnly}
import geek.lawsof.physics.Reference
import geek.lawsof.physics.lib.block.render.model.CustomModelBase
import net.minecraft.block.Block
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.client.renderer.{OpenGlHelper, Tessellator}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import org.lwjgl.opengl.GL11

/**
 * Created by anshuman on 28-05-2014.
 */
@SideOnly(Side.CLIENT)
abstract class CustomRendererBase extends TileEntitySpecialRenderer {
  def getResource(texPath: String, texName: String): ResourceLocation = {
    new ResourceLocation(Reference.MOD_ID, s"$texPath/$texName")
  }

  def modelRender(model: CustomModelBase) {
    model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F)
  }

  def addTexture(texPath: String, texName: String) = this.bindTexture(getResource(texPath, texName))

  def addTexture(tex: (String, String)) = this.bindTexture(getResource(tex._1, tex._1))

  def renderTileEntityAt(tileEntity: TileEntity, x: Double, y: Double, z: Double, f: Float) {
    GL11.glPushMatrix()
    GL11.glTranslatef(x.asInstanceOf[Float] + 1.0F, y.asInstanceOf[Float] + 1.0F, z.asInstanceOf[Float])
    this.addTexture(tex)
    GL11.glPushMatrix()
    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F)
    this.renderModel()
    GL11.glPopMatrix()
    GL11.glPopMatrix()
  }

  private def rotateModelViaMeta(world: World, x: Int, y: Int, z: Int) {
    val meta: Int = world getBlockMetadata(x, y, z)
    GL11 glPushMatrix()
    GL11 glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F)
    GL11 glPopMatrix()
  }

  private def adjustLightFixture(world: World, i: Int, j: Int, k: Int, block: Block) {
    val tess: Tessellator = Tessellator.instance
    val brightness: Float = block.getMixedBrightnessForBlock(world, i, j, k)
    val skyLight: Int = world.getLightBrightnessForSkyBlocks(i, j, k, 0)
    val modulousModifier: Int = skyLight % 65536
    val divModifier: Int = skyLight / 65536
    tess.setColorOpaque_F(brightness, brightness, brightness)
    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, modulousModifier.asInstanceOf[Float], divModifier)
  }

  protected def renderModel()

  protected def tex: (String, String)

}
