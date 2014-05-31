package qmech.lib.chemicals.registry;

import net.minecraft.item.ItemStack;
import qmech.lib.chemicals.ElementBase;
import qmech.lib.chemicals.ElementStack;
import qmech.lib.chemicals.MineralBase;
import qmech.lib.chemicals.RadicalBase;

import java.util.*;

public class MineralDictionary {
    private static Map<ElementBase, List<MineralBase>> ElemToMineral;

    private static List<MineralBase> getMineralsForElem(ElementBase elem) {
        List<MineralBase> mineralsForElem = ElemToMineral.get(elem);
        if (mineralsForElem != null) {
            return mineralsForElem;
        }
        return null;
    }

    public static List<MineralBase> getMineralsForOre(String name) {
        return getMineralsForElem(MetalDictionary.getElemForOre(name));
    }

    public static List<MineralBase> getMineralsForOre(ItemStack ore) {
        return getMineralsForElem(MetalDictionary.getElemForOre(ore));
    }

    public static Map<ElementBase, List<MineralBase>> getElemToMineral() {
        return ElemToMineral;
    }

    public static void registerMineral(MineralBase mineral) {
        for (ElementStack stack : mineral.getElements()) {
            if (ElemToMineral.containsKey(stack.elem)) {
                ElemToMineral.get(stack.elem).add(mineral);
            } else {
                ElemToMineral.put(stack.elem, Arrays.asList(mineral));
            }
            ChemicalDictionary.addMetal(stack.elem);
        }
        for (RadicalBase anion : mineral.getRadicals()) {
            ChemicalDictionary.addAnion(anion);
        }
    }

    public static Set<MineralBase> getAllMinerals() {
        Set<MineralBase> minerals = new HashSet<MineralBase>();
        for (List<MineralBase> mineralss : ElemToMineral.values()) {
            minerals.addAll(mineralss);
        }
        return minerals;
    }

}
