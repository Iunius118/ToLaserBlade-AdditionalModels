package com.github.iunius118.tolaserblade.exmodels.data;

import com.github.iunius118.tolaserblade.data.LBModelChangeRecipeBuilder;
import com.github.iunius118.tolaserblade.world.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ExModelsRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ExModelsRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        addModelChangeRecipes(consumer, Ingredient.of(Items.IRON_SWORD), 101);
        addModelChangeRecipes(consumer, Ingredient.of(Items.YELLOW_CANDLE), 217);
        addModelChangeRecipes(consumer, Ingredient.of(Items.SALMON), 222);
        addModelChangeRecipes(consumer, Ingredient.of(Items.DRAGON_BREATH), 305);
        addModelChangeRecipes(consumer, Ingredient.of(Items.SHIELD), 316);
        addModelChangeRecipes(consumer, Ingredient.of(Items.HONEYCOMB), 606);
        addModelChangeRecipes(consumer, Ingredient.of(Items.COD), 726);
        addModelChangeRecipes(consumer, Ingredient.of(Items.TROPICAL_FISH), 808);
        addModelChangeRecipes(consumer, Ingredient.of(Items.END_CRYSTAL), 1221);
    }

    private void addModelChangeRecipes(Consumer<FinishedRecipe> consumer, Ingredient addition, int modelType) {
        LBModelChangeRecipeBuilder.modelChangeRecipe(Ingredient.of(ModItems.LASER_BLADE), addition, modelType)
                .addCriterion("has_laser_blade", has(ModItems.LASER_BLADE))
                .build(consumer, "tolaserblade:model/lb_" + modelType);
        LBModelChangeRecipeBuilder.modelChangeRecipe(Ingredient.of(ModItems.LASER_BLADE_FP), addition, modelType)
                .addCriterion("has_laser_blade_fp", has(ModItems.LASER_BLADE_FP))
                .build(consumer, "tolaserblade:model/lbf_" + modelType);
    }
}
