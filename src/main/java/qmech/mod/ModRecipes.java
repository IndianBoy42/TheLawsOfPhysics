package qmech.mod;

import net.minecraft.item.ItemStack;
import qmech.lib.objects.BlockBase;
import qmech.lib.objects.ItemBase;
import qmech.lib.util.LoggingHelper;
import qmech.lib.util.RecipeHelper;

public class ModRecipes {
	//Put all block/Item Recipes in here
	
	public static void preInit () {
        for (BlockBase block : ModBlocks.getBlockFromType("block")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(block) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.shapedRecipe(new ItemStack(block),
                            "xxx", "xxx","xxx",
                            'x', new ItemStack(ingot));
                    RecipeHelper.shapelessRecipe(new ItemStack(ingot, 9),
                            new ItemStack(block));
                }
            }
        }

        for (BlockBase bricks : ModBlocks.getBlockFromType("bricks")) {
            for (ItemBase brick : ModItems.getItemFromType("brick")) {
                if (ModBlocks.metalsToBlocks.get(bricks) == ModItems.metalsToItems.get(brick)) {
                    RecipeHelper.shapedRecipe(new ItemStack(bricks),
                            "xx", "xx",
                            'x', new ItemStack(brick));
                }
            }
        }

        for (ItemBase plate : ModItems.getItemFromType("plate")) {
            for (ItemBase item : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(plate) == ModItems.metalsToItems.get(item)) {
                    RecipeHelper.shapedRecipe(new ItemStack(plate),
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

        for (BlockBase ore : ModBlocks.getBlockFromType("ore")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(ore) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot), new ItemStack(ore), 1.0F);
                }
            }
        }

        for (BlockBase gravelOre : ModBlocks.getBlockFromType("gravelOre")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(gravelOre) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot), new ItemStack(gravelOre), 1.0F);
                }
            }
        }

        for (BlockBase netherOre : ModBlocks.getBlockFromType("netherOre")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(netherOre) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot, 2), new ItemStack(netherOre), 1.0F);
                }
            }
        }

        for (BlockBase enderOre : ModBlocks.getBlockFromType("enderOre")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModBlocks.metalsToBlocks.get(enderOre) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot, 3), new ItemStack(enderOre), 1.0F);
                }
            }
        }

        for (ItemBase clump : ModItems.getItemFromType("clump")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(clump) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot), new ItemStack(clump), 1.0F);
                }
            }
        }

        for (ItemBase dust : ModItems.getItemFromType("dust")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(dust) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot), new ItemStack(dust), 1.0F);
                }
            }
        }

        for (ItemBase powder : ModItems.getItemFromType("powder")) {
            for (ItemBase ingot : ModItems.getItemFromType("ingot")) {
                if (ModItems.metalsToItems.get(powder) == ModItems.metalsToItems.get(ingot)) {
                    RecipeHelper.smeltingRecipe(new ItemStack(ingot), new ItemStack(powder), 1.0F);
                }
            }
        }
	}

}
