package qmech.helper.tileentity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import qmech.helper.LoggingHelper;

/**
 * Created by anshuman on 14-05-2014.
 */
public abstract class CustomModelBase extends ModelBase {

    public static class TexSize {
        int width;
        int height;

        public TexSize(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public CustomModelBase() {
        this.textureHeight = this.texSize().height;
        this.textureWidth = this.texSize().width;
        initShapes();
    }

    public void render(Entity player, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(player, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, player);
        renderShapes(player, f, f1, f2, f3, f4, f5);
    }

    public abstract void renderShapes(Entity player, float f, float f1, float f2, float f3, float f4, float f5);

    public abstract TexSize texSize();
    public abstract String texPath();
    public abstract void initShapes();

    public void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityPlayer player)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, player);
    }

}
