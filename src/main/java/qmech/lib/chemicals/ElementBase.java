package qmech.lib.chemicals;

import java.util.Arrays;
import java.util.List;

import qmech.lib.chemicals.registry.ChemicalDictionary;

public class ElementBase implements IIon {
	
	public String symbol;
	public String name;
	
	public ElementBase(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
		
		ChemicalDictionary.addElement(this);
	}

	@Override
	public List<ElementStack> getElements() {
		// TODO Auto-generated method stub
		return Arrays.asList(new ElementStack(this, 1));
	}
	
}
