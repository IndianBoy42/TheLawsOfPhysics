package qmech.lib.objects.equip;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import qmech.lib.objects.CreativeTabBase;

import java.util.ArrayList;
import java.util.List;

public class ArmorTypeBase {
    private static final String[] chestplateCraftingShape = new String[]{"x x", "xxx", "xxx"};
    private static final String[] leggingsCraftingShape = new String[]{"xxx", "x x", "x x"};
    private static final String[] bootsCraftingShape = new String[]{"x x", "x x"};
    private static final String[] helmetCraftingShape = new String[]{"xxx", "x x"};
    public static final List<String[]> craftingRecipes = new ArrayList<String[]>();
    static {
        craftingRecipes.add(helmetCraftingShape);
        craftingRecipes.add(chestplateCraftingShape);
        craftingRecipes.add(leggingsCraftingShape);
        craftingRecipes.add(bootsCraftingShape);
    }
    private final ArmorBase[] armorPieces = new ArmorBase[4];
    private final ArmorMaterial armorType;
    private int armorIndex;
    private final String armorName;
    private final ItemStack material;

    public ArmorTypeBase(String name, int durability, int[] reductionAmounts, int enchantability, ItemStack material) {
        this.armorType = EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
        //armorPiece =
        this.armorName = name;
        this.material = material;
    }
    public ArmorTypeBase(String name, ArmorInfo info, ItemStack mat) {
        this.armorType = EnumHelper.addArmorMaterial(name, info.durability, info.reductionAmounts, info.enchantability);
        //armorPiece =
        this.armorName = name;
        this.material = mat;
    }

    public ArmorMaterial getArmorMaterial() {
        return this.armorType;
    }

    public int getArmorIndex() {
        return this.armorIndex;
    }

    public String getArmorName() {
        return this.armorName;
    }

    public ItemStack getMaterial() {
        return this.material;
    }

    public void registerArmorSet(CreativeTabBase ctab) {
        for (int i = 0; i < 4; i++) {
            this.armorPieces[i] = new ArmorBase(this, i, ctab);
        }
    }

    public static class ArmorInfo {
        public int durability = 10;
        public int[] reductionAmounts = new int[]{2, 4, 3, 2};
        public int enchantability = 2;

        public ArmorInfo() {
        }

        public ArmorInfo(int durability, int[] reductionAmounts, int enchantability) {
            this.durability = durability;
            this.reductionAmounts = reductionAmounts;
            this.enchantability = enchantability;
        }

        public static ArmorInfo ironArmor() {
            ArmorMaterial iron = ArmorMaterial.IRON;

            return new ArmorInfo(iron.getDurability(0) / 11,
                    new int[]{
                            iron.getDamageReductionAmount(0),
                            iron.getDamageReductionAmount(1),
                            iron.getDamageReductionAmount(2),
                            iron.getDamageReductionAmount(3)
                    },
                    iron.getEnchantability()
            );
        }
    }

}
