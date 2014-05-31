package qmech.mod.metals;

import qmech.lib.objects.BlockBase;
import qmech.lib.objects.equip.ArmorTypeBase;
import qmech.lib.objects.equip.ToolTypeBase;
import qmech.lib.objects.fluid.FluidBase;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return true;
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
        public boolean moddedMetal() {
            return false;
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
        public boolean moddedMetal() {
            return false;
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
        public boolean moddedMetal() {
            return false;
        }
    };

    public abstract BlockBase.BlockInfo getBlockInfo();

    public abstract FluidBase.FluidInfo getFluidInfo();

    public abstract WorldGenerator.GenStats getOreGenInfo();

    public abstract ArmorTypeBase.ArmorInfo getArmorInfo();

    public abstract ToolTypeBase.ToolInfo getToolInfo();

    public abstract boolean moddedMetal();

}
