package qmech.lib.objects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import qmech.mod.Reference;

public class CreativeTabBase extends CreativeTabs {

    public Item icon;

    public CreativeTabBase(String tabLabel, Item icon) {
        super(CreativeTabs.getNextID(), tabLabel);
        this.icon = icon;
    }

    public static CreativeTabBase add(String label, Item iconIndex) {
        String name = Reference.MOD_NAME + " | " + label;
        return new CreativeTabBase(name, iconIndex);
    }

    public Item getTabIconItem() {
        return this.icon;
    }

}
