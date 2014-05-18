package qmech.lib.objects;

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

    public ArmorTypeBase (String name, ItemStack mat, ArmorInfo info) {
        armorType = EnumHelper.addArmorMaterial(name, info.durability, info.reductionAmounts, info.enchantability);
        //armorIndex =
        this.armorName = name;
        this.material = mat;
    }

    public static class ArmorInfo {
        public int durability = 200;
        public int[] reductionAmounts = new int[]{2, 4, 3, 2};
        public int enchantability = 2;

        public ArmorInfo() {}

        public ArmorInfo(int durability, int[] reductionAmounts, int enchantability) {
            this.durability = durability;
            this.reductionAmounts = reductionAmounts;
            this.enchantability = enchantability;
        }
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
    
    public static String[] chestplateCraftingShape = new String[]{"x x", "xxx", "xxx"};
    public static String[] leggingsCraftingShape = new String[]{"xxx", "x x", "x x"};
    public static String[] bootsCraftingShape = new String[]{"x x", "x x"};
    public static String[] helmetCraftingShape = new String[]{"xxx", "x x"};
    
}
