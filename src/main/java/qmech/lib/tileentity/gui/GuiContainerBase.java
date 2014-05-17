package qmech.lib.tileentity.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import qmech.lib.tileentity.TileEntityBase;
import qmech.lib.tileentity.IInventoryBase;

/**
 * Created by anshuman on 17-05-2014.
 */
public class GuiContainerBase extends Container {

    TileEntityBase te;
    IInventoryBase inv;

    public GuiContainerBase (InventoryPlayer p, TileEntityBase t) {
        te = t;

        addInvSlots();

        bindPlayerInventory(p);
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }

    public void addInvSlots() {
        if (te instanceof IInventoryBase) {
            inv = (IInventoryBase) te;
            for (int i=0; i<inv.inventory().getSizeInventory(); i++) {
                Slot s = new Slot(inv, i, inv.getSlotPos(i).getLeft(), inv.getSlotPos(i).getRight());
            }
        }
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            //merges the item into player inventory since its in the tileEntity
            if (slot < inv.inventory().getSizeInventory()) {
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
