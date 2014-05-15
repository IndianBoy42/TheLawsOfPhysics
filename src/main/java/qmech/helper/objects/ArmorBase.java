package qmech.helper.objects;

import java.lang.reflect.InvocationTargetException;

import cpw.mods.fml.common.registry.GameRegistry;
import qmech.mod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorBase extends ItemArmor {

	public ArmorBase(String intName, ArmorTypeBase armorType) {
		super(armorType.getArmorMaterial(), 0, 0);
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
	}
	
	public ArmorBase setCreativeTabs (CreativeTabs ctab) {
        this.setCreativeTab(ctab);
        return this;
    }
    
    public ItemBase setStackSize (int size) {
        return (ItemBase) this.setMaxStackSize(size);
    }
    
    public ArmorBase setInternalName (String name) {
        this.setUnlocalizedName(name);
        return this;
    }
    
    String publicName;
    public ArmorBase addName (String name) {
        publicName = name;
        return this;
    }
    public String getName () {
        return publicName;
    }
    
    public void registerItem () { 
        GameRegistry.registerItem(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
        //LanguageRegistry.addName(this, intName);
    }
    
    boolean hasGlow = false;
    public ArmorBase setGlows(boolean hasGlow){
        this.hasGlow = hasGlow;
        return this;
    }
    public boolean hasEffect (ItemStack stack) {
        return hasGlow;
    }
    
    EnumRarity textColor;
    public ArmorBase setTextColor (String color){
        class rarity {
            public EnumRarity getRarity (String color) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
                return (EnumRarity) rarity.class.getMethod(color).invoke(new rarity());
            }
            public EnumRarity white () {return EnumRarity.common;}
            public EnumRarity yellow () {return EnumRarity.uncommon;}
            public EnumRarity purple () {return EnumRarity.rare;}
            public EnumRarity blue () {return EnumRarity.epic;}
        }
        try {
            textColor = new rarity().getRarity(color);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }
    public EnumRarity getRarity () {
        return textColor;
    }

}
