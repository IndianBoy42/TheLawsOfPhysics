package qmech.helper.objects;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import test.core.ref.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolBase extends ItemTool {

    public ToolBase(String intName) {
        super(float, toolMaterial, Set);
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
    }
    
    public ToolBase setCreativeTabs (CreativeTabs ctab) {
        this.setCreativeTab(ctab);
        return this;
    }
    
    public ToolBase setStackSize (int size) {
        return (ToolBase) this.setMaxStackSize(size);
    }
    
    public ToolBase setInternalName (String name) {
        this.setUnlocalizedName(name);
        return this;
    }
    
    String publicName;
    public ToolBase addName (String name) {
        publicName = name;
        return this;
    }
    public String getName () {
        return publicName;
    }
    
    public void registerItem () { 
        GameRegistry.registerItem(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
        //LanguageRegistry.addName(this, name);
    }
    
    boolean hasGlow = false;
    public ToolBase setGlows(boolean hasGlow){
        this.hasGlow = hasGlow;
        return this;
    }
    public boolean hasEffect (ItemStack stack) {
        return hasGlow;
    }
    
    EnumRarity textColor;
    public ToolBase setTextColor (String color){
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
