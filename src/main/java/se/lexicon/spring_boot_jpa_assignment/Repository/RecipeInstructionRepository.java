package se.lexicon.spring_boot_jpa_assignment.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_boot_jpa_assignment.entity.Recipe;
import se.lexicon.spring_boot_jpa_assignment.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction,Integer> {

    RecipeInstruction saveRecipeInstruction(Recipe recipe);
    RecipeInstruction findAllRecipeInstruction(int Id);
    RecipeInstruction updateRecipeInstruction(Recipe recipe);
    void RemoveByRecipeId(int id);
}
