package qmech.mod.network;

import cpw.mods.fml.client.registry.ClientRegistry;

import java.util.Map;

public class ClientProxy extends CommonProxy {

	public void preInit() {
		registerRenderers();
	}
	public void init() {
		
	}
	public void postInit() {
		
	}

    /*
	public void registerRenderers () {
        for (Map.Entry binding : renderers.entrySet())
            ClientRegistry.bindTileEntitySpecialRenderer( (Class) binding.getKey(), (CustomRendererBase) binding.getKey());
	}
	*/

}
