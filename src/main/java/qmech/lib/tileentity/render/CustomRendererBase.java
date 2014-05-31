package qmech.lib.tileentity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import qmech.lib.tileentity.render.model.CustomModelBase;
import qmech.mod.Reference;

/**
 * Created by anshuman on 15-05-2014.
 */
@SideOnly(Side.CLIENT)
public abstract class CustomRendererBase extends TileEntitySpecialRenderer {

    private static void bindTexture(String texPath) {
        ResourceLocation tex = new ResourceLocation(Reference.MOD_ID, String.format("%s/%s.png", Reference.TEXTURES_MODELS, texPath));
        Minecraft.getMinecraft().renderEngine.bindTexture(tex);

    }

    static void modelRender(CustomModelBase model) {
        model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    }

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 1.0F, (float) y + 1.0F, (float) z);

        bindTexture(this.texPath());

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

        //rotateModelViaMeta();
        //adjustLightFixture();

        this.renderModel();

        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private void rotateModelViaMeta(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }

    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getMixedBrightnessForBlock(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }

    protected abstract void renderModel();

    protected abstract String texPath();
}
