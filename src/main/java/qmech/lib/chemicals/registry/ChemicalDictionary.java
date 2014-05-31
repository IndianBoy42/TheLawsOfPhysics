package qmech.lib.chemicals.registry;

import qmech.lib.chemicals.CompoundBase;
import qmech.lib.chemicals.ElementBase;
import qmech.lib.chemicals.MineralBase;
import qmech.lib.chemicals.RadicalBase;

import java.util.Set;

public class ChemicalDictionary {

    private static Set<ElementBase> metals;
    private static Set<ElementBase> elements;
    private static Set<RadicalBase> anions;
    private static Set<RadicalBase> radicals;
    private static Set<CompoundBase> compounds;

    public static void addMetal(ElementBase elem) {
        if (doesntExist(metals, elem)) {
            metals.add(elem);
        }
        addElement(elem);
    }

    public static void addElement(ElementBase elem) {
        if (doesntExist(elements, elem)) {
            elements.add(elem);
        }
    }

    public static void addAnion(RadicalBase rad) {
        if (doesntExist(anions, rad)) {
            anions.add(rad);
        }
        addRadical(rad);
    }

    public static void addRadical(RadicalBase rad) {
        if (doesntExist(radicals, rad)) {
            radicals.add(rad);
        }
    }

    public static void addCompound(CompoundBase comp) {
        if (doesntExist(compounds, comp)) {
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

    private static <T> boolean doesntExist(Set<T> set, T t) {
        return !set.contains(t);
    }

}
