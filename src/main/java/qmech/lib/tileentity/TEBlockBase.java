package qmech.lib.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.lib.objects.BlockBase;
import qmech.lib.tileentity.render.IHasCustomRenderer;
import qmech.mod.Reference;

/**
 * Created by anshuman on 14-05-2014.
 */
public abstract class TEBlockBase extends BlockBase implements ITileEntityProvider {

    private final String teName;

    protected TEBlockBase(Material material, String intName) {
        super(material, intName);
        this.teName = intName;

        this.registerTE();
    }

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
        block.setStrength(hardness, blastResistance);
        block.setHarvestLevel(toolType, toolLevel);
        block.registerBlock();
        return block;
    }

    private static boolean hasTeAt(World w, int x, int y, int z) {
        return !(getTileAt(w, x, y, z).equals(null));
    }

    private static TileEntity getTileAt(World w, int x, int y, int z) {
        return w.getTileEntity(x, y, z);
    }

    protected abstract void registerTE();

    String teName() {
        return this.teName;
    }

    boolean hasCustomRenderer() {
        return this instanceof IHasCustomRenderer.IBlockHasCustomRenderer;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return !this.hasCustomRenderer();
    }

    @Override
    public boolean isOpaqueCube() {
        return !this.hasCustomRenderer();
    }

    public int getRenderType() {
        if (this.hasCustomRenderer()) {
            return Reference.RENDER_ID;
        }
        return 0;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborChange(World w, int x, int y, int z, int tX, int tY, int tZ) {
        if (hasTeAt(w, x, y, z)) {
            TileEntity tileEntity = getTileAt(w, x, y, z);
            if (tileEntity instanceof TileEntityBase) {
                ((TileEntityBase) tileEntity).onNeighborChange(tX, tY, tZ);
            }
        }
    }

    public void breakBlock(World w, int x, int y, int z, Block par5, int par6) {
        this.dropItems(w, x, y, z);
        super.breakBlock(w, x, y, z, par5, par6);
    }

    void dropItems(World w, int x, int y, int z) {
        if (hasTeAt(w, x, y, z) && (getTileAt(w, x, y, z) instanceof TileEntityBase)) {
            ((TileEntityBase) getTileAt(w, x, y, z)).getDrops();
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int meta, float par7, float par8, float par9) {
        return hasTeAt(w, x, y, z) && getTileAt(w, x, y, z) instanceof TileEntityBase && ((TileEntityBase) getTileAt(w, x, y, z)).onActivation(w, x, y, z, p, meta, par7, par8, par9);

    }
}
