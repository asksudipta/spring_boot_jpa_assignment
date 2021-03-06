package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Ingredient;
import se.lexicon.spring_boot_jpa_assignment.entity.Recipe;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,Integer> {

    RecipeIngredient findBYRecipeIngredientId (int id);
    void removeByIngredientId (int id);
    RecipeIngredient saveRecipe(Recipe recipe);


}