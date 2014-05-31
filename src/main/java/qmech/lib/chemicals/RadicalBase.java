package qmech.lib.chemicals;

import qmech.lib.chemicals.registry.ChemicalDictionary;

import java.util.List;

public class RadicalBase implements IIon {

    public String name;
    private final List<ElementStack> composition;

    public RadicalBase(List<ElementStack> composition) {
        this.composition = composition;

        ChemicalDictionary.addRadical(this);
    }

    @Override
    public List<ElementStack> getElements() {
        // TODO Auto-generated method stub
        return this.composition;
    }

}
