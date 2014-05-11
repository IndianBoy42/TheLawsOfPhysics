package qmech.helper.objects.meta;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import qmech.mod.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class MetaItemBase extends Item {
	public static class MetaItem implements IMetaItemBase {

		private final String mod;
		private final String name;
		private IIcon icon;
		private Object[] recipes;
		private boolean visibleInCreative = true;
			
		public MetaItem(String name, Object... recipes) {
			this.mod = Reference.MOD_ID;
			this.name = name;
			this.recipes = recipes;
		}

		public MetaItem hideFromCreative() {
			visibleInCreative = false;
			return this;
		}

		@Override
		public IIcon getIcon() {
			return icon;
		}
			
		@Override
		public String getUnlocalizedName(ItemStack stack) {
			return String.format("%s.%s", mod, name);
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
		public void registerIcons(IIconRegister register) {
			registerIcon(register, name);
		}

		protected void registerIcon(IIconRegister register, String name) {
			icon = register.registerIcon(String.format("%s:%s", mod, name));
		}

		@Override
		public void addToCreativeList(Item item, int meta, List<ItemStack> result) {
			if (visibleInCreative) {
				result.add(new ItemStack(item, 1, meta));
			}
		}
			
		@Override
		public boolean hasEffect(int renderPass) {
			return false;
		}

	}

	protected Map<Integer, IMetaItemBase> metaitems = Maps.newHashMap();
	public String prefix;

	public MetaItemBase(String intName) {
		setHasSubtypes(true);
		setMaxDamage(0);
		this.setUnlocalizedName(intName);
		this.prefix = intName;
		GameRegistry.registerItem(this, Reference.MOD_ID + ":" + intName);
	}

	public void registerItem(int id, IMetaItemBase item) {
		IMetaItemBase prev = metaitems.put(id, item);
		Preconditions.checkState(prev == null, "Config error: replacing meta item %s with %s", prev, item);
	}

	@Override
	public void registerIcons(IIconRegister register) {
		for (IMetaItemBase item : metaitems.values()) {
			item.registerIcons(register);
		}
	}

	@Override
	public IIcon getIconFromDamage(int i) {
		IMetaItemBase meta = getMeta(i);
		if (meta != null) { return meta.getIcon(); }
		return null;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		IMetaItemBase meta = getMeta(stack.getItemDamage());
		if (meta != null) { return "item." + meta.getUnlocalizedName(stack); }
		return "";
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		IMetaItemBase meta = getMeta(itemStack.getItemDamage());
		if (meta != null) { return meta.onItemUse(itemStack, player, world, x, y, z, side, par8, par9, par10); }
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		IMetaItemBase meta = getMeta(itemStack.getItemDamage());
		if (meta != null) { return meta.onItemRightClick(itemStack, player, world); }
		return itemStack;
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player) {
		IMetaItemBase meta = getMeta(itemStack.getItemDamage());
		if (meta != null) { return meta.hitEntity(itemStack, target, player); }
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack, int pass) {
		IMetaItemBase meta = getMeta(itemStack.getItemDamage());
		return meta != null? meta.hasEffect(pass) : false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubItems(Item item, CreativeTabs tab, List subItems) {
		for (Entry<Integer, IMetaItemBase> entry : metaitems.entrySet())
			entry.getValue().addToCreativeList(item, entry.getKey(), subItems);
	}

	public IMetaItemBase getMeta(int id) {
		return metaitems.get(id);
	}

	public IMetaItemBase getMeta(ItemStack itemStack) {
		return getMeta(itemStack.getItemDamage());
	}

	public ItemStack newItemStack(int id) {
		return newItemStack(id, 1);
	}

	public ItemStack newItemStack(int id, int number) {
		return new ItemStack(this, number, id);
	}

	public ItemStack newItemStack(IMetaItemBase meta, int size) {
		for (Entry<Integer, IMetaItemBase> o : metaitems.entrySet()) {
			if (o.getValue().equals(meta)) { return newItemStack(o.getKey(), size); }
		}
		return null;
	}
}