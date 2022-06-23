package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory,Integer> {

}
