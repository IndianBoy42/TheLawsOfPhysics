package lazy.helper.handlers;

import java.util.HashMap;
import java.util.Map;

import lazy.helper.objects.ItemBase;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class FuelHandler implements IFuelHandler {
	
	public FuelHandler () {
		GameRegistry.registerFuelHandler(this);
	}
	
	Map<ItemStack, Integer> fuels = new HashMap<ItemStack, Integer>();
	
	public void addFuel (ItemStack fuel, int time) {
		fuels.put(fuel, time);
	}

	@Override
	public int getBurnTime(ItemStack fuelStack) {
		Integer time = fuels.get(fuelStack);
		return (time != null) ? time : 0;
	}

}
