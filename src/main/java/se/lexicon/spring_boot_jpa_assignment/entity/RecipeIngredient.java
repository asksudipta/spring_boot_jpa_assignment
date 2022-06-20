package se.lexicon.spring_boot_jpa_assignment.entity;

public class RecipeIngredient {
    private int id;
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    private Recipe recipe;

}
