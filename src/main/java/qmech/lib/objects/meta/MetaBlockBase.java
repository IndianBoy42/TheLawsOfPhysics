package qmech.lib.objects.meta;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import qmech.mod.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaBlockBase extends Block {
	
	public static class ItemBlockBase extends ItemBlock {
		
	    public ItemBlockBase(MetaBlockBase metaBlock, String intName) {
	        super(metaBlock);
	        this.setTextureName(Reference.MOD_ID + ":" + intName);
	        this.setInternalName(intName);
	        this.setHasSubtypes(true);
	    }
	    
	    public ItemBlockBase setCreativeTabs (CreativeTabs ctab) {
	        this.setCreativeTab(ctab);
	        return this;
	    }
	    
	    public ItemBlockBase setStackSize (int size) {
	        return (ItemBlockBase) this.setMaxStackSize(size);
	    }
	    
	    public ItemBlockBase setInternalName (String name) {
	        this.setUnlocalizedName(name);
	        return this;
	    }
	    public String getUnlocalizedName (ItemStack stack) {
	    	return getUnlocalizedName() + "." + subNames.get(stack.getItemDamage());
	    }
	    
	    public int getMetadata (int dmg) {
	    	return dmg;
	    }
	    
	    public void registerItem () { 
	        GameRegistry.registerItem(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	        //LanguageRegistry.addName(this, intName);
	    }
	    
	    boolean hasGlow = false;
	    public ItemBlockBase setGlows(boolean hasGlow){
	        this.hasGlow = hasGlow;
	        return this;
	    }
	    public boolean hasEffect (ItemStack stack) {
	        return hasGlow;
	    }
	    
	    EnumRarity textColor;
	    public ItemBlockBase setTextColor (String color){
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

    public MetaBlockBase(Material material, String intName) {
        super(material);
        this.setBlockTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
    }
    
    public MetaBlockBase setStrength (float hardness, float blastResistance) {
        this.setHardness(hardness);
        this.setResistance(blastResistance);
        return this;
    }
    
    public MetaBlockBase setCreativeTabs (CreativeTabs creativeTab) {
        this.setCreativeTab(creativeTab);
        return this;
    }
    
    public MetaBlockBase setInternalName(String name){
        this.setBlockName(name);
        return this;
    }
	
	public void addSubBlock (
			//IIcon icon, 
			String name) {
		//icons.add(icon);
		subNames.add(name);
		subBlocks++;
	}
	
	static List<String> subNames = new ArrayList<String>();
	int subBlocks = 0;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks (ItemBlock item, CreativeTabs tab, List blockList) {
		for (int i=0; i<subBlocks; i++) {
			blockList.add(new ItemStack(item, 1, i));
		}
	}
	
	/*
	List<IIcon> icons;
	public IIcon getIcon (int side, int meta) {
		return icons.get(meta);
	}
	*/
    
    public void registerBlock () {
        GameRegistry.registerBlock(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
    }
    
    public void setHarvestLevel(String toolType, int toolLevel){
        this.setHarvestLevel(toolType, toolLevel);
    }
}
