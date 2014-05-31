package qmech.lib.multiblock.struct;

import qmech.lib.multiblock.UpdateHandler;

import java.util.HashMap;
import java.util.Map;

public class StructureRegistry {

    private static final Map<Integer, StructureHandler> structs = new HashMap<Integer, StructureHandler>();
    private static final Map<Integer, UpdateHandler> tickHandlers = new HashMap<Integer, UpdateHandler>();

    private static int count = 0;

    public static int registerMultiblock(StructureHandler def, UpdateHandler tick) {
        int ID = count;
        count++;
        structs.put(ID, def);
        tickHandlers.put(ID, tick);
        return ID;
    }

    public static StructureHandler getStructureDef(int id) {
        return structs.get(id);
    }

    public static UpdateHandler getTickHandler(int id) {
        return tickHandlers.get(id);
    }

}
