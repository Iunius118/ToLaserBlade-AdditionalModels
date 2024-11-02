package com.github.iunius118.tolaserblade.exmodels.data;

import com.github.iunius118.tolaserblade.world.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ExModelsRecipeProvider extends VanillaRecipeProvider {
    public ExModelsRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput output) {
        super(registryLookup, output);
    }

    @Override
    public void buildRecipes() {
        Ingredient template = Ingredient.of(ModItems.LB_BLUEPRINT);

        addModelChangeRecipes(template, Ingredient.of(Items.IRON_SWORD), 101);
        addModelChangeRecipes(template, Ingredient.of(Items.YELLOW_CANDLE), 217);
        addModelChangeRecipes(template, Ingredient.of(Items.SALMON), 222);
        addModelChangeRecipes(template, Ingredient.of(Items.DRAGON_BREATH), 305);
        addModelChangeRecipes(template, Ingredient.of(Items.SHIELD), 316);
        addModelChangeRecipes(template, Ingredient.of(Items.SLIME_BALL), 407);
        addModelChangeRecipes(template, Ingredient.of(Items.DIAMOND_ORE), 504);
        addModelChangeRecipes(template, Ingredient.of(Items.DIAMOND_ORE), 519);
        addModelChangeRecipes(template, Ingredient.of(Items.HONEYCOMB), 606);
        addModelChangeRecipes(template, Ingredient.of(Items.COD), 726);
        addModelChangeRecipes(template, Ingredient.of(Items.CROSSBOW), 801);
        addModelChangeRecipes(template, Ingredient.of(Items.TROPICAL_FISH), 808);
        addModelChangeRecipes(template, Ingredient.of(Items.BARREL), 825);
        addModelChangeRecipes(template, Ingredient.of(Items.LIGHTNING_ROD), 903);
        addModelChangeRecipes(template, Ingredient.of(Items.PISTON), 913);
        addModelChangeRecipes(template, Ingredient.of(Items.SPYGLASS), 924);
        addModelChangeRecipes(template, Ingredient.of(Items.IRON_AXE), 1009);
        addModelChangeRecipes(template, Ingredient.of(Items.WOODEN_SWORD), 1108);
        addModelChangeRecipes(template, Ingredient.of(Items.STONE_SWORD), 1216);
        addModelChangeRecipes(template, Ingredient.of(Items.END_CRYSTAL), 1221);
    }

    private void addModelChangeRecipes(Ingredient template, Ingredient addition, int modelType) {
        ExLBModelChangeRecipeBuilder.modelChangeRecipe(template, Ingredient.of(ModItems.LASER_BLADE), addition, RecipeCategory.TOOLS, modelType)
                .unlockedBy("has_laser_blade", has(ModItems.LASER_BLADE))
                .save(output, "tolaserblade:model/lb_" + modelType);
        ExLBModelChangeRecipeBuilder.modelChangeRecipe(template, Ingredient.of(ModItems.LASER_BLADE_FP), addition, RecipeCategory.TOOLS, modelType)
                .unlockedBy("has_laser_blade_fp", has(ModItems.LASER_BLADE_FP))
                .save(output, "tolaserblade:model/lbf_" + modelType);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
            return new ExModelsRecipeProvider(registryLookup, exporter);
        }

        @Override
        public String getName() {
            return "Recipes";
        }
    }
}
