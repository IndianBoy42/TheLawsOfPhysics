package qmech.mod.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.helper.tileentity.TEBlockBase;
import qmech.mod.block.te.TileEntityTest;

/**
 * Created by anshuman on 14-05-2014.
 */
public class TestTEBlock extends TEBlockBase {

    public TestTEBlock(Material material, String intName) {
        super(material, intName);
    }

    @Override
    public String teName() {
        return "testTE";
    }

    @Override
    public boolean hasCustomRenderer() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityTest();
    }

}
