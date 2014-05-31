package qmech.lib.tileentity.gui.components.element;

import net.minecraftforge.fluids.FluidStack;
import qmech.lib.tileentity.gui.GuiBase;

public class ElementFluid extends ElementBase {

    private FluidStack fluid;

    public ElementFluid(GuiBase gui, int posX, int posY) {

        super(gui, posX, posY);
    }

    public ElementFluid setFluid(FluidStack fluid) {

        this.fluid = fluid;
        return this;
    }

    @Override
    public void draw() {

        if (!this.visible) {
            return;
        }
        this.gui.drawFluid(this.posX, this.posY, this.fluid, this.sizeX, this.sizeY);
    }

}
