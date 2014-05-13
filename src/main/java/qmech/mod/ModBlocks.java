package qmech.mod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import qmech.helper.objects.BlockBase;

public class ModBlocks {
	public static class Blocks{
        static BlockBase testBlock;
	}

	public static class Ores{
	}

	public static void preInit () {
        Blocks.testBlock = BlockBase.add("testBlock", Material.iron, CreativeTabs.tabBlock, 1.0f, 1.0f, "pickaxe", 1);
	}
}
