package com.github.iunius118.tolaserblade.exmodels.data;

import com.github.iunius118.tolaserblade.data.recipes.LBModelChangeRecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.crafting.Ingredient;

public class ExLBModelChangeRecipeBuilder extends LBModelChangeRecipeBuilder {
    // Use the builder of ToLaserBlade until the problem occurs
    public ExLBModelChangeRecipeBuilder(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, int type) {
        super(template, base, addition, category, type);
    }
}
