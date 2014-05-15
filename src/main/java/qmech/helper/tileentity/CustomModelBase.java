package qmech.helper.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by anshuman on 14-05-2014.
 */
public abstract class CustomModelBase extends ModelBase {

    public CustomModelBase() {
        initTextureSize();
        initShapes();
    }

    public void render(Entity player, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(player, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, player);
    }

    public abstract void renderShapes(Entity player, float f, float f1, float f2, float f3, float f4, float f5);

    public abstract void initTextureSize();

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
