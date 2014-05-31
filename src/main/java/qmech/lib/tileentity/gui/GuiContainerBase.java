package qmech.lib.tileentity.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import qmech.lib.tileentity.IInventoryBase;
import qmech.lib.tileentity.TileEntityBase;

/**
 * Created by anshuman on 17-05-2014.
 */
public class GuiContainerBase extends Container {

    private final TileEntityBase te;
    private IInventoryBase inv;

    public GuiContainerBase(InventoryPlayer p, TileEntityBase t) {
        this.te = t;

        this.addInvSlots();

        this.bindPlayerInventory(p);
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }

    void addInvSlots() {
        if (this.te instanceof IInventoryBase) {
            this.inv = (IInventoryBase) this.te;
            for (int i = 0; i < this.inv.inventory().getSizeInventory(); i++) {
                new Slot(this.inv, i, this.inv.getSlotPos(i).getLeft(), this.inv.getSlotPos(i).getRight());
            }
        }
    }

    void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) this.inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            //merges the item into player inventory since its in the tileEntity
            if (slot < this.inv.inventory().getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
                    return null;
                }
            }
            //places it into the tileEntity is possible since its in the player inventory
            else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }
}
