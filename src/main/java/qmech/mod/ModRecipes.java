package qmech.mod;

import net.minecraft.item.ItemStack;
import qmech.lib.objects.BlockBase;
import qmech.lib.objects.ItemBase;
import qmech.lib.util.RecipeHelper;

public class ModRecipes {
	//Put all block/Item Recipes in here
	
	public static void preInit () {
        for (BlockBase block : ModBlocks.getBlockFromType("block")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.shapedRecipe(new ItemStack(block),
                            "xxx", "xxx","xxx",
                            'x', new ItemStack(item));
                    RecipeHelper.shapelessRecipe(new ItemStack(item, 9),
                            new ItemStack(block));
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("bricks")) {
            for (ItemBase item : ModItems.getItemFromType("brick")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.shapedRecipe(new ItemStack(block),
                            "xx", "xx",
                            'x', new ItemStack(item));
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("plate")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.shapedRecipe(new ItemStack(block),
                            "xx", "xx",
                            'x', new ItemStack(item));
                }
            }
        }

        for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
            for (ItemBase nugget : ModItems.getItemFromType("nugget")) {
                if (ModItems.metalsToItems.get(nugget) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.shapedRecipe(new ItemStack(ingot),
                            "xxx", "xxx","xxx",
                            'x', new ItemStack(nugget));
                    RecipeHelper.shapelessRecipe(new ItemStack(nugget, 9),
                            new ItemStack(ingot));
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("ore")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item), new ItemStack(block), 1.0F);
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("gravelOre")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item), new ItemStack(block), 1.0F);
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("netherOre")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item, 2), new ItemStack(block), 1.0F);
                }
            }
        }

        for (BlockBase block : ModBlocks.getBlockFromType("enderOre")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item, 3), new ItemStack(block), 1.0F);
                }
            }
        }

        for (ItemBase input : ModItems.getItemFromType("clump")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(input) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item), new ItemStack(input), 1.0F);
                }
            }
        }

        for (ItemBase input : ModItems.getItemFromType("dust")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(input) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item), new ItemStack(input), 1.0F);
                }
            }
        }

        for (ItemBase input : ModItems.getItemFromType("powder")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(input) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(item), new ItemStack(input), 1.0F);
                }
            }
        }
	}

}
