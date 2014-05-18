package qmech.mod;


import net.minecraft.creativetab.CreativeTabs;
import qmech.lib.objects.BlockBase;
import qmech.lib.objects.ItemBase;
import qmech.mod.metals.EnumMetals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    static ItemBase testItem = new ItemBase("testItem");

	public static void preInit () {
		testItem = ItemBase.config(testItem, CreativeTabs.tabMisc, 64);

        registerMetals();
	}

    public static void registerMetals () {
        for (EnumMetals metal: EnumMetals.values()) {
            ItemBase ingot = registerItem("ingot", metal);
            ItemBase brick = registerItem("brick", metal);
            ItemBase nugget = registerItem("nugget", metal);
            ItemBase plate = registerItem("plate", metal);
            ItemBase dust = registerItem("dust", metal);
            ItemBase powder = registerItem("powder", metal);
            ItemBase clump = registerItem("clump", metal);
        }
    }

    public static Map<String, ItemBase> metalItems = new HashMap<String, ItemBase>();
    public static Map<ItemBase, String> typesToItems = new HashMap<ItemBase, String>();
    public static Map<ItemBase, EnumMetals> metalsToItems = new HashMap<ItemBase, EnumMetals>();

    public static ItemBase registerItem (String prefix, EnumMetals metal) {
        ItemBase item = ItemBase.config(new ItemBase(String.format("%s_%s", prefix, metal.name())), ModCTabs.tabMetals, 64);
        metalItems.put(String.format("%s_%s", prefix, metal.name()), item);
        typesToItems.put(item, prefix);
        metalsToItems.put(item, metal);
        return item;
    }

    public static List<ItemBase> getItemFromType(String prefix) {
        List<ItemBase> items = new ArrayList<ItemBase>();
        for (Map.Entry<ItemBase, String> entry : typesToItems.entrySet()) {
            if (entry.getValue() == prefix) {
                items.add(entry.getKey());
            }
        }
        return items;
    }
}
