package qmech.lib.multiblock.struct;

import qmech.lib.multiblock.UpdateHandler;

import java.util.HashMap;
import java.util.Map;

public class StructureRegistry {
	
	static Map<Integer, StructureHandler> structs = new HashMap<Integer, StructureHandler>();
	static Map<Integer, UpdateHandler> tickHandlers = new HashMap<Integer, UpdateHandler>();

    static int count = 0;
	
	public static int registerMultiblock (StructureHandler def, UpdateHandler tick) {
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
