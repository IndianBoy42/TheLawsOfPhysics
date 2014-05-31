package qmech.lib.objects.meta;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import qmech.mod.Reference;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class MetaItemBase extends Item {
    public final String prefix;
    private final Map<Integer, IMetaItemBase> metaitems = Maps.newHashMap();
    protected MetaItemBase(String intName) {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName(intName);
        this.prefix = intName;
        GameRegistry.registerItem(this, intName);
    }

    public void registerItem(int id, IMetaItemBase item) {
        IMetaItemBase prev = this.metaitems.put(id, item);
        Preconditions.checkState(prev == null, "Config error: replacing meta item %s with %s", prev, item);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        for (IMetaItemBase item : this.metaitems.values()) {
            item.registerIcons(register, this.prefix);
        }
    }

    @Override
    public IIcon getIconFromDamage(int i) {
        IMetaItemBase meta = this.getMeta(i);
        if (meta != null) {
            return meta.getIcon();
        }
        return null;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        IMetaItemBase meta = this.getMeta(stack.getItemDamage());
        if (meta != null) {
            return String.format("item.%s_%s", this.prefix, meta.getUnlocalizedName(stack));
        }
        return "";
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
        IMetaItemBase meta = this.getMeta(itemStack.getItemDamage());
        return meta == null || meta.onItemUse(itemStack, player, world, x, y, z, side, par8, par9, par10);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        IMetaItemBase meta = this.getMeta(itemStack.getItemDamage());
        if (meta != null) {
            return meta.onItemRightClick(itemStack, player, world);
        }
        return itemStack;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player) {
        IMetaItemBase meta = this.getMeta(itemStack.getItemDamage());
        return meta == null || meta.hitEntity(itemStack, target, player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int pass) {
        IMetaItemBase meta = this.getMeta(itemStack.getItemDamage());
        return (meta != null) && meta.hasEffect(pass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void getSubItems(Item item, CreativeTabs tab, List subItems) {
        for (Entry<Integer, IMetaItemBase> entry : this.metaitems.entrySet())
            entry.getValue().addToCreativeList(item, entry.getKey(), subItems);
    }

    IMetaItemBase getMeta(int id) {
        return this.metaitems.get(id);
    }

    public IMetaItemBase getMeta(ItemStack itemStack) {
        return this.getMeta(itemStack.getItemDamage());
    }

    protected ItemStack newItemStack(int id) {
        return this.newItemStack(id, 1);
    }

    ItemStack newItemStack(int id, int number) {
        return new ItemStack(this, number, id);
    }

    public ItemStack newItemStack(IMetaItemBase meta, int size) {
        for (Entry<Integer, IMetaItemBase> o : this.metaitems.entrySet()) {
            if (o.getValue().equals(meta)) {
                return this.newItemStack(o.getKey(), size);
            }
        }
        return null;
    }

    public static class MetaItem implements IMetaItemBase {

        private final String mod;
        private final String name;
        private IIcon icon;
        private final Object[] recipes;
        private boolean visibleInCreative = true;

        public MetaItem(String name, Object... recipes) {
            this.mod = Reference.MOD_ID;
            this.name = name;
            this.recipes = recipes;
        }

        public MetaItem hideFromCreative() {
            this.visibleInCreative = false;
            return this;
        }

        @Override
        public IIcon getIcon() {
            return this.icon;
        }

        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return this.name;
        }

        @Override
        public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player) {
            return false;
        }

        @Override
        public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
            return false;
        }

        @Override
        public ItemStack onItemRightClick(ItemStack itemStack, EntityPlayer player, World world) {
            return itemStack;
        }

        @Override
        public void registerIcons(IIconRegister register, String prefix) {
            this.registerIcon(register, String.format("%s_%s", prefix, this.name));
        }

        void registerIcon(IIconRegister register, String name) {
            this.icon = register.registerIcon(String.format("%s:%s", this.mod, name));
        }

        @Override
        public void addToCreativeList(Item item, int meta, List<ItemStack> result) {
            if (this.visibleInCreative) {
                result.add(new ItemStack(item, 1, meta));
            }
        }

        @Override
        public boolean hasEffect(int renderPass) {
            return false;
        }

    }
}