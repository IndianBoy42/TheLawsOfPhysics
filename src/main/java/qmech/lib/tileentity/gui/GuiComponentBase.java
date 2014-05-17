package qmech.lib.tileentity.gui;

import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by anshuman on 17-05-2014.
 */
public abstract class GuiComponentBase {


    protected GuiBase gui;
    protected ResourceLocation texture;

    protected int posX;
    protected int posY;

    protected int sizeX;
    protected int sizeY;

    public int texW = 256;
    public int texH = 256;

    protected String name;

    protected boolean visible = true;

    public GuiComponentBase(GuiBase gui, int posX, int posY) {

        this.gui = gui;
        this.posX = gui.getGuiLeft() + posX;
        this.posY = gui.getGuiTop() + posY;
    }

    public GuiComponentBase setName(String name) {

        this.name = name;
        return this;
    }

    public GuiComponentBase setPosition(int posX, int posY) {

        this.posX = gui.getGuiLeft() + posX;
        this.posY = gui.getGuiTop() + posY;
        return this;
    }

    public GuiComponentBase setSize(int sizeX, int sizeY) {

        this.sizeX = sizeX;
        this.sizeY = sizeY;
        return this;
    }

    public GuiComponentBase setTexture(String texture, int texW, int texH) {

        this.texture = new ResourceLocation(texture);
        this.texW = texW;
        this.texH = texH;
        return this;
    }

    public GuiComponentBase setVisible(boolean visible) {

        this.visible = visible;
        return this;
    }

    public boolean isVisible() {

        return visible;
    }

    public void update() {

    }

    public abstract void draw();

    public void draw(int x, int y) {

        this.posX = x;
        this.posY = y;
        draw();
    }

    public void addTooltip(List<String> list) {

    }

    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {

        gui.drawSizedTexturedModalRect(x, y, u, v, width, height, texW, texH);
    }

    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        return false;
    }

    public boolean intersectsWith(int mouseX, int mouseY) {

        mouseX += gui.getGuiLeft();
        mouseY += gui.getGuiTop();

        if (mouseX >= this.posX && mouseX <= this.posX + this.sizeX && mouseY >= this.posY && mouseY <= this.posY + this.sizeY) {
            return true;
        }
        return false;
    }

    public String getName() {

        return name;
    }

}
