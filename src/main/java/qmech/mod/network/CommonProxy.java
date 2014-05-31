package qmech.mod.network;

import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.render.CustomRendererBase;

import java.util.HashMap;

public class CommonProxy {

    final HashMap<Class<? extends TileEntityBase>, CustomRendererBase> renderers = new HashMap<Class<? extends TileEntityBase>, CustomRendererBase>();

    public void preInit() {
        this.registerRenderers();
    }

    void registerRenderers() {

    }

    public void registerRenderer(Class<? extends TileEntityBase> teClass, CustomRendererBase renderer) {
        this.renderers.put(teClass, renderer);
    }

}
