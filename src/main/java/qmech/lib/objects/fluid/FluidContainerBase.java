package qmech.lib.objects.fluid;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.objects.meta.MetaItemBase;
import qmech.lib.util.LoggingHelper;
import qmech.mod.Reference;

/**
 * Created by anshuman on 17-05-2014.
 */


public class FluidContainerBase extends MetaItemBase {
    public int vol = FluidContainerRegistry.BUCKET_VOLUME;

    public FluidContainerBase(String intName, int vol, CreativeTabBase ctab, Boolean registerAll) {
        super(intName);
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setCreativeTab(ctab);

        this.vol = vol;

        LoggingHelper.getInstance().debug(String.format("Creating Fluid Container : %s", intName));

        registerItem(0, new MetaItem("empty"));

        if (registerAll) {
            registerFluids();
        } else {
            registerFluid(FluidRegistry.WATER);
            registerFluid(FluidRegistry.LAVA);
        }
    }

    public void registerFluid (Fluid fluid) {
        String fName = fluid.getName();
        int fID = FluidRegistry.getFluidID(fName);

        registerItem(fID, new MetaItem(fName));

        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, vol), newItemStack(fID));

        LoggingHelper.getInstance().debug(String.format(">>> added container (%s) for fluid (%s:%s)",
                this.getUnlocalizedName(), fluid.getUnlocalizedName(), fID));
    }

    public void registerFluids () {
        for (int i=0; i< FluidRegistry.getMaxID() + 1; i++) {
            Fluid fluid = FluidRegistry.getFluid(i);
            if (fluid == null) {
                continue;
            }

            registerFluid(fluid);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.getItemDamage() != 0) {
            return itemStack;
        }

        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
        int x = mop.blockX;
        int y = mop.blockY;
        int z = mop.blockZ;

        Block block = world.getBlock(x, y, z);

        Fluid fluid = FluidRegistry.lookupFluidForBlock(block);
        if (fluid == null) {
            return itemStack;
        }
        int ID = FluidRegistry.getFluidID(fluid.getName());

        if (world.getBlockMetadata(x, y ,z) == 0) {
            world.setBlockToAir(x, y, z);
            player.inventory.addItemStackToInventory(newItemStack(ID));
            return new ItemStack(itemStack.getItem(), itemStack.stackSize - 1, 0);
        } else
            return itemStack;
    }
}
