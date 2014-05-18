package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidContainerRegistry;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.objects.FluidBase;
import qmech.lib.objects.FluidContainerBase;
import qmech.lib.objects.ItemBase;
import qmech.mod.item.FluidBucket;
import qmech.mod.metals.EnumMetals;

import java.util.HashMap;
import java.util.Map;

public class ModFluids {

    public static FluidContainerBase cell;
    public static FluidBucket bucket;

    public static final int BUCKET_VOLUME = FluidContainerRegistry.BUCKET_VOLUME;
	
	public static void preInit () {
        bucket = new FluidBucket("bucket", ModCTabs.tabMetals);

        registerMetals();

        cell = new FluidContainerBase("cell", BUCKET_VOLUME, ModCTabs.tabMetals);
	}

    public static void registerMetals() {
        for (EnumMetals metal: EnumMetals.values()) {
            registerFluid("slurry", metal);
            registerFluid("molten", metal);
            registerFluid("cleanSlurry", metal);
            registerFluid("enrichedSlurry", metal);
        }
    }

    public static Map<String, FluidBase> metalFluids = new HashMap<String, FluidBase>();

    public static FluidBase registerFluid (String prefix, EnumMetals metals) {
        FluidBase fluid = new FluidBase(String.format("%s_%s", prefix, metals.name()), Material.iron, ModCTabs.tabMetals);
        metalFluids.put(String.format("%s%s", prefix, metals.name()), fluid);
        bucket.registerFluid(fluid);
        return fluid;
    }
	
}
