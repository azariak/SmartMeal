//package view;
//
//
//import entity.GenericIngredient;
//import entity.Ingredient;
//
//import javax.swing.*;
//import java.util.HashMap;
//
//
//public class RecipeDetailView {
//
//
//    private final String viewName = "RecipeDetailView";
//
//    private final JButton backButton = new JButton("Back");
//    private final JButton saveButton = new JButton("Save");
//
//
//    private final String recipeLabel = "recipe name: ";
//    private final String recipeName;
//
//    private HashMap<String, String> ingredientNameToQuantity = new HashMap<>();
//    private final String instructions;
//
//
//    public RecipeDetailView(String recipe_name, GenericIngredient[] ingredients, String instructions) {
//        this.recipeName = recipe_name;
//        for (GenericIngredient ingredient: ingredients) {
//            Object[] ingredientInfo = ingredient.getIngredientInfo();
//
//                    ingredientNameToQuantity.put(GenericIngredient.name, GenericIngredient.quantity);
//        }
//        this.instructions = instructions;
//    }
//
//    public RecipeDetailView() {
//        this.recipeName = "";
//        this.
//    }
//}
//
