package qmech.lib.tileentity.gui.components.element;

import qmech.lib.tileentity.gui.GuiBase;
import qmech.lib.tileentity.render.RenderHelper;
import qmech.lib.util.StringHelper;

import java.util.List;

public class ElementButton extends ElementBase {

    private int sheetX;
    private int sheetY;
    private int hoverX;
    private int hoverY;
    private int disabledX = 0;
    private int disabledY = 0;
    private boolean disabled = false;
    private boolean tooltipLocalized = false;
    private String tooltip;

    public ElementButton(GuiBase gui, int posX, int posY, String name, int sheetX, int sheetY, int hoverX, int hoverY, int sizeX, int sizeY, String texture) {

        super(gui, posX, posY);
        this.setName(name);
        this.setSize(sizeX, sizeY);
        this.setTexture(texture, this.texW, this.texH);
        this.sheetX = sheetX;
        this.sheetY = sheetY;
        this.hoverX = hoverX;
        this.hoverY = hoverY;
    }

    public ElementButton(GuiBase gui, int posX, int posY, String name, int sheetX, int sheetY, int hoverX, int hoverY, int disabledX, int disabledY, int sizeX,
                         int sizeY, String texture) {

        super(gui, posX, posY);
        this.setName(name);
        this.setSize(sizeX, sizeY);
        this.setTexture(texture, this.texW, this.texH);
        this.sheetX = sheetX;
        this.sheetY = sheetY;
        this.hoverX = hoverX;
        this.hoverY = hoverY;
        this.disabledX = disabledX;
        this.disabledY = disabledY;
    }

    public ElementButton clearToolTip() {

        this.tooltip = null;
        return this;
    }

    public ElementButton setToolTip(String tooltip) {

        this.tooltip = tooltip;
        return this;
    }

    public ElementButton setToolTipLocalized(boolean localized) {

        this.tooltipLocalized = localized;
        return this;
    }

    @Override
    public void draw() {

        RenderHelper.bindTexture(this.texture);
        if (!this.disabled) {
            if (this.intersectsWith(this.gui.getMouseX(), this.gui.getMouseY())) {

                this.drawTexturedModalRect(this.posX, this.posY, this.hoverX, this.hoverY, this.sizeX, this.sizeY);
            } else {
                this.drawTexturedModalRect(this.posX, this.posY, this.sheetX, this.sheetY, this.sizeX, this.sizeY);
            }
        } else {
            this.drawTexturedModalRect(this.posX, this.posY, this.disabledX, this.disabledY, this.sizeX, this.sizeY);
        }
    }

    @Override
    public void addTooltip(List<String> list) {

        if (this.tooltip != null) {
            if (this.tooltipLocalized) {
                list.add(this.tooltip);
            } else {
                list.add(StringHelper.localize(this.tooltip));
            }
        }
    }

    @Override
    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        if (!this.disabled) {
            this.gui.handleElementButtonClick(this.getName(), mouseButton);
            return true;
        }
        return false;
    }

    public void setSheetX(int pos) {

        this.sheetX = pos;
    }

    public void setSheetY(int pos) {

        this.sheetY = pos;
    }

    public void setHoverX(int pos) {

        this.hoverX = pos;
    }

    public void setHoverY(int pos) {

        this.hoverY = pos;
    }

    public void setActive() {

        this.disabled = false;
    }

    public void setDisabled() {

        this.disabled = true;
    }

}
