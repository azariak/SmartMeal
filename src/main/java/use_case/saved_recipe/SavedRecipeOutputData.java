package use_case.saved_recipe;

/**
 * Output Data for the saved recipe Use Case.
 */
public class SavedRecipeOutputData {

    private final String recipeName;
    private final boolean useCaseFailed;

    public SavedRecipeOutputData(String recipeName, boolean useCaseFailed) {
        this.recipeName = recipeName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
