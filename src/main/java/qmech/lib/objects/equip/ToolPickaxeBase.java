package qmech.lib.objects.equip;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.util.LoggingHelper;
import qmech.lib.util.RecipeHelper;
import qmech.mod.Reference;

import java.util.List;

/**
 * Created by anshuman on 18-05-2014.
 */
public class ToolPickaxeBase extends ItemPickaxe {
    private final String suffix = "Pickaxe";

    public ToolPickaxeBase(ToolTypeBase toolType, CreativeTabBase ctab) {
        super(toolType.getToolMaterial());
        this.setTextureName(String.format("%s:%s_%s", Reference.MOD_ID, toolType.getToolName(), this.suffix));
        this.setUnlocalizedName(String.format("%s_%s", toolType.getToolName(), this.suffix));
        this.setCreativeTab(ctab);
        //this.setMaxStackSize(1);

        LoggingHelper.getInstance().debug(String.format("Adding tool : %s_%s", toolType.getToolName(), this.suffix));

        RecipeHelper.shapedRecipe(new ItemStack(this), ToolTypeBase.pickaxeCraftingShape, 'x', toolType.getCraftMaterial(), 's', Items.stick);

        GameRegistry.registerItem(this, String.format("%s_%s", toolType.getToolName(), this.suffix));
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag) {
        list.add("HP: " + (itemstack.getMaxDamage() - itemstack.getItemDamage()));
    }
}
