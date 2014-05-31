package qmech.lib.tileentity.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import qmech.mod.ModBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anshuman on 17-05-2014.
 */
public class ModGUIHandler implements IGuiHandler {

    static {
        NetworkRegistry.INSTANCE.registerGuiHandler(ModBase.getInstance(), ModGUIHandler.instance);
    }
    private static final ModGUIHandler instance = new ModGUIHandler();
    private final Map<Integer, GuiHandlerBase> GuiMap = new HashMap<Integer, GuiHandlerBase>();

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        for (Map.Entry mapping : this.GuiMap.entrySet()) {
            if (mapping.getKey() == ((Integer) ID)) {
                return ((GuiHandlerBase) mapping.getValue()).getServer(player.inventory, (qmech.lib.tileentity.TileEntityBase) world.getTileEntity(x, y, z));
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        for (Map.Entry mapping : this.GuiMap.entrySet()) {
            if (mapping.getKey() == ((Integer) ID)) {
                return ((GuiHandlerBase) mapping.getValue()).getClient(player.inventory, (qmech.lib.tileentity.TileEntityBase) world.getTileEntity(x, y, z));
            }
        }
        return null;
    }
}
