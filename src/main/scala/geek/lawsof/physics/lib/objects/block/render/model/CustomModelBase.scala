package geek.lawsof.physics.lib.objects.block.render.model

import net.minecraft.client.model.{TextureOffset, ModelRenderer, ModelBase}
import net.minecraft.entity.Entity

/**
 * Created by anshuman on 28-05-2014.
 */
abstract class CustomModelBase extends ModelBase {
  initShapes

  def texSize: (Int, Int)

  override def render(p: Entity, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float, f6: Float) = {
    super.render(p, f1, f2, f3, f4, f5, f6)
    setRotationAngles(f1, f2, f3, f4, f5, f6, p)
    renderShapes(p, f1, f2, f3, f4, f5, f6)
  }

  def renderShapes(p: Entity, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float, f6: Float)

  def initShapes

  def setRotationForModel(model: ModelRenderer, f1: Int, f2: Int, f3: Int) = {
    model.rotateAngleX = f1
    model.rotateAngleY = f2
    model.rotateAngleZ = f3
  }

  def initCubeShape(offset: TextureOffset = new TextureOffset(0, 0),
                    corner: (Int, Int, Int) = (0, 0, 0),
                    size: (Int, Int, Int) = (16, 16, 16),
                    rotationPoint: (Float, Float, Float) = (0F, 0F, 0F),
                    rotation: (Int, Int, Int) = (0, 0, 0),
                    mirror: Boolean = false) = {
    var block: ModelRenderer = new ModelRenderer(this, offset.textureOffsetX, offset.textureOffsetY)
    block.addBox(corner._1, corner._2, corner._3, size._1, size._2, size._3)
    block.setRotationPoint(rotationPoint._1, rotationPoint._2, rotationPoint._3)
    block.setTextureSize(texSize._1, texSize._2)
    setRotationForModel(block, rotation._1, rotation._2, rotation._3)
    block.mirror = mirror
  }

  def renderShape(block: ModelRenderer, f6: Float) = block.render(f6)
}
