package qmech.lib.objects;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import qmech.lib.util.LoggingHelper;

/**
 * Created by anshuman on 17-05-2014.
 */
public class FluidBase extends Fluid {
    public static FluidBase config (FluidBase fluid, int temp, int density, int viscosity, int luminescence) {
        LoggingHelper.getInstance().debug(String.format("Configuring Fluid (%s) with : \n" +
                        "temperature = %s \n" +
                        "density = %s \n" +
                        "viscosity = %s \n" +
                        "luminosity = %s",
                fluid.fluidName,
                temp, density, viscosity, luminescence
        ));

        fluid.temperature = temp;
        fluid.density = density;
        fluid.viscosity =viscosity;
        fluid.luminosity = luminescence;

        if (density < 0) {
            fluid.isGaseous = true;
        }

        return fluid;
    }

    public static FluidBase config (FluidBase fluid, FluidInfo info) {
        return config(fluid, info.temp, info.density, info.viscosity, info.luminosity);
    }

    public FluidBase(String fluidName, Material material, CreativeTabBase ctab) {
        super(fluidName);
        FluidRegistry.registerFluid(this);
        this.block = new FluidBlockBase(this, material, ctab);

        LoggingHelper.getInstance().debug(String.format("Creating Basic Fluid : %s", fluidName));
    }

    public static class FluidInfo {
        public int luminosity = 0;
        public int viscosity = 1000;
        public int density = 1000;
        public int temp = 295;

        public FluidInfo() {}

        public FluidInfo(int luminosity, int viscosity, int density, int temp) {
            this.luminosity = luminosity;
            this.viscosity = viscosity;
            this.density = density;
            this.temp = temp;
        }
    }
}
