package qmech.lib.objects.equip;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.util.LoggingHelper;

public class ToolTypeBase {
    public ToolTypeBase (String name, int harvestLevel, int durability, float efficiency, int damage, int enchantability, ItemStack material) {
        this.harvestLevel = harvestLevel;
        this.toolName = name;
        this.material = material;
        toolType = EnumHelper.addToolMaterial(name, harvestLevel, durability, efficiency, damage, enchantability);
        toolType.customCraftingMaterial = material.getItem();

        LoggingHelper.getInstance().debug(String.format("Creating ToolMaterial %s with values : \n" +
                        "harvestLevel = %s\n" +
                        "durability = %s\n" +
                        "efficiency = %s\n" +
                        "damage = %s\n" +
                        "enchantability = %s",
                toolName, harvestLevel, durability, efficiency, damage, enchantability
        ));
    }

    public ToolTypeBase (String name, ToolInfo info, ItemStack material) {
        this.harvestLevel = info.harvestLevel;
        this.toolName = name;
        this.material = material;
        toolType = EnumHelper.addToolMaterial(name, info.harvestLevel, info.durability, info.efficiency, info.damage, info.enchantability);
        toolType.customCraftingMaterial = material.getItem();

        LoggingHelper.getInstance().debug(String.format("Creating ToolMaterial %s with values : \n" +
                        "harvestLevel = %s\n" +
                        "durability = %s\n" +
                        "efficiency = %s\n" +
                        "damage = %s\n" +
                        "enchantability = %s",
                toolName, harvestLevel, info.durability, info.efficiency, info.damage, info.enchantability
        ));
    }


    public static class ToolInfo {
        public int harvestLevel = 1;
        public int durability = 100;
        public float efficiency = 2.0F;
        public int damage = 2;
        public int enchantability = 2;

        public ToolInfo() {}

        public ToolInfo(int harvestLevel, int durability, float efficiency, int damage, int enchantability) {
            this.harvestLevel = harvestLevel;
            this.durability = durability;
            this.efficiency = efficiency;
            this.damage = damage;
            this.enchantability = enchantability;
        }
    }
    
    ToolMaterial toolType;
    public ToolMaterial getToolMaterial() {
        return toolType;
    }
    
    int harvestLevel;
    public int getHarvestLevel () {
        return harvestLevel;
    }
    
    String toolName;
    public String getToolName () {
        return toolName;
    }
    
    ItemStack material;
    public ItemStack getCraftMaterial() {
        return material;
    }

    public static String[] shovelCraftingShape = new String[]{"x", "s", "s"};
    public static String[] pickaxeCraftingShape = new String[]{"xxx", " s ", " s "};
    public static String[] axeCraftingShape = new String[]{"xx","xs", " s"};
    public static String[] hoeCraftingShape = new String[]{"xx", " s", " s"};
    public static String[] swordCraftingShape = new String[]{"x", "x", "s"};

    public ToolPickaxeBase pickaxe;
    public ToolShovelBase shovel;
    public ToolAxeBase axe;
    public ToolSwordBase sword;
    public ToolHoeBase hoe;

    public void registerToolSet (CreativeTabBase ctab) {
        pickaxe = new ToolPickaxeBase(this, ctab);
        shovel = new ToolShovelBase(this, ctab);
        axe = new ToolAxeBase(this, ctab);
        sword = new ToolSwordBase(this, ctab);
        hoe = new ToolHoeBase(this, ctab);
    }

}
