package qmech.lib.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.lib.objects.BlockBase;
import qmech.lib.tileentity.render.ICustomRendered;
import qmech.mod.Reference;

/**
 * Created by anshuman on 14-05-2014.
 */
public abstract class TEBlockBase extends BlockBase implements ITileEntityProvider {

    public static TEBlockBase config
            (TEBlockBase block, CreativeTabs ctab, float hardness, float blastResistance, String toolType, int toolLevel) {
        logger.debug(String.format("Configuring TEBlock (%s, %s) with : \n" +
                        ">>> CreativeTab : %s \n" +
                        ">>> Hardness : %s, BlastResistance : %s \n" +
                        ">>> Tool : %s, %s",
                block.teName(), block.getUnlocalizedName(),
                ctab, hardness, blastResistance, toolType, toolLevel
        ));
        block.setCreativeTabs(ctab);
        block.setStrength(hardness, blastResistance).setHarvestLevel(toolType, toolLevel);
        block.registerBlock();
        return block;
    }

    public TEBlockBase(Material material, String intName) {
        super(material, intName);
        teName = intName;
    }

    public abstract void registerTE();

    String teName;
    public String teName() {
        return teName;
    }

    public boolean hasCustomRenderer() {
        return this instanceof ICustomRendered;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return !hasCustomRenderer();
    }

    @Override
    public boolean isOpaqueCube()
    {
        return !hasCustomRenderer();
    }

    public int getRenderType() {
        if(hasCustomRenderer()) {
            return Reference.RENDER_ID;
        }
        return 0;
    }

    public boolean hasTeAt (World w, int x, int y, int z) {
        return !(getTileAt(w, x, y,z).equals(null));
    }

    public TileEntity getTileAt(World w, int x, int y, int z) {
        TileEntity te = w.getTileEntity(x, y, z);
        return te;
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta) {
        if (hasTeAt(w, x, y ,z)) {
            TileEntity tileEntity = getTileAt(w, x, y, z);
            if (tileEntity instanceof TileEntityBase) {
                ((TileEntityBase) tileEntity).onBlockDestroyedByPlayer(meta);
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborChange(World w, int x, int y, int z, int tX, int tY, int tZ) {
        if (hasTeAt(w, x, y ,z)) {
            TileEntity tileEntity = getTileAt(w, x, y, z);
            if (tileEntity instanceof TileEntityBase) {
                ((TileEntityBase) tileEntity).onNeighborChange(tX, tY, tZ);
            }
        }
    }

    public void breakBlock(World w, int x, int y, int z, Block par5, int par6)
    {
        dropItems(w, x, y, z);
        super.breakBlock(w, x, y, z, par5, par6);
    }

    public void dropItems (World w, int x, int y, int z) {
        if (hasTeAt(w, x, y ,z) && (getTileAt(w, x, y, z) instanceof TileEntityBase)) {
            ((TileEntityBase) getTileAt(w, x, y, z)).getDrops();
        }
    }
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int meta, float par7, float par8, float par9)
    {
        if (hasTeAt(w, x, y, z) && getTileAt(w, x, y, z) instanceof TileEntityBase) {
             return ((TileEntityBase) getTileAt(w, x, y ,z)).onActivation(w, x, y, z, p, meta, par7, par8, par9);
        }

        return false;
    }
}
