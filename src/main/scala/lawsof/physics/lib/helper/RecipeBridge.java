package lawsof.physics.lib.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * Created by anshuman on 10-06-2014.
 */
public class RecipeBridge {
    public static void addShapedRecipe (ItemStack output, Object[] params) {
        GameRegistry.addShapedRecipe(output, params);
    }
}
