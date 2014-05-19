package qmech.lib.objects.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import qmech.lib.objects.CreativeTabBase;
import qmech.mod.Reference;

/**
 * Created by anshuman on 17-05-2014.
 */
public class FluidBlockBase extends BlockFluidClassic{

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public FluidBlockBase(Fluid fluid, Material material, CreativeTabBase ctab) {
        super(fluid, material);
        this.setBlockName(fluid.getUnlocalizedName());
        this.setBlockTextureName(fluid.getLocalizedName().substring(6));
        GameRegistry.registerBlock(this, fluid.getUnlocalizedName());
        setCreativeTab(ctab);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(String.format("%s:fluid/%s_still", Reference.MOD_ID, this.getUnlocalizedName().substring(11)));
        flowingIcon = register.registerIcon(String.format("%s:fluid/%s", Reference.MOD_ID, this.getUnlocalizedName().substring(11)));
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }

}
