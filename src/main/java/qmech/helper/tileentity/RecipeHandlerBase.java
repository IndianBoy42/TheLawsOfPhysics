package qmech.helper.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public abstract class RecipeHandlerBase {
	public abstract ItemStack[] getOutput (ItemStack[] input);
	
	public static String oreDictName (ItemStack stack) {
		int ID = OreDictionary.getOreID(stack);
		return OreDictionary.getOreName(ID);
	}
}
