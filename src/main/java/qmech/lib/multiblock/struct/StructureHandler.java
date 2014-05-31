package qmech.lib.multiblock.struct;

import qmech.lib.multiblock.MultiBlockPart;

public interface StructureHandler {

    public abstract boolean checkValidity(MultiBlockPart... blocks);

}
