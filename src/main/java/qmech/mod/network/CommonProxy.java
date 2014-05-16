package qmech.mod.network;

import qmech.helper.tileentity.TileEntityBase;
import qmech.helper.tileentity.render.CustomRendererBase;

import java.util.HashMap;

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
