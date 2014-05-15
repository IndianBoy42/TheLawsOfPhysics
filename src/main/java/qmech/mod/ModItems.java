package qmech.mod;


import net.minecraft.creativetab.CreativeTabs;
import qmech.helper.objects.ItemBase;

public class ModItems {

    static ItemBase testItem = new ItemBase("testItem");

	public static void preInit () {
		testItem = ItemBase.config(testItem, CreativeTabs.tabMisc, 64);
	}

}
