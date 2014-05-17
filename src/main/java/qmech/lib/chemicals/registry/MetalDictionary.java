package qmech.lib.chemicals.registry;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import qmech.lib.chemicals.ElementBase;

public class MetalDictionary {
	
	static Map<String, ElementBase> IngotToElem;
	static Map<String, ElementBase> OreToElem;
	static Map<ElementBase, Fluid> MoltenMetalToElem;
	
	public static ElementBase getElemForOre (String name) {
		ElementBase elemForOre = OreToElem.get(name.substring(3));
		if (elemForOre != null) {
			return elemForOre;
		}
		return null;
	}
	public static ElementBase getElemForOre (ItemStack ore) {
		return getElemForOre(getOreName(ore));
	}
	
	public static ElementBase getElemForIngot (String name) {
		ElementBase elemForOre = OreToElem.get(name.substring(3));
		if (elemForOre != null) {
			return elemForOre;
		}
		return null;
	}
	public static ElementBase getElemForIngot (ItemStack ore) {
		return getElemForOre(getOreName(ore));
	}
	
	public static Fluid getMoltenMetalForElem (ElementBase elem) {
		return MoltenMetalToElem.get(elem);
	}
	
	public static String getOreName (ItemStack stack) {
		return OreDictionary.getOreName(OreDictionary.getOreID(stack));
	}
	
	public static void registerOre (String oreName, ElementBase elem) {
		MetalDictionary.OreToElem.put(oreName, elem);
		ChemicalDictionary.addMetal(elem);
	}
	public static void registerIngot (String oreName, ElementBase elem) {
		MetalDictionary.IngotToElem.put(oreName, elem);
		ChemicalDictionary.addMetal(elem);
	}
	public static void registerMoltenMetal (Fluid moltenMetal, ElementBase elem) {
		MetalDictionary.MoltenMetalToElem.put(elem, moltenMetal);
		ChemicalDictionary.addMetal(elem);
	}
	public static Map<String, ElementBase> getIngotToElemDictionary() {
		return IngotToElem;
	}
	public static Map<String, ElementBase> getOreToElemDictionary() {
		return OreToElem;
	}
	public static Map<ElementBase, Fluid> getMoltenMetalToElemDictionary() {
		return MoltenMetalToElem;
	}

}
