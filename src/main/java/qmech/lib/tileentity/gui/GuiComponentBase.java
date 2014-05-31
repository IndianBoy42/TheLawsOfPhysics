package qmech.lib.tileentity.gui;

import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by anshuman on 17-05-2014.
 */
public abstract class GuiComponentBase {


    private int texW = 256;
    private int texH = 256;
    private final GuiBase gui;
    private ResourceLocation texture;
    private int posX;
    private int posY;
    private int sizeX;
    private int sizeY;
    private String name;

    private boolean visible = true;

    public GuiComponentBase(GuiBase gui, int posX, int posY) {

        this.gui = gui;
        this.posX = gui.getGuiLeft() + posX;
        this.posY = gui.getGuiTop() + posY;
    }

    public GuiComponentBase setPosition(int posX, int posY) {

        this.posX = this.gui.getGuiLeft() + posX;
        this.posY = this.gui.getGuiTop() + posY;
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

    public boolean isVisible() {

        return this.visible;
    }

    public GuiComponentBase setVisible(boolean visible) {

        this.visible = visible;
        return this;
    }

    public abstract void update();

    public abstract void draw();

    public void draw(int x, int y) {

        this.posX = x;
        this.posY = y;
        this.draw();
    }

    public abstract void addTooltip(List<String> list);

    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {

        this.gui.drawSizedTexturedModalRect(x, y, u, v, width, height, this.texW, this.texH);
    }

    public void handleMouseClicked(int x, int y, int mouseButton) {

    }

    public boolean intersectsWith(int mouseX, int mouseY) {

        mouseX += this.gui.getGuiLeft();
        mouseY += this.gui.getGuiTop();

        return mouseX >= this.posX && mouseX <= this.posX + this.sizeX && mouseY >= this.posY && mouseY <= this.posY + this.sizeY;
    }

    public String getName() {

        return this.name;
    }

    public GuiComponentBase setName(String name) {

        this.name = name;
        return this;
    }

}
