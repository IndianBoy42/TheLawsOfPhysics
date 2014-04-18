package qmech.api.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.minecraftforge.fluids.Fluid;
import qmech.api.chemicals.ElementStack;
import qmech.api.chemicals.MineralBase;
import qmech.api.registry.MetalDictionary;

public class BlastFurnaceRecipeHandler { 
	
	public List<Fluid> getOutput (MineralBase mineral) {
		List<Fluid> fluids = new ArrayList<Fluid>();
		for (ElementStack metal : mineral.getElements()) {
			fluids.add(MetalDictionary.getMoltenMetalForElem(metal.elem));
		}
		return fluids;
	}

}
