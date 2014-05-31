package qmech.lib.objects.meta;

import net.minecraft.item.ItemStack;

public enum EnumItemsBase {
    Generic;

    public static void registerItems(MetaItemBase base) {
        for (EnumItemsBase m : values())
            if (m.isEnabled()) base.registerItem(m.ordinal(), m.createMetaItem(base));
    }

    public ItemStack newItemStack(MetaItemBase base, int size) {
        return new ItemStack(base, size, this.ordinal());
    }

    public ItemStack newItemStack(MetaItemBase base) {
        return new ItemStack(base, 1, this.ordinal());
    }

    public boolean isA(ItemStack stack) {
        return (stack.getItem() instanceof MetaItemBase) && (stack.getItemDamage() == this.ordinal());
    }

    MetaItemBase.MetaItem createMetaItem(MetaItemBase base) {
        return new MetaItemBase.MetaItem(base.prefix + "_" + this.name());
    }

    boolean isEnabled() {
        return true;
    }
}