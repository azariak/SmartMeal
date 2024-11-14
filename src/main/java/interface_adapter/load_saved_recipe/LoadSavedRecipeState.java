package interface_adapter.load_saved_recipe;

/**
 * The state for the Load Saved Recipe View Model.
 */
public class LoadSavedRecipeState {
    private String recipe1 = "";
    private String recipe2 = "";
    private String recipe3 = "";

    public String getRecipe1() {
        return recipe1;
    }

    public String getRecipe2() {
        return recipe2;
    }

    public String getRecipe3() {
        return recipe3;
    }

    public void setRecipe1(String recipe1) {
        this.recipe1 = recipe1;
    }

    public void setRecipe2(String recipe2) {
        this.recipe2 = recipe2;
    }

    public void setRecipe3(String recipe3) {
        this.recipe3 = recipe3;
    }
}
