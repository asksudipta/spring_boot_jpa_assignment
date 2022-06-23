package se.lexicon.spring_boot_jpa_assignment.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructions_id")
    private RecipeInstruction recipeInstruction;

    @OneToMany(fetch = FetchType.LAZY
            ,mappedBy = "recipe"
            ,cascade = {CascadeType.MERGE,CascadeType.DETACH}
            ,orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<RecipeCategory> recipeCategories;


    public Recipe() {
    }

    public Recipe(String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> recipeCategories) {
        setName(name);
        setRecipeIngredients(recipeIngredients);
        setRecipeInstruction(recipeInstruction);
        setRecipeCategories(recipeCategories);
    }

    public Recipe(int id, String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> recipeCategories) {
        this(name, recipeIngredients, recipeInstruction, recipeCategories);
        this.id = id;
    }

    //Implements Convenient methods:
    public void AddRecipeCategory(RecipeCategory recipeCategory){
        if (recipeCategory==null)throw new IllegalArgumentException("RecipeCategory value is null");
        if(recipeCategories==null)recipeCategories=new HashSet<>(recipeCategories);

        if (!recipeCategories.contains(recipeCategory))recipeCategories.add(recipeCategory);
    }
    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if (recipeCategory==null)throw new IllegalArgumentException("RecipeCategory value is null");
        if(recipeCategories==null)recipeCategories=new HashSet<>(recipeCategories);

        if (!recipeCategories.contains(recipeCategory))recipeCategories.remove(recipeCategory);

    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredients==null)recipeIngredients=new ArrayList<>();
        if (!recipeIngredients.contains(recipeIngredient))
        {
            recipeIngredient.setRecipe(this);
            recipeIngredients.add(recipeIngredient);
        }
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){

        if (recipeIngredients==null)recipeIngredients=new ArrayList<>();
        if (!recipeIngredients.contains(recipeIngredient))
        {
            recipeIngredient.setRecipe(null);
            recipeIngredients.remove(recipeIngredient);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Set<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Set<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}
