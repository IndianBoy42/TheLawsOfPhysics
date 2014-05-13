package qmech.helper.objects;

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

    static LoggingHelper logger = LoggingHelper.getInstance();
	
	public static BlockBase add
		(String intName, Material material, CreativeTabs ctab, float hardness, float blastResistance, String toolType, int toolLevel) {
        logger.info(String.format("Adding New Block with : \n" +
                ">>> Name : %s \n" +
                ">>> Material : %s \n" +
                ">>> CreativeTab : %s \n" +
                ">>> Hardness : %s, BlastResistance : %s \n" +
                ">>> Tool : %s, %s",
                intName, material, ctab, hardness, blastResistance, toolType, toolLevel));
		BlockBase block = new BlockBase(material, intName);
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
    
    public Class<? extends TileEntity> teClass;
    public boolean hasTE;
    
    public void addTileEntity (Class<? extends TileEntity> te) {
    	teClass = te;
    }
    
    public boolean hasTileEntity(){
    	return hasTE;
    }
    
    public TileEntity createTileEntity(World world, int meta){
    	try {
			return teClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    /*
    int guiID;
    boolean hasGui;
    
    public void addGui (int ID) {
    	guiID = ID;
    	hasGui = true;
    }
    
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player) {
    	return true;
    }
    */
    
    public void registerBlock () {
        GameRegistry.registerBlock(this, Reference.MOD_ID+":"+this.getUnlocalizedName().substring(5));
    }
    
    public void setHarvestLevel(String toolType, int toolLevel){
        super.setHarvestLevel(toolType, toolLevel);
    }
}
