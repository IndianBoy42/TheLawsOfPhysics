package qmech.helper.tileentity;

import com.google.common.base.Throwables;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import qmech.helper.objects.BlockBase;
import qmech.helper.tileentity.render.CustomRendererBase;
import qmech.mod.ModBase;
import qmech.mod.Reference;
import qmech.mod.block.tileentity.TestTE;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by anshuman on 14-05-2014.
 */
public abstract class TEBlockBase extends BlockBase implements ITileEntityProvider {

    public static TEBlockBase config
            (TEBlockBase block, CreativeTabs ctab, float hardness, float blastResistance, String toolType, int toolLevel) {
        logger.info(String.format("Configuring TEBlock (%s, %s) with : \n" +
                        ">>> CreativeTab : %s \n" +
                        ">>> Hardness : %s, BlastResistance : %s \n" +
                        ">>> Tool : %s, %s",
                block.teName(), block.getUnlocalizedName(),
                ctab, hardness, blastResistance, toolType, toolLevel));
        block.setCreativeTabs(ctab);
        block.setStrength(hardness, blastResistance).setHarvestLevel(toolType, toolLevel);
        block.registerBlock();
        return block;
    }

    public TEBlockBase(Material material, String intName, CustomRendererBase... renderer) {
        super(material, intName);
        teName = intName;
        if (renderer.length > 0) {
            this.renderer = renderer[0];
        }
        GameRegistry.registerTileEntity(TileEntityBase.class, String.format("%s:%s", Reference.MOD_ID, teName()));
        ModBase.proxy.registerRenderer(TestTE.class, customRenderer());
    }

    String teName;
    public String teName() {
        return teName;
    }

    public boolean hasCustomRenderer() {
        return customRenderer() != null;
    }

    CustomRendererBase renderer;
    public CustomRendererBase customRenderer() {
        return renderer;
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
}
