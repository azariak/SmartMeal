package use_case.saved_recipe;

/**
 * Input Data for Saving Use Case.
 */
public class SavedRecipeInputData {

    private String recipeName;
    private String recipeDescription;

    public SavedRecipeInputData(String recipeName, String recipeDescription) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
    }
}
