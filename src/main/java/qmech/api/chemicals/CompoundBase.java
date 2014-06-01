package qmech.api.chemicals;

import qmech.api.chemicals.registry.ChemicalDictionary;

import java.util.Arrays;
import java.util.List;

public class CompoundBase {

    public String name;
    List<IIon> composition;

    public CompoundBase(IIon... parts) {
        this.composition = Arrays.asList(parts);

        ChemicalDictionary.addCompound(this);
    }

}
