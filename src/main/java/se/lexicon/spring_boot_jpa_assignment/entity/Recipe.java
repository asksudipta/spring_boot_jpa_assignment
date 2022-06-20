package se.lexicon.spring_boot_jpa_assignment.entity;

import java.util.List;
import java.util.Set;

public class Recipe {
    private int id;
    private String name;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction recipeInstruction;
    private Set<RecipeCategory> recipeCategories;

    public Recipe() {
    }
}
