package qmech.helper.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import qmech.helper.LoggingHelper;
import qmech.mod.Reference;

import static qmech.mod.Reference.*;

/**
 * Created by anshuman on 14-05-2014.
 */
@SideOnly(Side.CLIENT)
public class BlockRendererBase extends CustomRendererBase{

    CustomModelBase model;
    String texPath;

    public BlockRendererBase(CustomModelBase model, String texture) {
        this.model = model;
        texPath = texture;
    }

    @Override
    public void renderModel() {
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    }

    @Override
    public String texPath() {
        return texPath;
    }
}
