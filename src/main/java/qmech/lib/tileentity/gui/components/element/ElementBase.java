package qmech.lib.tileentity.gui.components.element;

import net.minecraft.util.ResourceLocation;
import qmech.lib.tileentity.gui.GuiBase;

import java.util.List;

/**
 * Base class for a modular GUI element. Has self-contained rendering methods and a link back to the {@link GuiBase} it is a part of.
 *
 * @author King Lemming
 */
public abstract class ElementBase {

    int texW = 256;
    int texH = 256;
    final GuiBase gui;
    ResourceLocation texture;
    int posX;
    int posY;
    int sizeX;
    int sizeY;
    private String name;

    boolean visible = true;

    ElementBase(GuiBase gui, int posX, int posY) {

        this.gui = gui;
        this.posX = gui.getGuiLeft() + posX;
        this.posY = gui.getGuiTop() + posY;
    }

    public ElementBase setPosition(int posX, int posY) {

        this.posX = this.gui.getGuiLeft() + posX;
        this.posY = this.gui.getGuiTop() + posY;
        return this;
    }

    void setSize(int sizeX, int sizeY) {

        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    void setTexture(String texture, int texW, int texH) {

        this.texture = new ResourceLocation(texture);
        this.texW = texW;
        this.texH = texH;
    }

    public boolean isVisible() {

        return this.visible;
    }

    public ElementBase setVisible(boolean visible) {

        this.visible = visible;
        return this;
    }

    public abstract void update();

    protected abstract void draw();

    public void draw(int x, int y) {

        this.posX = x;
        this.posY = y;
        this.draw();
    }

    public void addTooltip(List<String> list) {

    }

    void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {

        this.gui.drawSizedTexturedModalRect(x, y, u, v, width, height, this.texW, this.texH);
    }

    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        return false;
    }

    boolean intersectsWith(int mouseX, int mouseY) {

        mouseX += this.gui.getGuiLeft();
        mouseY += this.gui.getGuiTop();

        return mouseX >= this.posX && mouseX <= this.posX + this.sizeX && mouseY >= this.posY && mouseY <= this.posY + this.sizeY;
    }

    String getName() {

        return this.name;
    }

    void setName(String name) {

        this.name = name;
    }

}
