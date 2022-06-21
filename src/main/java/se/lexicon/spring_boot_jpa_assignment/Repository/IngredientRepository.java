package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {
}
