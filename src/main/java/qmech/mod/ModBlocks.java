package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import qmech.helper.objects.BlockBase;
import qmech.helper.tileentity.TEBlockBase;

public class ModBlocks {

    static BlockBase testBlock = new BlockBase(Material.iron, "testBlock");

    //static TEBlockBase testMachine = new TestTEBlock(Material.iron, "testMachine");

	public static void preInit () throws InstantiationException, IllegalAccessException {
        testBlock = BlockBase.config(testBlock, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
        //testMachine = TEBlockBase.config(testMachine, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
	}
}
