package qmech.lib.tileentity.gui.components.element;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.IFluidTank;
import qmech.lib.tileentity.gui.GuiBase;
import qmech.lib.tileentity.render.RenderHelper;
import qmech.lib.util.StringHelper;
import qmech.mod.Reference;

import java.util.List;

public class ElementFluidTank extends ElementBase {

    private static final ResourceLocation DEFAULT_TEXTURE = new ResourceLocation(Reference.MOD_ID, Reference.TEXTURES_GUI + "FluidTank.png");
    private static final int DEFAULT_SCALE = 60;

    private final IFluidTank tank;
    private int gaugeType;

    public ElementFluidTank(GuiBase gui, int posX, int posY, IFluidTank tank) {

        super(gui, posX, posY);
        this.tank = tank;

        this.texture = DEFAULT_TEXTURE;
        this.texW = 64;
        this.texH = 64;

        this.sizeX = 16;
        this.sizeY = DEFAULT_SCALE;
    }

    public ElementFluidTank(GuiBase gui, int posX, int posY, IFluidTank tank, String texture) {

        super(gui, posX, posY);
        this.tank = tank;

        this.texture = new ResourceLocation(texture);
        this.texW = 64;
        this.texH = 64;

        this.sizeX = 16;
        this.sizeY = DEFAULT_SCALE;
    }

    public ElementFluidTank setGauge(int gaugeType) {

        this.gaugeType = gaugeType;
        return this;
    }

    @Override
    public void draw() {

        if (!this.visible) {
            return;
        }
        int amount = this.getScaled();

        this.gui.drawFluid(this.posX, this.posY + this.sizeY - amount, this.tank.getFluid(), this.sizeX, amount);
        RenderHelper.bindTexture(this.texture);
        this.drawTexturedModalRect(this.posX, this.posY, 32 + this.gaugeType * 16, 1, this.sizeX, this.sizeY);
    }

    @Override
    public void addTooltip(List<String> list) {

        if (this.tank.getFluid() != null && this.tank.getFluidAmount() > 0) {
            list.add(StringHelper.getFluidName(this.tank.getFluid()));
        }
        list.add("" + this.tank.getFluidAmount() + " / " + this.tank.getCapacity() + " mB");
    }

    @Override
    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        return false;
    }

    int getScaled() {

        return this.tank.getFluidAmount() * this.sizeY / this.tank.getCapacity();
    }

}
