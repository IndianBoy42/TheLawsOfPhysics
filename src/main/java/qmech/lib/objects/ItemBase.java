package qmech.lib.objects;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import qmech.lib.util.LoggingHelper;
import qmech.mod.Reference;

import java.lang.reflect.InvocationTargetException;

public class ItemBase extends Item {

    private static final LoggingHelper logger = LoggingHelper.getInstance();
    private EnumRarity textColor;

    public ItemBase(String intName) {
        super();
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
    }

    public static ItemBase config(ItemBase item, CreativeTabs ctab, int stackSize) {
        logger.debug(String.format("Configuring Item (%s) with : \n" +
                        ">>> CreativeTab : %s\n" +
                        ">>> StackSize : %s",
                item.getUnlocalizedName(),
                ctab, stackSize
        ));
        item.setCreativeTabs(ctab);
        item.setStackSize(stackSize);
        item.registerItem();
        return item;
    }

    void setCreativeTabs(CreativeTabs ctab) {
        this.setCreativeTab(ctab);
    }

    void setStackSize(int size) {
        return (ItemBase) this.setMaxStackSize(size);
    }

    void setInternalName(String name) {
        this.setUnlocalizedName(name);
    }

    void registerItem() {
        GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
    }

    public ItemBase setTextColor(String color) {
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
        try {
            this.textColor = new rarity().getRarity(color);
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

    public EnumRarity getRarity() {
        return this.textColor;
    }
}
