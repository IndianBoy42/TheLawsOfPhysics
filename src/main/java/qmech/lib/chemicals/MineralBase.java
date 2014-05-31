package qmech.lib.chemicals;

import com.google.common.collect.Sets;
import qmech.lib.chemicals.registry.ChemicalDictionary;
import qmech.lib.chemicals.registry.MineralDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MineralBase extends CompoundBase {

    private final Set<ElementStack> elements;
    private final Set<RadicalBase> radicals;
    private Set<MineralBase> processed;

    private MineralBase(Set<ElementStack> elements, Set<RadicalBase> radicals, boolean masterSet) {
        List<IIon> ions = new ArrayList<IIon>();
        for (ElementStack ion : elements) {
            ions.add((IIon) ion);
        }
        for (RadicalBase ion : radicals) {
            ions.add(ion);
        }
        this.composition = ions;
        this.elements = elements;
        this.radicals = radicals;

        if (masterSet) {
            MineralDictionary.registerMineral(this);

            Set<Set<RadicalBase>> powerSet = Sets.powerSet(radicals);
            for (Set<RadicalBase> subset : powerSet) {
                this.processed.add(new MineralBase(elements, subset, false));
            }
        }
        ChemicalDictionary.addCompound(this);
    }

    public Set<ElementStack> getElements() {
        return this.elements;
    }

    public Set<RadicalBase> getRadicals() {
        return this.radicals;
    }

    public Set<MineralBase> getProcessed() {
        return this.processed;
    }

}
