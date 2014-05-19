package qmech.lib.objects.equip;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.util.RecipeHelper;
import qmech.mod.Reference;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorBase extends ItemArmor {

    public static String[] suffixes = new String[]
            {
                    "helmet", "chestplate", "leggings", "boots"
            };

    public int armorPiece;

	public ArmorBase(ArmorTypeBase armorType, int armorIndex, CreativeTabBase ctab) {
		super(armorType.getArmorMaterial(), 0, armorIndex);
        String intName = String.format("%s_%s", armorType.getArmorName(), suffixes[armorIndex]);
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
        this.setCreativeTab(ctab);

        armorPiece = armorIndex;

        RecipeHelper.shapedRecipe(new ItemStack(this), ArmorTypeBase.craftingRecipes.get(armorIndex), 'x', armorType.getMaterial());

        GameRegistry.registerItem(this, intName);
	}
    
    public ArmorBase setInternalName (String name) {
        this.setUnlocalizedName(name);
        return this;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag)
    {
        list.add("HP: " + (itemstack.getMaxDamage() - itemstack.getItemDamage()));
    }
    
    public void registerItem () { 
        GameRegistry.registerItem(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() instanceof ArmorBase) {
            ArmorBase armor = (ArmorBase) stack.getItem();
            int layer = 1;
            if (armor.armorPiece == 2) {
                layer = 2;
            }
            return String.format("%s:textures/models/armor/%s_%s.png", Reference.MOD_ID, armor.getArmorMaterial().name(), layer);
        }
        return null;
    }

}
