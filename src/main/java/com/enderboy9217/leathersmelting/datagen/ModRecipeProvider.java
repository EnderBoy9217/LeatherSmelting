package com.enderboy9217.leathersmelting.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

import static com.enderboy9217.leathersmelting.EndersLeatherSmelting.MOD_ID;


public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

        // Smelting: Rotten Flesh -> Leather
        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(Items.ROTTEN_FLESH),
                        RecipeCategory.MISC,
                        Items.LEATHER,
                        0.5f,
                        200
                )
                .criterion("has_rotten_flesh", conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(consumer, new Identifier(MOD_ID, "leather_from_rotten_flesh"));

        // Smoking: Rotten Flesh -> Leather
        CookingRecipeJsonBuilder.createSmoking(
                        Ingredient.ofItems(Items.ROTTEN_FLESH),
                        RecipeCategory.MISC,
                        Items.LEATHER,
                        0.5f,
                        100
                )
                .criterion("has_rotten_flesh", conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(consumer, new Identifier(MOD_ID, "smoker_leather_from_rotten_flesh"));
    }
}
