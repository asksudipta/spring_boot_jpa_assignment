package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

   Ingredient searchIngredientsByIngredientNameEquals(String ingredientName);

   List<Ingredient> searchByIngredientNameContains(String ingredientName);

}

