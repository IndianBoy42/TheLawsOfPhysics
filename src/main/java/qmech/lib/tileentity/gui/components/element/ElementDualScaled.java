package qmech.lib.tileentity.gui.components.element;

import qmech.lib.tileentity.gui.GuiBase;
import qmech.lib.tileentity.render.RenderHelper;

public class ElementDualScaled extends ElementBase {

    private int quantity;
    private int mode;
    private boolean background = true;

    public ElementDualScaled(GuiBase gui, int posX, int posY) {

        super(gui, posX, posY);
    }

    public ElementDualScaled setBackground(boolean background) {

        this.background = background;
        return this;
    }

    public ElementDualScaled setMode(int mode) {

        this.mode = mode;
        return this;
    }

    public ElementDualScaled setQuantity(int quantity) {

        this.quantity = quantity;
        return this;
    }

    @Override
    public void draw() {

        if (!this.visible) {
            return;
        }
        RenderHelper.bindTexture(this.texture);

        if (this.background) {
            this.drawTexturedModalRect(this.posX, this.posY, 0, 0, this.sizeX, this.sizeY);
        }
        switch (this.mode) {
            case 0:
                // vertical bottom -> top
                this.drawTexturedModalRect(this.posX, this.posY + this.sizeY - this.quantity, this.sizeX, this.sizeY - this.quantity, this.sizeX, this.quantity);
                return;
            case 1:
                // horizontal left -> right
                this.drawTexturedModalRect(this.posX, this.posY, this.sizeX, 0, this.quantity, this.sizeY);
                return;
            case 2:
                // horizontal right -> left
                this.drawTexturedModalRect(this.posX + this.sizeX - this.quantity, this.posY, this.sizeX + this.sizeX - this.quantity, 0, this.quantity, this.sizeY);
                return;
        }
    }

}
