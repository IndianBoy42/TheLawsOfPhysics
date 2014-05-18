package qmech.mod.metals;

import qmech.lib.objects.ArmorTypeBase;
import qmech.lib.objects.BlockBase;
import qmech.lib.objects.FluidBase;
import qmech.lib.objects.ToolTypeBase;
import qmech.lib.util.WorldGenerator;

/**
 * Created by anshuman on 17-05-2014.
 */
public enum EnumMetals {

    Copper {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 295);
        }

        @Override
        public WorldGenerator.GenStats getOreGenInfo() {
            return new WorldGenerator.GenStats(50, 80, 8, 8);
        }

        @Override
        public ArmorTypeBase.ArmorInfo getArmorInfo() {
            return new ArmorTypeBase.ArmorInfo();
        }

        @Override
        public ToolTypeBase.ToolInfo getToolInfo() {
            return new ToolTypeBase.ToolInfo();
        }
    };

    public abstract BlockBase.BlockInfo getBlockInfo();

    public abstract FluidBase.FluidInfo getFluidInfo();

    public abstract WorldGenerator.GenStats getOreGenInfo();

    public abstract ArmorTypeBase.ArmorInfo getArmorInfo();

    public abstract ToolTypeBase.ToolInfo getToolInfo();

}
