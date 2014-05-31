package qmech.lib.util;

import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.render.CustomRendererBase;
import qmech.mod.ModBase;

/**
 * Created by anshuman on 17-05-2014.
 */
class RegHelper {

    public static void registerRenderer(Class<? extends TileEntityBase> te, CustomRendererBase renderer) {
        ModBase.proxy.registerRenderer(te, renderer);
    }

    public static void registerGUI() {
    }

}
