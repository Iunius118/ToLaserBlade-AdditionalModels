package com.github.iunius118.tolaserblade.exmodels.data;

import com.github.iunius118.tolaserblade.world.item.crafting.ModRecipeSerializers;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ExLBModelChangeRecipeBuilder {
    private final RecipeSerializer<?> serializer;
    private final Ingredient template;
    private final Ingredient base;
    private final Ingredient addition;
    private final int type;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();

    public ExLBModelChangeRecipeBuilder(RecipeSerializer<?> serializer, Ingredient template, Ingredient base, Ingredient addition, int type) {
        this.serializer = serializer;
        this.template = template;
        this.base = base;
        this.addition = addition;
        this.type = type;
    }

    public static ExLBModelChangeRecipeBuilder modelChangeRecipe(Ingredient template, Ingredient base, Ingredient addition, int type) {
        return new ExLBModelChangeRecipeBuilder(ModRecipeSerializers.MODEL_CHANGE, template, base, addition, type);
    }

    public ExLBModelChangeRecipeBuilder addCriterion(String name, CriterionTriggerInstance criterion) {
        this.advancementBuilder.addCriterion(name, criterion);
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumer, String id) {
        this.build(consumer, new ResourceLocation(id));
    }

    public void build(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        } else {
            this.advancementBuilder.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
            consumer.accept(new ExLBModelChangeRecipeBuilder.Result(id, this.serializer, this.template, this.base, this.addition, this.type, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath())));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final RecipeSerializer<?> serializer;
        private final Ingredient template;
        private final Ingredient base;
        private final Ingredient addition;
        private final int type;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, RecipeSerializer<?> serializer, Ingredient template, Ingredient base, Ingredient addition, int type, Advancement.Builder advancementBuilder, ResourceLocation advancementId) {
            this.id = id;
            this.serializer = serializer;
            this.template = template;
            this.base = base;
            this.addition = addition;
            this.type = type;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        public void serializeRecipeData(JsonObject json) {
            json.add("template", this.template.toJson());
            json.add("base", this.base.toJson());
            json.add("addition", this.addition.toJson());
            JsonObject result = new JsonObject();
            result.addProperty("model_type", this.type);
            json.add("result", result);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancementBuilder.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
