package qmech.api.chemicals;

import java.util.Arrays;
import java.util.List;

import qmech.api.registry.ChemicalDictionary;

public class CompoundBase {
	
	public String name;
	public List<IIon> composition;
	
	public CompoundBase (IIon ... parts) {
		composition = Arrays.asList(parts);
		
		ChemicalDictionary.addCompound(this);
	}
	
}
