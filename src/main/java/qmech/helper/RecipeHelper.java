package qmech.helper;


import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {
    public static void shapedRecipe (ItemStack output, Object... recipePars) {
        GameRegistry.addRecipe(output, recipePars);
    }
    
    public static void shapelessRecipe (ItemStack output, Object... recipePars) {
        GameRegistry.addShapelessRecipe(output, recipePars);
    }
    
    public static void smeltingRecipe (ItemStack output, ItemStack input, float xp) {
    	GameRegistry.addSmelting(input, output, xp);
    }
}
