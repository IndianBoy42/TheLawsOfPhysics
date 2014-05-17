package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import qmech.lib.objects.BlockBase;
import qmech.lib.tileentity.TEBlockBase;
import qmech.mod.block.TestBlock;

public class ModBlocks {

    static BlockBase testBlock = new BlockBase(Material.iron, "testBlock");

    static TEBlockBase testMachine = new TestBlock(Material.iron, "testMachine");

	public static void preInit () throws InstantiationException, IllegalAccessException {
        testBlock = BlockBase.config(testBlock, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
        testMachine = TEBlockBase.config(testMachine, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
	}
}
