package lazy.helper.objects;

import java.util.List;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public class ToolTypeBase {
    public ToolTypeBase (String name, int harvestLevel, int durability, float efficiency, int damage, int enchantability, ItemStack material) {
        this.harvestLevel = harvestLevel;
        this.toolName = name;
        this.material = material;
        toolType = EnumHelper.addToolMaterial(name, harvestLevel, durability, efficiency, damage, enchantability);
    }
    
    ToolMaterial toolType;
    public ToolMaterial getToolType () {
        return toolType;
    }
    
    int harvestLevel;
    public int getHarvestLevel () {
        return harvestLevel;
    }
    
    String toolName;
    public String getToolName () {
        return toolName;
    }
    
    ItemStack material;
    public ItemStack getMaterial () {
        return material;
    }

    public static String[] shovelCraftingShape;
    public static String[] pickaxeCraftingShape;
    public static String[] axeCraftingShape;
    public static String[] hoeCraftingShape;
    public static String[] swordCraftingShape;
}
