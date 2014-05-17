package qmech.lib.chemicals;

import java.util.Arrays;
import java.util.List;

import qmech.lib.chemicals.registry.ChemicalDictionary;

public class CompoundBase {
	
	public String name;
	public List<IIon> composition;
	
	public CompoundBase (IIon ... parts) {
		composition = Arrays.asList(parts);
		
		ChemicalDictionary.addCompound(this);
	}
	
}
