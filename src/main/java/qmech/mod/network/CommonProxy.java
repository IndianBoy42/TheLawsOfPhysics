package qmech.mod.network;

import qmech.helper.tileentity.CustomRendererBase;
import qmech.helper.tileentity.TileEntityBase;

import java.util.HashMap;
import java.util.Map;

public class CommonProxy {
	
	public void preInit() {
		registerRenderers();
	}
	public void init() {
		
	}
	public void postInit() {
		
	}

	public void registerRenderers () {
		
	}

    HashMap<Class<? extends TileEntityBase>, CustomRendererBase> renderers = new HashMap<Class<? extends TileEntityBase>, CustomRendererBase>();
    public void registerRenderer(Class<? extends TileEntityBase> teClass, CustomRendererBase renderer) {
        renderers.put(teClass, renderer);
    }

}
