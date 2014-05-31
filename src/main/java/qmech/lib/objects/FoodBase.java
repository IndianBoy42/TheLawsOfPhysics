package qmech.lib.objects;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import qmech.mod.Reference;

import java.lang.reflect.InvocationTargetException;

public class FoodBase extends ItemFood {

    private EnumRarity textColor;

    public FoodBase(int id, int hunger, boolean isMeat, String intName) {
        super(hunger, isMeat);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setInternalName(intName);
        this.setMaxStackSize(64);
        // TODO Auto-generated constructor stub
    }

    public FoodBase(int id, int hunger, String intName) {
        super(hunger, false);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setInternalName(intName);
        this.setMaxStackSize(64);
        // TODO Auto-generated constructor stub
    }

    public FoodBase setPotionEffect(Potion effect, int duration, int amplifier, float chancePerCent) {
        this.setPotionEffect(effect.id, duration, amplifier - 1, chancePerCent / 100);
        return this;
    }

    public FoodBase setAlwaysEatable() {
        this.setAlwaysEdible();
        return this;
    }

    void setInternalName(String name) {
        this.setUnlocalizedName(name);
    }

    public void registerItem() {
        GameRegistry.registerItem(this, Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
        //LanguageRegistry.addName(this, intName);
    }

    public FoodBase setTextColor(String color) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        class rarity {
            public EnumRarity getRarity(String color) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                return (EnumRarity) rarity.class.getMethod(color).invoke(new rarity());
            }

            public EnumRarity white() {
                return EnumRarity.common;
            }

            public EnumRarity yellow() {
                return EnumRarity.uncommon;
            }

            public EnumRarity purple() {
                return EnumRarity.rare;
            }

            public EnumRarity blue() {
                return EnumRarity.epic;
            }
        }
        this.textColor = new rarity().getRarity(color);
        return this;
    }

    public EnumRarity getRarity() {
        return this.textColor;
    }
}