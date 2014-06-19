package lawsof.physics.lib.objects.fluid

import net.minecraftforge.fluids.{Fluid, BlockFluidClassic}
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.util.IIcon
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.block.material.Material
import lawsof.physics.lib.objects.CreativeTabBase
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.world.{World, IBlockAccess}
import lawsof.physics.mod.init.Reference

class FluidBlockBase(fluid: Fluid, material: Material, ctab: CreativeTabBase) extends BlockFluidClassic(fluid, material) {
  this.setBlockName(fluid.getUnlocalizedName)
  this.setBlockTextureName(fluid.getLocalizedName.substring(6))
  GameRegistry.registerBlock(this, fluid.getUnlocalizedName)
  setCreativeTab(ctab)

  override def getIcon(side: Int, meta: Int): IIcon = {
    if (side == 0 || side == 1) stillIcon else flowingIcon
  }

  @SideOnly(Side.CLIENT) override def registerBlockIcons(register: IIconRegister) {
    stillIcon = register.registerIcon(s"${Reference.MOD_ID}:fluid/${this.getUnlocalizedName.substring(11)}_still")
    flowingIcon = register.registerIcon(s"${Reference.MOD_ID}:fluid/${this.getUnlocalizedName.substring(11)}")
  }

  override def canDisplace(world: IBlockAccess, x: Int, y: Int, z: Int): Boolean = {
    if (world.getBlock(x, y, z).getMaterial.isLiquid) return false
    super.canDisplace(world, x, y, z)
  }

  override def displaceIfPossible(world: World, x: Int, y: Int, z: Int): Boolean = {
    if (world.getBlock(x, y, z).getMaterial.isLiquid) return false
    super.displaceIfPossible(world, x, y, z)
  }

  @SideOnly(Side.CLIENT) protected var stillIcon: IIcon = null
  @SideOnly(Side.CLIENT) protected var flowingIcon: IIcon = null
}
