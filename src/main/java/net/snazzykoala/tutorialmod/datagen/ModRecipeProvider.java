package net.snazzykoala.tutorialmod.datagen;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.block.ModBlocks;
import net.snazzykoala.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> FROSTSTEEL_SMELTABLES = List.of(ModItems.RAW_FROSTSTEEL.get(),
            ModBlocks.FROSTSTEEL_ORE.get(), ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, FROSTSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.FROSTSTEEL_INGOT.get(), 0.25f, 200, "froststeel");
        oreBlasting(pWriter, FROSTSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.FROSTSTEEL_INGOT.get(), 0.25f, 100, "froststeel");
        oreSmelting(pWriter, List.of(ModBlocks.FROSTSTEEL_BRICKS.get()), RecipeCategory.MISC, ModBlocks.CRACKED_FROSTSTEEL_BRICKS.get(), 0.25f, 200, "froststeel_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FROSTSTEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.FROSTSTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.FROSTSTEEL_INGOT.get()), has(ModItems.FROSTSTEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROSTSTEEL_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.FROSTSTEEL_NUGGET.get())
                .unlockedBy(getHasName(ModItems.FROSTSTEEL_NUGGET.get()), has(ModItems.FROSTSTEEL_NUGGET.get()))
                .save(pWriter, TutorialMod.MOD_ID + ":" + getItemName(ModItems.FROSTSTEEL_INGOT.get()) +"_from_" + getItemName(ModItems.FROSTSTEEL_NUGGET.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FROSTSTEEL_INGOT.get(), 9)
                .requires(ModBlocks.FROSTSTEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FROSTSTEEL_BLOCK.get()), has(ModBlocks.FROSTSTEEL_BLOCK.get()))
                .save(pWriter, TutorialMod.MOD_ID + ":" + getItemName(ModItems.FROSTSTEEL_INGOT.get()) +"_from_" + getItemName(ModBlocks.FROSTSTEEL_BLOCK.get()));



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FROSTSTEEL_NUGGET.get(), 9)
                .requires(ModItems.FROSTSTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.FROSTSTEEL_INGOT.get()), has(ModItems.FROSTSTEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_FROSTSTEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_FROSTSTEEL.get())
                .unlockedBy(getHasName(ModItems.RAW_FROSTSTEEL.get()), has(ModItems.RAW_FROSTSTEEL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_FROSTSTEEL.get(), 9)
                .requires(ModBlocks.RAW_FROSTSTEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_FROSTSTEEL_BLOCK.get()), has(ModBlocks.RAW_FROSTSTEEL_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROSTSTEEL_STEAK.get())
                .pattern("SSS")
                .pattern("SXS")
                .pattern("SSS")
                .define('S', ModItems.FROSTSTEEL_NUGGET.get())
                .define('X', Items.COOKED_BEEF)
                .unlockedBy(getHasName(ModItems.FROSTSTEEL_NUGGET.get()), has(ModItems.FROSTSTEEL_NUGGET.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
