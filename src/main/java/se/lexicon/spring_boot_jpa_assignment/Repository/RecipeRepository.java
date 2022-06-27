package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Recipe;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeCategory;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeIngredient;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    //Search for recipes where recipe name contains specified String.
    List<Recipe> findByName(String name);

    //Search for all recipes that contains a specified ingredient name. e.g. potato, tomato, salt, etc.
    List<Recipe> findAllByRecipeIngredientsIngredientIngredientName(String ingredientName);

    //Search for all recipes that belong to a specific recipe category.
    // e.g. Chicken, Vegan, Celebration, Weekend etc.
    List<Recipe> findAllByRecipeCategoriesCategory(String category);


    //Search for all recipes that match one or more categories. e.g. {”Spicy”,”Mexican”,”Weekend”}
    List<Recipe> findAllRecipes(List<String> category);


}