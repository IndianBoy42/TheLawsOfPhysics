package qmech.lib.objects;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import qmech.lib.util.LoggingHelper;
import qmech.mod.ModConfig;
import qmech.mod.Reference;

public class BlockBase extends Block {

    protected static final LoggingHelper logger = LoggingHelper.getInstance();

    public BlockBase(Material material, String intName) {
        super(material);
        this.setBlockTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
    }

    public static BlockBase config
            (BlockBase block, CreativeTabs ctab, float hardness, float blastResistance, String toolType, int toolLevel) {
        BlockInfo info = ModConfig.getBlockInfo(block, hardness, blastResistance, toolType, toolLevel);
        logger.debug(String.format("Configuring block (%s) with : \n" +
                        ">>> CreativeTab : %s \n" +
                        ">>> Hardness : %s, BlastResistance : %s \n" +
                        ">>> Tool : %s, %s",
                block.getUnlocalizedName(),
                ctab, info.hardness, info.blastResistance, info.toolType, info.toolLevel
        ));
        block.setCreativeTabs(ctab);
        block.setStrength(info.hardness, info.blastResistance);
        block.setHarvestLevel(info.toolType, info.toolLevel);
        block.registerBlock();
        return block;
    }

    public static BlockBase config
            (BlockBase block, CreativeTabBase ctab, BlockInfo info) {
        return config(block, ctab, info.hardness, info.blastResistance, info.toolType, info.toolLevel);
    }

    protected BlockBase setStrength(float hardness, float blastResistance) {
        this.setHardness(hardness);
        this.setResistance(blastResistance);
        return this;
    }

    protected void setCreativeTabs(CreativeTabs creativeTab) {
        this.setCreativeTab(creativeTab);
    }

    void setInternalName(String name) {
        this.setBlockName(name);
    }

    protected void registerBlock() {
        GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
    }

    public void setHarvestLevel(String toolType, int toolLevel) {
        super.setHarvestLevel(toolType, toolLevel);
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        int dir = MathHelper.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

    public static class BlockInfo {
        public float hardness = 1.0F;
        public float blastResistance = 1.0F;
        public String toolType = "pickaxe";
        public int toolLevel = 1;

        public BlockInfo() {
        }

        public BlockInfo(float hardness, float blastResistance, String toolType, int toolLevel) {
            this.hardness = hardness;
            this.blastResistance = blastResistance;
            this.toolType = toolType;
            this.toolLevel = toolLevel;
        }

        public static BlockInfo ironBlock() {
            return new BlockInfo(5.0F, 10.0F, "pickaxe", 1);
        }
    }
}
