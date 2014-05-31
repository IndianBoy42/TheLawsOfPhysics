package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidContainerRegistry;
import qmech.lib.objects.fluid.FluidBase;
import qmech.lib.objects.fluid.FluidContainerBase;
import qmech.mod.item.FluidBucket;
import qmech.mod.metals.EnumMetals;

import java.util.HashMap;
import java.util.Map;

class ModFluids {

    private static final int BUCKET_VOLUME = FluidContainerRegistry.BUCKET_VOLUME;
    private static FluidContainerBase cell;
    private static FluidBucket bucket;
    private static final Map<String, FluidBase> metalFluids = new HashMap<String, FluidBase>();

    public static void preInit() {
        bucket = new FluidBucket("bucket", ModCTabs.tabMetals);
        cell = new FluidContainerBase("cell", BUCKET_VOLUME, ModCTabs.tabMetals, false);

        registerMetals();
    }

    private static void registerMetals() {
        for (EnumMetals metal : EnumMetals.values()) {
            registerFluid("slurry", metal);
            registerFluid("molten", metal);
            registerFluid("cleanSlurry", metal);
            registerFluid("enrichedSlurry", metal);
        }
    }

    private static void registerFluid(String prefix, EnumMetals metals) {
        FluidBase fluid = new FluidBase(String.format("%s_%s", prefix, metals.name()), Material.lava, ModCTabs.tabMetals);
        metalFluids.put(String.format("%s%s", prefix, metals.name()), fluid);
        bucket.registerFluid(fluid);
        cell.registerFluid(fluid);
        return fluid;
    }

}
