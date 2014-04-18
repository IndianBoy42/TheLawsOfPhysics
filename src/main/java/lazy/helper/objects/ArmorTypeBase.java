package lazy.helper.objects;

import java.util.List;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorTypeBase {
    public ArmorTypeBase (String name, int durability, int[] reductionAmounts, int enchantability, ItemStack material) {
        armorType = EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
        //armorIndex =
        this.armorName = name;
        this.material = material;
    }
    
    ArmorMaterial armorType;
    public ArmorMaterial getArmorMaterial () {
        return armorType;
    }
    
    int armorIndex;
    public int getArmorIndex () {
        return armorIndex;
    }
    
    String armorName;
    public String getArmorName () {
        return armorName;
    }
    
    ItemStack material;
    public ItemStack getMaterial() {
        return material;
    }
    
    public static String[] chestplateCraftingShape;
    public static String[] leggingsCraftingShape;
    public static String[] bootsCraftingShape;
    public static String[] helmetCraftingShape;
    
}
