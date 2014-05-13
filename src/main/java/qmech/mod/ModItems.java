package qmech.mod;


import net.minecraft.creativetab.CreativeTabs;
import qmech.helper.objects.ItemBase;

public class ModItems {

    static ItemBase testItem;

	public static void preInit () {
		testItem = ItemBase.add("testItem", CreativeTabs.tabMisc, 64);
	}

}
