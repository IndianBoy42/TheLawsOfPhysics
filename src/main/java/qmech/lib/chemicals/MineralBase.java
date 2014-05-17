package qmech.lib.chemicals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import qmech.lib.chemicals.registry.ChemicalDictionary;
import qmech.lib.chemicals.registry.MineralDictionary;

import com.google.common.collect.Sets;

public class MineralBase extends CompoundBase {
	
	Set<ElementStack> elements;
	public Set<ElementStack> getElements() {
		return elements;
	}

	public Set<RadicalBase> getRadicals() {
		return radicals;
	}

	public Set<MineralBase> getProcessed() {
		return processed;
	}

	Set<RadicalBase> radicals;
	
	Set<MineralBase> processed;

	public MineralBase(Set<ElementStack> elements, Set<RadicalBase> radicals, boolean masterSet) {
		List<IIon> ions = new ArrayList<IIon>();
		for (ElementStack ion : elements) {
			ions.add((IIon) ion);
		}
		for (RadicalBase ion : radicals) {
			ions.add((IIon) ion);
		}
		composition = ions;
		this.elements = elements;
		this.radicals = radicals;
		
		if (masterSet) {
			MineralDictionary.registerMineral(this);
			
			Set<Set<RadicalBase>> powerSet = Sets.powerSet(radicals);
			for (Set<RadicalBase> subset : powerSet) {
				processed.add(new MineralBase(elements, subset, false));
			}
		}
		ChemicalDictionary.addCompound(this);
	}

}
