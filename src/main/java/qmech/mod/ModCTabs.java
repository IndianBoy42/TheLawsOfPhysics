package qmech.mod;

import net.minecraft.init.Items;
import qmech.lib.objects.CreativeTabBase;

class ModCTabs {

//    public static Map<String, CreativeTabBase> ctabs = new HashMap<String, CreativeTabBase>();

    public static final CreativeTabBase tabMetals = new CreativeTabBase("Metals", Items.cookie);

    public static void preInit() {
        tabMetals.icon = ModItems.metalItems.get("ingot_Copper");
    }

}
