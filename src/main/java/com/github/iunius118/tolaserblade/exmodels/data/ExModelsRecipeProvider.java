package com.github.iunius118.tolaserblade.exmodels.data;

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
        addModelChangeRecipes(consumer, Ingredient.of(Items.SLIME_BALL), 407);
        addModelChangeRecipes(consumer, Ingredient.of(Items.DIAMOND_ORE), 504);
        addModelChangeRecipes(consumer, Ingredient.of(Items.DIAMOND_ORE), 519);
        addModelChangeRecipes(consumer, Ingredient.of(Items.HONEYCOMB), 606);
        addModelChangeRecipes(consumer, Ingredient.of(Items.COD), 726);
        addModelChangeRecipes(consumer, Ingredient.of(Items.CROSSBOW), 801);
        addModelChangeRecipes(consumer, Ingredient.of(Items.TROPICAL_FISH), 808);
        addModelChangeRecipes(consumer, Ingredient.of(Items.BARREL), 825);
        addModelChangeRecipes(consumer, Ingredient.of(Items.LIGHTNING_ROD), 903);
        addModelChangeRecipes(consumer, Ingredient.of(Items.PISTON), 913);
        addModelChangeRecipes(consumer, Ingredient.of(Items.SPYGLASS), 924);
        addModelChangeRecipes(consumer, Ingredient.of(Items.IRON_AXE), 1009);
        addModelChangeRecipes(consumer, Ingredient.of(Items.WOODEN_SWORD), 1108);
        addModelChangeRecipes(consumer, Ingredient.of(Items.STONE_SWORD), 1216);
        addModelChangeRecipes(consumer, Ingredient.of(Items.END_CRYSTAL), 1221);
    }

    private void addModelChangeRecipes(Consumer<FinishedRecipe> consumer, Ingredient addition, int modelType) {
        ExLBModelChangeRecipeBuilder.modelChangeRecipe(Ingredient.of(ModItems.LB_BLUEPRINT), Ingredient.of(ModItems.LASER_BLADE), addition, modelType)
                .addCriterion("has_laser_blade", has(ModItems.LASER_BLADE))
                .build(consumer, "tolaserblade:model/lb_" + modelType);
        ExLBModelChangeRecipeBuilder.modelChangeRecipe(Ingredient.of(ModItems.LB_BLUEPRINT), Ingredient.of(ModItems.LASER_BLADE_FP), addition, modelType)
                .addCriterion("has_laser_blade_fp", has(ModItems.LASER_BLADE_FP))
                .build(consumer, "tolaserblade:model/lbf_" + modelType);
    }
}
