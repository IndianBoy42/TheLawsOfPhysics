package qmech.api.chemicals;

import java.util.List;

import qmech.api.registry.ChemicalDictionary;

public class RadicalBase implements IIon {
	
	public String name;
	public List<ElementStack> composition;

	public RadicalBase(List<ElementStack> composition) {
		this.composition = composition;
		
		ChemicalDictionary.addRadical(this);
	}

	@Override
	public List<ElementStack> getElements() {
		// TODO Auto-generated method stub
		return composition;
	}

}
