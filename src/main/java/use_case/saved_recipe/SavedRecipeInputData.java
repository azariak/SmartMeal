package use_case.saved_recipe;

/**
 * Input Data for Saving Use Case.
 */
public class SavedRecipeInputData {

    private String recipeName;
    private String recipeDescription;
    private String recipeNutririon;
    private String recipeIngredients;
    private String recipeCalories;

    public SavedRecipeInputData(String recipeName, String recipeDescription, String recipeNutririon,
                                String recipeIngredients, String recipeCalories) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeNutririon = recipeNutririon;
        this.recipeIngredients = recipeIngredients;
        this.recipeCalories = recipeCalories;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeNutririon() {
        return recipeNutririon;
    }

    public void setRecipeNutririon(String recipeNutririon) {
        this.recipeNutririon = recipeNutririon;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeCalories() {
        return recipeCalories;
    }

    public void setRecipeCalories(String recipeCalories) {
        this.recipeCalories = recipeCalories;
    }
}
