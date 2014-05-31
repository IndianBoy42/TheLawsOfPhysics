package qmech.lib.tileentity.gui;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.gui.components.slot.SlotFalseCopy;
import qmech.lib.tileentity.render.RenderHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anshuman on 17-05-2014.
 */
public abstract class GuiBase extends GuiContainer {

    public static final SoundHandler guiSoundManager = FMLClientHandler.instance().getClient().getSoundHandler();
    public static final FontRenderer guiFontRenderer = FMLClientHandler.instance().getClient().fontRenderer;
    private final boolean drawInventory = true;
    private int mouseX = 0;
    private int mouseY = 0;
    private int lastIndex = -1;
    private String name;
    private ResourceLocation texture;
    private final List<String> tooltip = new LinkedList<String>();
    public GuiBase(InventoryPlayer p, TileEntityBase te) {
        super(new GuiContainerBase(p, te));
    }

    public GuiBase(GuiContainerBase container) {

        super(container);
    }

    public GuiBase(Container container, ResourceLocation texture) {

        super(container);
        this.texture = texture;
    }

    protected abstract ArrayList<GuiComponentBase> getElements();

    @Override
    public void initGui() {

        super.initGui();
        this.getElements().clear();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        this.fontRendererObj.drawString(this.name, this.getCenteredOffset(this.name), 6, 0x404040);
        if (this.drawInventory) {
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 3, 0x404040);
        }
        if (!Loader.isModLoaded("NotEnoughItems") && this.mc.thePlayer.inventory.getItemStack() == null) {
            this.addTooltips(this.tooltip);
            this.drawTooltip(this.tooltip);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {

        this.updateElements();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.texture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        this.drawElements();
    }

    @Override
    protected void mouseClicked(int x, int y, int mouseButton) {

        super.mouseClicked(x, y, mouseButton);

        GuiComponentBase element = this.getElementAtPosition(this.mouseX, this.mouseY);

        if (element != null) {
            element.handleMouseClicked(this.mouseX, this.mouseY, mouseButton);
        }
    }

    @Override
    protected void mouseClickMove(int mX, int mY, int lastClick, long timeSinceClick) {

        Slot slot = this.getSlotAtPosition(mX, mY);
        ItemStack itemstack = this.mc.thePlayer.inventory.getItemStack();

        if (this.field_147007_t && slot != null && itemstack != null && slot instanceof SlotFalseCopy) {
            if (this.lastIndex != slot.slotNumber) {
                this.lastIndex = slot.slotNumber;
                this.handleMouseClick(slot, slot.slotNumber, 0, 0);
            }
        } else {
            this.lastIndex = -1;
            super.mouseClickMove(mX, mY, lastClick, timeSinceClick);
        }
    }

    Slot getSlotAtPosition(int xCoord, int yCoord) {

        for (int k = 0; k < this.inventorySlots.inventorySlots.size(); ++k) {
            Slot slot = (Slot) this.inventorySlots.inventorySlots.get(k);

            if (this.isMouseOverSlot(slot, xCoord, yCoord)) {
                return slot;
            }
        }

        return null;
    }

    boolean isMouseOverSlot(Slot theSlot, int xCoord, int yCoord) {

        return this.func_146978_c(theSlot.xDisplayPosition, theSlot.yDisplayPosition, 16, 16, xCoord, yCoord);
    }

    @Override
    public void handleMouseInput() {

        int x = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int y = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        this.mouseX = x - this.guiLeft;
        this.mouseY = y - this.guiTop;

        super.handleMouseInput();
    }

    /**
     * Draws the getElements() for this GUI.
     */
    void drawElements() {

        for (GuiComponentBase element : this.getElements()) {
            element.draw();
        }
    }

    /**
     * Called by NEI if installed
     */
    // @Override
    public List<String> handleTooltip(int mousex, int mousey, List<String> tooltip) {
        this.addTooltips(tooltip);
        return tooltip;
    }

    void addTooltips(List<String> tooltip) {
        GuiComponentBase element = this.getElementAtPosition(this.mouseX, this.mouseY);

        if (element != null) {
            element.addTooltip(tooltip);
        }
    }

    /* ELEMENTS */
    public GuiComponentBase addElement(GuiComponentBase element) {

        this.getElements().add(element);
        return element;
    }

    GuiComponentBase getElementAtPosition(int mX, int mY) {

        for (GuiComponentBase element : this.getElements()) {
            if (element.intersectsWith(mX, mY)) {
                return element;
            }
        }
        return null;
    }

    protected abstract void updateElements();

    public abstract void handleElementButtonClick(String buttonName, int mouseButton);

	/* HELPERS */

    /**
     * Abstract method to retrieve icons by name from a registry You must override this if you use any of the String methods below
     */
    public abstract IIcon getIcon(String name);

    /**
     * Essentially a placeholder method for tabs to use should they need to draw a button.
     */
    void drawButton(IIcon icon, int x, int y, int spriteSheet, int mode) {

        this.drawIcon(icon, x, y, spriteSheet);
    }

    public void drawButton(String iconName, int x, int y, int spriteSheet, int mode) {

        this.drawButton(this.getIcon(iconName), x, y, spriteSheet, mode);
    }

    /**
     * Simple method used to draw a fluid of arbitrary size.
     */
    public void drawFluid(int x, int y, FluidStack fluid, int width, int height) {

        if (fluid == null || fluid.getFluid() == null) {
            return;
        }
        RenderHelper.setBlockTextureSheet();
        RenderHelper.setColor3ub(fluid.getFluid().getColor(fluid));

        this.drawTiledTexture(x, y, fluid.getFluid().getIcon(fluid), width, height);
    }

    void drawTiledTexture(int x, int y, IIcon icon, int width, int height) {

        int i;
        int j;

        int drawHeight;
        int drawWidth;

        for (i = 0; i < width; i += 16) {
            for (j = 0; j < height; j += 16) {
                drawWidth = Math.min(width - i, 16);
                drawHeight = Math.min(height - j, 16);
                this.drawScaledTexturedModelRectFromIcon(x + i, y + j, icon, drawWidth, drawHeight);
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0F);
    }

    void drawIcon(IIcon icon, int x, int y, int spriteSheet) {

        if (spriteSheet == 0) {
            RenderHelper.setBlockTextureSheet();
        } else {
            RenderHelper.setItemTextureSheet();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0F);
        this.drawTexturedModelRectFromIcon(x, y, icon, 16, 16);
    }

    public void drawIcon(String iconName, int x, int y, int spriteSheet) {

        this.drawIcon(this.getIcon(iconName), x, y, spriteSheet);
    }

    public void drawSizedTexturedModalRect(int x, int y, int u, int v, int width, int height, float texW, float texH) {

        float texU = 1 / texW;
        float texV = 1 / texH;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, this.zLevel, (u) * texU, (v + height) * texV);
        tessellator.addVertexWithUV(x + width, y + height, this.zLevel, (u + width) * texU, (v + height) * texV);
        tessellator.addVertexWithUV(x + width, y, this.zLevel, (u + width) * texU, (v) * texV);
        tessellator.addVertexWithUV(x, y, this.zLevel, (u) * texU, (v) * texV);
        tessellator.draw();
    }

    void drawScaledTexturedModelRectFromIcon(int x, int y, IIcon icon, int width, int height) {

        if (icon == null) {
            return;
        }
        double minU = icon.getMinU();
        double maxU = icon.getMaxU();
        double minV = icon.getMinV();
        double maxV = icon.getMaxV();

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, this.zLevel, minU, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y + height, this.zLevel, minU + (maxU - minU) * width / 16F, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y, this.zLevel, minU + (maxU - minU) * width / 16F, minV);
        tessellator.addVertexWithUV(x, y, this.zLevel, minU, minV);
        tessellator.draw();
    }

    void drawTooltip(List<String> list) {

        this.drawTooltipHoveringText(list, this.mouseX, this.mouseY, this.fontRendererObj);
        this.tooltip.clear();
    }

    @SuppressWarnings("rawtypes")
    void drawTooltipHoveringText(List list, int x, int y, FontRenderer font) {

        if (list == null || list.isEmpty()) {
            return;
        }
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        int k = 0;

        for (Object aList : list) {
            String s = (String) aList;
            int l = font.getStringWidth(s);

            if (l > k) {
                k = l;
            }
        }
        int i1 = x + 12;
        int j1 = y - 12;
        int k1 = 8;

        if (list.size() > 1) {
            k1 += 2 + (list.size() - 1) * 10;
        }
        if (i1 + k > this.width) {
            i1 -= 28 + k;
        }
        if (j1 + k1 + 6 > this.height) {
            j1 = this.height - k1 - 6;
        }
        this.zLevel = 300.0F;
        itemRender.zLevel = 300.0F;
        int l1 = -267386864;
        this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
        this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
        this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
        this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
        this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
        int i2 = 1347420415;
        int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
        this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
        this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
        this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
        this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

        for (int k2 = 0; k2 < list.size(); ++k2) {
            String s1 = (String) list.get(k2);
            font.drawStringWithShadow(s1, i1, j1, -1);

            if (k2 == 0) {
                j1 += 2;
            }
            j1 += 10;
        }
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }

    /**
     * Passthrough method for tab use.
     */
    public void mouseClicked(int mouseButton) {

        super.mouseClicked(this.guiLeft + this.mouseX, this.guiTop + this.mouseY, mouseButton);
    }

    int getCenteredOffset(String string) {

        return this.getCenteredOffset(string, this.xSize);
    }

    int getCenteredOffset(String string, int xWidth) {

        return (xWidth - this.fontRendererObj.getStringWidth(string)) / 2;
    }

    public int getGuiLeft() {

        return this.guiLeft;
    }

    public int getGuiTop() {

        return this.guiTop;
    }

    public int getMouseX() {

        return this.mouseX;
    }

    public int getMouseY() {

        return this.mouseY;
    }

    public abstract void overlayRecipe();


    public abstract String texPath();

    public abstract int GuiID();

}
