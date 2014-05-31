package qmech.mod;


import net.minecraft.item.ItemStack;
import qmech.lib.objects.equip.ArmorTypeBase;
import qmech.lib.objects.equip.ToolTypeBase;
import qmech.mod.metals.EnumMetals;

import java.util.ArrayList;
import java.util.List;

class ModEquipment {

    private static final List<ToolTypeBase> metalTools = new ArrayList<ToolTypeBase>();
    private static final List<ArmorTypeBase> metalArmor = new ArrayList<ArmorTypeBase>();

    public static void preInit() {
        registerMetals();
    }

    private static void registerMetals() {
        for (EnumMetals metal : EnumMetals.values()) {
            if (metal.moddedMetal()) {
                ToolTypeBase toolType = new ToolTypeBase(
                        metal.name(), metal.getToolInfo(),
                        new ItemStack(ModItems.metalItems.get(String.format("ingot_%s", metal.name()))));
                toolType.registerToolSet(ModCTabs.tabMetals);
                metalTools.add(toolType);

                ArmorTypeBase armorType = new ArmorTypeBase(
                        metal.name(), metal.getArmorInfo(),
                        new ItemStack(ModItems.metalItems.get(String.format("ingot_%s", metal.name()))));
                armorType.registerArmorSet(ModCTabs.tabMetals);
                metalArmor.add(armorType);
            }

            ToolTypeBase.ToolInfo reinforcedToolType = metal.getToolInfo();
            reinforcedToolType.durability *= 8;
            reinforcedToolType.efficiency *= 2;
            reinforcedToolType.damage += 5;
            reinforcedToolType.enchantability -= 2;
            reinforcedToolType.harvestLevel += 1;

            ToolTypeBase reinforcedTool = new ToolTypeBase(
                    String.format("reinforced%s", metal.name()),
                    reinforcedToolType,
                    new ItemStack(ModItems.metalItems.get(String.format("plate_%s", metal.name()))));
            reinforcedTool.registerToolSet(ModCTabs.tabMetals);
            metalTools.add(reinforcedTool);

            ArmorTypeBase.ArmorInfo reinforcedArmorType = metal.getArmorInfo();
            reinforcedArmorType.enchantability -= 2;
            reinforcedArmorType.durability *= 8;
            for (int i = 0; i < 4; i++) {
                reinforcedArmorType.reductionAmounts[i] += 5;
            }

            ArmorTypeBase reinforcedArmor = new ArmorTypeBase(
                    String.format("reinforced%s", metal.name()),
                    reinforcedArmorType,
                    new ItemStack(ModItems.metalItems.get(String.format("plate_%s", metal.name()))));
            reinforcedArmor.registerArmorSet(ModCTabs.tabMetals);
            metalArmor.add(reinforcedArmor);
        }
    }

}
