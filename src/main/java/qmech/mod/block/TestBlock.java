package qmech.mod.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.lib.tileentity.TEBlockBase;
import qmech.lib.tileentity.render.IHasCustomRenderer;
import qmech.mod.block.tileentity.TestTE;

/**
 * Created by anshuman on 16-05-2014.
 */
public class TestBlock extends TEBlockBase implements IHasCustomRenderer.IBlockHasCustomRenderer {
    public TestBlock(Material material, String intName) {
        super(material, intName);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TestTE();
    }

    @Override
    public void registerTE() {
        new TestTE();
    }
}
