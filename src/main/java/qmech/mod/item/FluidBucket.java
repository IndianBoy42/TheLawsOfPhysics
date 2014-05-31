package qmech.mod.item;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import qmech.lib.objects.CreativeTabBase;
import qmech.lib.objects.meta.MetaItemBase;
import qmech.lib.util.LoggingHelper;
import qmech.mod.Reference;

/**
 * Created by anshuman on 18-05-2014.
 */
public class FluidBucket extends MetaItemBase {

    public FluidBucket(String intName, CreativeTabBase ctab) {
        super(intName);
        this.setTextureName(Reference.MOD_ID + ":" + intName);
        this.setCreativeTab(ctab);
        this.setMaxStackSize(1);

        LoggingHelper.getInstance().debug(String.format("Creating Fluid Container : %s", intName));

        //registerItem(0, new MetaItem("empty"));

        //registerFluids(intName, vol);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void registerFluids(String intName, int vol) {
        for (int i = 0; i < FluidRegistry.getMaxID() + 1; i++) {
            Fluid fluid = FluidRegistry.getFluid(i);

            if (fluid == null || fluid == FluidRegistry.LAVA || fluid == FluidRegistry.WATER) {
                continue;
            }

            this.registerItem(i, new MetaItem(fluid.getName()));

            FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, vol), this.newItemStack(i));

            LoggingHelper.getInstance().debug(String.format(">>> added container (%s) for fluid (%s:%s)",
                    intName, fluid.getUnlocalizedName(), i));
        }
    }

    public void registerFluid(Fluid fluid) {
        this.registerItem(FluidRegistry.getFluidID(fluid.getName()), new MetaItem(fluid.getName()));

        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME), this.newItemStack(FluidRegistry.getFluidID(fluid.getName())));

        LoggingHelper.getInstance().debug(String.format(">>> added container (%s) for fluid (%s:%s)",
                this.getUnlocalizedName(), fluid.getUnlocalizedName(), FluidRegistry.getFluidID(fluid.getName())));
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {

        ItemStack result = this.fillCustomBucket(event.world, event.target);

        if (result == null)
            return;

        event.result = result;
        event.setResult(Event.Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {
        Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

        Fluid fluid = FluidRegistry.lookupFluidForBlock(block);
        if (fluid == null) {
            return null;
        }
        int ID = FluidRegistry.getFluidID(fluid.getName());

        if (world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
            world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
            return this.newItemStack(ID);
        } else
            return null;

    }
}
