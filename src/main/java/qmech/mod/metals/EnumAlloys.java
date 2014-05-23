package qmech.mod.metals;

import qmech.lib.objects.BlockBase;
import qmech.lib.objects.equip.ArmorTypeBase;
import qmech.lib.objects.equip.ToolTypeBase;
import qmech.lib.objects.fluid.FluidBase;

/**
 * Created by anshuman on 23-05-2014.
 */
public enum EnumAlloys {

    Invar {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo();
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo();
        }

        @Override
        public AlloyMixInfo getAlloyMixInfo() {
            return new AlloyMixInfo();
        }

        @Override
        public AlloyCraftInfo[] getAlloyCraftInfo() {
            return AlloyCraftInfo.values();
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

    public abstract AlloyMixInfo getAlloyMixInfo();

    public abstract AlloyCraftInfo[] getAlloyCraftInfo();

    public abstract ArmorTypeBase.ArmorInfo getArmorInfo();

    public abstract ToolTypeBase.ToolInfo getToolInfo();

    public static class AlloyMixInfo {
        public int Xratio = 1;
        public int Yratio = 1;

        public EnumMetals Xmetal;
        public EnumMetals Ymetal;

        public AlloyMixInfo() {}

        public AlloyMixInfo(int xratio, EnumMetals xmetal, int yratio, EnumMetals ymetal) {
            Xratio = xratio;
            Yratio = yratio;
            Xmetal = xmetal;
            Ymetal = ymetal;
        }
    }
    
    public static enum  AlloyCraftInfo {
        DustCrafting,
        IngotCrafting,
        SolidAlloySmelter,
        FluidAlloySmelter;
    }

}
