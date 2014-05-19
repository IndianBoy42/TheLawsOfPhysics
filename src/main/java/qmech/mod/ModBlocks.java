package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import qmech.lib.objects.BlockBase;
import qmech.lib.tileentity.TEBlockBase;
import qmech.lib.util.WorldGenerator;
import qmech.mod.metals.EnumMetals;
import qmech.mod.block.TestBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {

    static BlockBase testBlock = new BlockBase(Material.iron, "testBlock");

    static TEBlockBase testMachine = new TestBlock(Material.iron, "testMachine");

	public static void preInit () throws InstantiationException, IllegalAccessException {
        testBlock = BlockBase.config(testBlock, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
        testMachine = TEBlockBase.config(testMachine, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);

        registerMetals();
    }

    public static void registerMetals () {
        for (EnumMetals metal: EnumMetals.values()) {
            BlockBase.BlockInfo gravelOreInfo = metal.getBlockInfo(); gravelOreInfo.toolType = "shovel";
            BlockBase block = registerBlock("block", metal);
            BlockBase ore = registerBlock("ore", metal);
            BlockBase netherOre = registerBlock("netherOre", metal);
            BlockBase enderOre = registerBlock("enderOre", metal);
            BlockBase bricks = registerBlock("bricks", metal);
            BlockBase gravelOre = registerBlock("gravelOre", metal, gravelOreInfo);
        }

        for (BlockBase ore : getBlockFromType("ore")) {
            ModBase.getInstance().worldGen.add(ore, metalsToBlocks.get(ore).getOreGenInfo());
        }
    }

    public static Map<String, BlockBase> metalBlocks = new HashMap<String, BlockBase>();
    public static Map<BlockBase, String> typesToBlocks = new HashMap<BlockBase, String>();
    public static Map<BlockBase, EnumMetals> metalsToBlocks = new HashMap<BlockBase, EnumMetals>();

    public static BlockBase registerBlock (String prefix, EnumMetals metal) {
        return registerBlock(prefix, metal, metal.getBlockInfo());
    }
    public static BlockBase registerBlock (String prefix, EnumMetals metal, BlockBase.BlockInfo info) {
        BlockBase block = BlockBase.config(new BlockBase(Material.iron, String.format("%s_%s", prefix, metal.name())), ModCTabs.tabMetals, info);
        metalBlocks.put(String.format("%s_%s", prefix, metal.name()), block);
        typesToBlocks.put(block, prefix);
        metalsToBlocks.put(block, metal);
        return block;
    }

    public static List<BlockBase> getBlockFromType(String prefix) {
        List<BlockBase> blocks = new ArrayList<BlockBase>();
        for (Map.Entry<BlockBase, String> entry : typesToBlocks.entrySet()) {
            if (entry.getValue() == prefix) {
                blocks.add(entry.getKey());
            }
        }
        return blocks;
    }
}
