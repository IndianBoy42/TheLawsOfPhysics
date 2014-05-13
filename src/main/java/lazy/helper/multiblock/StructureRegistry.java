package lazy.helper.multiblock;

import java.util.HashMap;
import java.util.Map;

public class StructureRegistry {
	
	static Map<Integer, StructureDef> structs = new HashMap<Integer, StructureDef>();
	static Map<Integer, UpdateHandler> tickHandlers = new HashMap<Integer, UpdateHandler>();
	
	public static void registerMultiblock (int id, StructureDef def, UpdateHandler tick) {
		structs.put(id, def);
		tickHandlers.put(id, tick);
	}
	
	public static StructureDef getStructureDef(int id) {
		return structs.get(id);
	}
	
	public static UpdateHandler getTickHandler(int id) {
		return tickHandlers.get(id);
	}

}
