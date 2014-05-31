package qmech.lib.util;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class FuelHandler implements IFuelHandler {

    private final Map<ItemStack, Integer> fuels = new HashMap<ItemStack, Integer>();

    public FuelHandler() {
        GameRegistry.registerFuelHandler(this);
    }

    public void addFuel(ItemStack fuel, int time) {
        this.fuels.put(fuel, time);
    }

    @Override
    public int getBurnTime(ItemStack fuelStack) {
        Integer time = this.fuels.get(fuelStack);
        return (time != null) ? time : 0;
    }

}
