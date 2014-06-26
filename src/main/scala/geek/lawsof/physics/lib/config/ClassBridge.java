package geek.lawsof.physics.lib.config;

import net.minecraft.client.gui.GuiScreen;

/**
 * Created by anshuman on 27-06-2014.
 */
public class ClassBridge {
    public static Class<? extends GuiScreen> getConfigGUIClass = ConfigGUI.class;
}
