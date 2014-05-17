package qmech.lib.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;
import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.gui.ModGUIHandler;
import qmech.lib.tileentity.render.CustomRendererBase;
import qmech.mod.ModBase;

/**
 * Created by anshuman on 17-05-2014.
 */
public class RegHelper {

    public static void registerRenderer(Class<? extends TileEntityBase> te, CustomRendererBase renderer) {
        ModBase.proxy.registerRenderer(te, renderer);
    }

    public static void registerGUI() {
    }

}
