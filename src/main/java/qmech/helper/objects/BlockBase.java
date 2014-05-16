package qmech.helper.objects;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import qmech.helper.LoggingHelper;
import qmech.mod.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockBase extends Block {

    protected static LoggingHelper logger = LoggingHelper.getInstance();
	
	public static BlockBase config
		(BlockBase block, CreativeTabs ctab, float hardness, float blastResistance, String toolType, int toolLevel) {
        logger.info(String.format("Configuring block (%s) with : \n" +
                ">>> CreativeTab : %s \n" +
                ">>> Hardness : %s, BlastResistance : %s \n" +
                ">>> Tool : %s, %s",
                block.getUnlocalizedName(),
                ctab, hardness, blastResistance, toolType, toolLevel));
		block.setCreativeTabs(ctab);
		block.setStrength(hardness, blastResistance).setHarvestLevel(toolType, toolLevel);
		block.registerBlock();
		return block;
	}

    public BlockBase(Material material, String intName) {
        super(material);
        this.setBlockTextureName(Reference.MOD_ID + ":" + intName);
        this.setInternalName(intName);
    }
    
    public BlockBase setStrength (float hardness, float blastResistance) {
        this.setHardness(hardness);
        this.setResistance(blastResistance);
        return this;
    }
    
    public BlockBase setCreativeTabs (CreativeTabs creativeTab) {
        this.setCreativeTab(creativeTab);
        return this;
    }
    
    public BlockBase setInternalName(String name){
        this.setBlockName(name);
        return this;
    }
    
    public void registerBlock () {
        GameRegistry.registerBlock(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
    }
    
    public void setHarvestLevel(String toolType, int toolLevel){
        super.setHarvestLevel(toolType, toolLevel);
    }

    public void onBlockPlacedBy (World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

}
