package qmech.mod.metals;

import qmech.lib.objects.equip.ArmorTypeBase;
import qmech.lib.objects.BlockBase;
import qmech.lib.objects.fluid.FluidBase;
import qmech.lib.objects.equip.ToolTypeBase;
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
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Tin {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Lead {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Silver {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Aluminum {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Titanium {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Platinum {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Nickel {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Osmium {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Tungsten {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Chromium {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return false;
        }
    },
    Cobalt {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return true;
        }
    },
    Iron {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return BlockBase.BlockInfo.ironBlock();
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
        }

        @Override
        public WorldGenerator.GenStats getOreGenInfo() {
            return new WorldGenerator.GenStats(50, 80, 8, 8);
        }

        @Override
        public ArmorTypeBase.ArmorInfo getArmorInfo() {
            return ArmorTypeBase.ArmorInfo.ironArmor();
        }

        @Override
        public ToolTypeBase.ToolInfo getToolInfo() {
            return ToolTypeBase.ToolInfo.ironTools();
        }

        @Override
        public boolean vanilla() {
            return true;
        }
    },
    Gold {
        @Override
        public BlockBase.BlockInfo getBlockInfo() {
            return new BlockBase.BlockInfo(1.0F, 1.0F, "pickaxe", 1);
        }

        @Override
        public FluidBase.FluidInfo getFluidInfo() {
            return new FluidBase.FluidInfo(0, 1000, 1000, 3000);
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

        @Override
        public boolean vanilla() {
            return true;
        }
    };

    public abstract BlockBase.BlockInfo getBlockInfo();

    public abstract FluidBase.FluidInfo getFluidInfo();

    public abstract WorldGenerator.GenStats getOreGenInfo();

    public abstract ArmorTypeBase.ArmorInfo getArmorInfo();

    public abstract ToolTypeBase.ToolInfo getToolInfo();

    public abstract boolean vanilla();

}
