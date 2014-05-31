package qmech.lib.tileentity.render.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by anshuman on 14-05-2014.
 */
public class BlockModelBase extends CustomModelBase {

    private ModelRenderer Block;

    private final String tex;

    public BlockModelBase(String tex) {
        this.tex = tex;
    }

    @Override
    public void renderShapes(Entity player, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Block.render(f5);
    }

    @Override
    public TexSize texSize() {
        return new TexSize(64, 32);
    }

    @Override
    public String texPath() {
        return this.tex;
    }

    @Override
    public void initShapes() {
        this.Block = new ModelRenderer(this, 0, 0);
        this.Block.addBox(0F, 0F, 0F, 16, 16, 16);
        this.Block.setRotationPoint(0F, 0F, 0F);
        this.Block.setTextureSize(64, 32);
        this.Block.mirror = true;
        this.setRotation(this.Block, 0F, 0F, 0F);
    }
}
