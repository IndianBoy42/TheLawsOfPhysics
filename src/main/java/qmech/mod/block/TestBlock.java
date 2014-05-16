package qmech.mod.block;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.helper.LoggingHelper;
import qmech.helper.tileentity.TEBlockBase;
import qmech.helper.tileentity.render.CustomRendererBase;
import qmech.helper.tileentity.render.ModelRendererBase;
import qmech.helper.tileentity.render.model.BlockModelBase;
import qmech.mod.ModBase;
import qmech.mod.block.tileentity.TestTE;

/**
 * Created by anshuman on 16-05-2014.
 */
public class TestBlock extends TEBlockBase {
    public TestBlock(Material material, String intName) {
        super(material, intName);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TestTE();
    }

    public CustomRendererBase customRenderer() {
        return new ModelRendererBase(new BlockModelBase("testMachine"));
    }
}
