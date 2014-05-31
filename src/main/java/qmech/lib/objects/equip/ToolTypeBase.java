package qmech.lib.objects.equip;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.util.LoggingHelper;

public class ToolTypeBase {
    public static final String[] shovelCraftingShape = new String[]{"x", "s", "s"};
    public static final String[] pickaxeCraftingShape = new String[]{"xxx", " s ", " s "};
    public static final String[] axeCraftingShape = new String[]{"xx", "xs", " s"};
    public static final String[] hoeCraftingShape = new String[]{"xx", " s", " s"};
    public static final String[] swordCraftingShape = new String[]{"x", "x", "s"};
    private ToolPickaxeBase pickaxe;
    private ToolShovelBase shovel;
    private ToolAxeBase axe;
    private ToolSwordBase sword;
    private ToolHoeBase hoe;
    private final ToolMaterial toolType;
    private final int harvestLevel;
    private final String toolName;
    private final ItemStack material;
    public ToolTypeBase(String name, int harvestLevel, int durability, float efficiency, int damage, int enchantability, ItemStack material) {
        this.harvestLevel = harvestLevel;
        this.toolName = name;
        this.material = material;
        this.toolType = EnumHelper.addToolMaterial(name, harvestLevel, durability, efficiency, damage, enchantability);
        this.toolType.customCraftingMaterial = material.getItem();

        LoggingHelper.getInstance().debug(String.format("Creating ToolMaterial %s with values : \n" +
                        "harvestLevel = %s\n" +
                        "durability = %s\n" +
                        "efficiency = %s\n" +
                        "damage = %s\n" +
                        "enchantability = %s",
                this.toolName, harvestLevel, durability, efficiency, damage, enchantability
        ));
    }
    public ToolTypeBase(String name, ToolInfo info, ItemStack material) {
        this.harvestLevel = info.harvestLevel;
        this.toolName = name;
        this.material = material;
        this.toolType = EnumHelper.addToolMaterial(name, info.harvestLevel, info.durability, info.efficiency, info.damage, info.enchantability);
        this.toolType.customCraftingMaterial = material.getItem();

        LoggingHelper.getInstance().debug(String.format("Creating ToolMaterial %s with values : \n" +
                        "harvestLevel = %s\n" +
                        "durability = %s\n" +
                        "efficiency = %s\n" +
                        "damage = %s\n" +
                        "enchantability = %s",
                this.toolName, this.harvestLevel, info.durability, info.efficiency, info.damage, info.enchantability
        ));
    }

    public ToolMaterial getToolMaterial() {
        return this.toolType;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public String getToolName() {
        return this.toolName;
    }

    public ItemStack getCraftMaterial() {
        return this.material;
    }

    public void registerToolSet(CreativeTabBase ctab) {
        this.pickaxe = new ToolPickaxeBase(this, ctab);
        this.shovel = new ToolShovelBase(this, ctab);
        this.axe = new ToolAxeBase(this, ctab);
        this.sword = new ToolSwordBase(this, ctab);
        this.hoe = new ToolHoeBase(this, ctab);
    }

    public static class ToolInfo {
        public int harvestLevel = 1;
        public int durability = 100;
        public float efficiency = 2.0F;
        public float damage = 2;
        public int enchantability = 2;

        public ToolInfo() {
        }

        public ToolInfo(int harvestLevel, int durability, float efficiency, float damage, int enchantability) {
            this.harvestLevel = harvestLevel;
            this.durability = durability;
            this.efficiency = efficiency;
            this.damage = damage;
            this.enchantability = enchantability;
        }

        public static ToolInfo ironTools() {
            ToolMaterial iron = ToolMaterial.IRON;

            return new ToolInfo(
                    iron.getHarvestLevel(), iron.getMaxUses(), iron.getEfficiencyOnProperMaterial(), iron.getDamageVsEntity(), iron.getEnchantability());
        }
    }

}
