package qmech.lib.tileentity.gui.components.element;

import qmech.lib.tileentity.gui.GuiBase;
import qmech.lib.tileentity.render.RenderHelper;

/**
 * Basic element which can render an arbitrary texture.
 *
 * @author King Lemming
 */
public class ElementSimple extends ElementBase {

    private int texU = 0;
    private int texV = 0;

    public ElementSimple(GuiBase gui, int posX, int posY) {

        super(gui, posX, posY);
    }

    public ElementSimple setTextureOffsets(int u, int v) {

        this.texU = u;
        this.texV = v;
        return this;
    }

    @Override
    public void draw() {

        if (!this.visible) {
            return;
        }
        RenderHelper.bindTexture(this.texture);
        this.drawTexturedModalRect(this.posX, this.posY, this.texU, this.texV, this.sizeX, this.sizeY);
    }

}
