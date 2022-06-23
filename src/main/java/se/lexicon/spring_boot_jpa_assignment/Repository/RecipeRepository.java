package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Recipe;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeCategory;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeIngredient;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    List<Recipe> searchRecipesByNameContains(String name);
            // select * from table where name like '%:enter_string%';

    //Search for all recipes that contains a specified ingredient name. e.g. potato, tomato, salt, etc.
    List<Recipe> searchRecipesByIngredientsContains(String ingredientName);

    //Search for all recipes that belong to a specific recipe category.
    // e.g. Chicken, Vegan, Celebration, Weekend etc.
    List<Recipe> searchRecipesByRecipeCategories(Set<RecipeCategory> recipeCategories);

    //Search for all recipes that match one or more categories. e.g. {”Spicy”,”Mexican”,”Weekend”}
    List<Recipe> searchRecipeByRecipeCategoriesMatches(Set<RecipeCategory> recipeCategories);
}