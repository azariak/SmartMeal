package use_case.load_saved_recipe;

/**
 * The Input Data for the Load saved recipe Use Case.
 */
public class LoadSavedRecipeInputData {
    private final String recipe1;
    private final String recipe2;
    private final String recipe3;

    public LoadSavedRecipeInputData(String recipe1, String recipe2, String recipe3) {
        this.recipe1 = recipe1;
        this.recipe2 = recipe2;
        this.recipe3 = recipe3;
    }

    String getRecipe1() {
        return recipe1;
    }

    String getRecipe2() {
        return recipe2;
    }

    String getRecipe3() {
        return recipe3;
    }

}
