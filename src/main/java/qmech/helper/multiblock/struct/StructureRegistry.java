package qmech.helper.multiblock.struct;

import qmech.helper.multiblock.UpdateHandler;
import qmech.helper.multiblock.struct.StructureDef;

import java.util.HashMap;
import java.util.Map;

public class StructureRegistry {
	
	static Map<Integer, StructureDef> structs = new HashMap<Integer, StructureDef>();
	static Map<Integer, UpdateHandler> tickHandlers = new HashMap<Integer, UpdateHandler>();

    static int count = 0;
	
	public static void registerMultiblock (StructureDef def, UpdateHandler tick) {
		structs.put(count, def);
		tickHandlers.put(count, tick);
	}
	
	public static StructureDef getStructureDef(int id) {
		return structs.get(id);
	}
	
	public static UpdateHandler getTickHandler(int id) {
		return tickHandlers.get(id);
	}

}
