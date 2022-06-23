package se.lexicon.spring_boot_jpa_assignment.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;

    @ManyToMany(mappedBy = "recipeCategories",
            fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, Set<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(int id, String category, Set<Recipe> recipes) {
        this(category, recipes);
        this.id = id;
    }

    public void addRecipe(Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe value is null");
        if (recipes == null) recipes = new HashSet<>(recipes);

        if (!recipes.contains(recipe)) recipes.add(recipe);

    }

    public void removeRecipe(Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe value is null");
        if (recipes == null) recipes = new HashSet<>(recipes);

        // List<Recipe> recipeList = new ArrayList<>(recipes);
        if (!recipes.contains(recipe)) recipes.remove(recipe);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
