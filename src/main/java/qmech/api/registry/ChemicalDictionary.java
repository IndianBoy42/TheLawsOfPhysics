package qmech.api.registry;

import java.util.Set;

import qmech.api.chemicals.CompoundBase;
import qmech.api.chemicals.ElementBase;
import qmech.api.chemicals.MineralBase;
import qmech.api.chemicals.RadicalBase;

public class ChemicalDictionary {
	
	static Set<ElementBase> metals;
	static Set<ElementBase> elements;
	static Set<RadicalBase> anions;
	static Set<RadicalBase> radicals;
	static Set<CompoundBase> compounds;
	
	public static void addMetal (ElementBase elem) {
		if (!checkExists(metals, elem)) {
			metals.add(elem);
		}
		addElement(elem);
	}
	
	public static void addElement (ElementBase elem) {
		if (!checkExists(elements, elem)) {
			elements.add(elem);
		}
	}
	
	public static void addAnion (RadicalBase rad) {
		if (!checkExists(anions, rad)) {
			anions.add(rad);
		}
		addRadical(rad);
	}
	
	public static void addRadical (RadicalBase rad) {
		if (!checkExists(radicals, rad)) {
			radicals.add(rad);
		}
	}
	
	public static void addCompound (CompoundBase comp) {
		if (!checkExists(compounds, comp)) {
			compounds.add(comp);
		}
	}
	
	public static Set<ElementBase> getMetals() {
		return metals;
	}

	public static Set<ElementBase> getElements() {
		return elements;
	}

	public static Set<RadicalBase> getAnions() {
		return anions;
	}

	public static Set<RadicalBase> getRadicals() {
		return radicals;
	}

	public static Set<CompoundBase> getCompounds() {
		return compounds;
	}
	
	public static Set<MineralBase> getMinerals() {
		return MineralDictionary.getAllMinerals();
	}

	public static <T> boolean checkExists (Set<T> set, T t) {
		return set.contains(t);
	}

}
