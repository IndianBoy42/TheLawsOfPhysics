package qmech.lib.objects.equip;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import qmech.lib.objects.CreativeTabBase;

import java.util.ArrayList;
import java.util.List;

public class ArmorTypeBase {
    public ArmorTypeBase (String name, int durability, int[] reductionAmounts, int enchantability, ItemStack material) {
        armorType = EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
        //armorPiece =
        this.armorName = name;
        this.material = material;
    }

    public ArmorTypeBase (String name, ArmorInfo info, ItemStack mat) {
        armorType = EnumHelper.addArmorMaterial(name, info.durability, info.reductionAmounts, info.enchantability);
        //armorPiece =
        this.armorName = name;
        this.material = mat;
    }

    public static class ArmorInfo {
        public int durability = 10;
        public int[] reductionAmounts = new int[]{2, 4, 3, 2};
        public int enchantability = 2;

        public ArmorInfo() {}

        public ArmorInfo(int durability, int[] reductionAmounts, int enchantability) {
            this.durability = durability;
            this.reductionAmounts = reductionAmounts;
            this.enchantability = enchantability;
        }

        public static ArmorInfo ironArmor () {
            ArmorMaterial iron = ArmorMaterial.IRON;

            return new ArmorInfo(iron.getDurability(0)/11,
                    new int[] {
                        iron.getDamageReductionAmount(0),
                        iron.getDamageReductionAmount(1),
                        iron.getDamageReductionAmount(2),
                        iron.getDamageReductionAmount(3)
                    },
                    iron.getEnchantability());
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

    public static List<String[]> craftingRecipes = new ArrayList<String[]>();
    static {
        craftingRecipes.add(helmetCraftingShape);
        craftingRecipes.add(chestplateCraftingShape);
        craftingRecipes.add(leggingsCraftingShape);
        craftingRecipes.add(bootsCraftingShape);
    }

    public ArmorBase[] armorPieces = new ArmorBase[4];

    public void registerArmorSet(CreativeTabBase ctab) {
        for (int i=0; i<4; i++) {
            armorPieces[i] = new ArmorBase(this, i, ctab);
        }
    }

}
