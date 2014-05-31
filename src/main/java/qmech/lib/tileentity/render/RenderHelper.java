package qmech.lib.tileentity.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

/**
 * Contains various lib functions to assist with rendering.
 *
 * @author King Lemming
 */
public final class RenderHelper {

    public static final double RENDER_OFFSET = 1.0D / 1024.0D;
    private static final ResourceLocation MC_BLOCK_SHEET = new ResourceLocation("textures/atlas/blocks.png");
    private static final ResourceLocation MC_ITEM_SHEET = new ResourceLocation("textures/atlas/items.png");
    private static final ResourceLocation MC_FONT_DEFAULT = new ResourceLocation("textures/font/ascii.png");
    private static final ResourceLocation MC_FONT_ALTERNATE = new ResourceLocation("textures/font/ascii_sga.png");

    private RenderHelper() {

    }

    private static TextureManager engine() {

        return Minecraft.getMinecraft().renderEngine;
    }

    private static Tessellator tessellator() {

        return Tessellator.instance;
    }

    public static void setColor3ub(int color) {

        GL11.glColor3ub((byte) (color >> 16 & 0xFF), (byte) (color >> 8 & 0xFF), (byte) (color & 0xFF));
    }

    public static void setColor4ub(int color) {

        GL11.glColor4ub((byte) (color >> 24 & 0xFF), (byte) (color >> 16 & 0xFF), (byte) (color >> 8 & 0xFF), (byte) (color & 0xFF));
    }

    public static void resetColor() {

        GL11.glColor4f(1F, 1F, 1F, 1F);
    }

    public static void renderItemAsBlock(RenderBlocks renderer, ItemStack item, double translateX, double translateY, double translateZ) {

        Tessellator tessellator = tessellator();
        Block block = Blocks.stone;
        IIcon texture = item.getIconIndex();

        if (texture == null) {
            return;
        }
        renderer.setRenderBoundsFromBlock(block);
        GL11.glTranslated(translateX, translateY, translateZ);
        tessellator.startDrawingQuads();

        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, texture);

        tessellator.draw();
    }

    public static void renderItemIn2D(IIcon icon) {

        ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(),
                icon.getIconHeight(), 0.0625F);
    }

    public static void renderIcon(IIcon icon, double z) {

        Tessellator.instance.startDrawingQuads();
        Tessellator.instance.addVertexWithUV(0, 16, z, icon.getMinU(), icon.getMaxV());
        Tessellator.instance.addVertexWithUV(16, 16, z, icon.getMaxU(), icon.getMaxV());
        Tessellator.instance.addVertexWithUV(16, 0, z, icon.getMaxU(), icon.getMinV());
        Tessellator.instance.addVertexWithUV(0, 0, z, icon.getMinU(), icon.getMinV());
        Tessellator.instance.draw();
    }

    public static void renderIcon(int x, int y, int z, IIcon icon, int width, int height) {

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, z, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + width, y + height, z, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + width, y, z, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(x, y, z, icon.getMinU(), icon.getMinV());
        tessellator.draw();
    }

    public static IIcon getFluidTexture(Fluid fluid) {

        if (fluid == null) {
            return FluidRegistry.LAVA.getIcon();
        }
        return fluid.getIcon();
    }

    public static IIcon getFluidTexture(FluidStack fluid) {

        if (fluid == null || fluid.getFluid() == null || fluid.getFluid().getIcon(fluid) == null) {
            return FluidRegistry.LAVA.getIcon();
        }
        return fluid.getFluid().getIcon(fluid);
    }

    public static void bindItemTexture(ItemStack stack) {

        engine().bindTexture(stack.getItemSpriteNumber() == 0 ? MC_BLOCK_SHEET : MC_ITEM_SHEET);
    }

    public static void bindTexture(ResourceLocation texture) {

        engine().bindTexture(texture);
    }

    public static void setBlockTextureSheet() {

        bindTexture(MC_BLOCK_SHEET);
    }

    public static void setItemTextureSheet() {

        bindTexture(MC_ITEM_SHEET);
    }

    public static void setDefaultFontTextureSheet() {

        bindTexture(MC_FONT_DEFAULT);
    }

    public static void setSGAFontTextureSheet() {

        bindTexture(MC_FONT_ALTERNATE);
    }

}
