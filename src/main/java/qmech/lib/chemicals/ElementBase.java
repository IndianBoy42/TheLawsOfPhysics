package qmech.lib.chemicals;

import qmech.lib.chemicals.registry.ChemicalDictionary;

import java.util.Arrays;
import java.util.List;

public class ElementBase implements IIon {

    private final String symbol;
    private final String name;

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
