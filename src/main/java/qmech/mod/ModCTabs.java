package qmech.mod;

import net.minecraft.init.Items;
import qmech.lib.objects.CreativeTabBase;

import java.util.HashMap;
import java.util.Map;

public class ModCTabs {

//    public static Map<String, CreativeTabBase> ctabs = new HashMap<String, CreativeTabBase>();

    public static CreativeTabBase tabMetals = new CreativeTabBase("Metals", Items.cookie);

	public static void preInit () {
        tabMetals.icon = ModItems.metalItems.get("ingot_Copper");
	}
	
}
