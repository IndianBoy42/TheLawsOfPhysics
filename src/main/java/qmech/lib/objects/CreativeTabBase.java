package qmech.lib.objects;

import qmech.mod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabBase extends CreativeTabs {
	
	public static CreativeTabBase add (String label, Item iconIndex) {
		String name = Reference.MOD_NAME + " | " + label;
		CreativeTabBase ctab = new CreativeTabBase(name, iconIndex);
		return ctab;
	}

	public CreativeTabBase(String tabLabel, Item icon) {
		super(CreativeTabs.getNextID(), tabLabel);
		this.icon = icon;
	}
	
	public Item icon;
	public Item getTabIconItem () {
		return icon;
	}

}
