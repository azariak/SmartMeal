package use_case.saved_recipe;

public interface SavedRecipeInputBoundary {
    void execute(SavedRecipeInputData savedrecipeInputData);

    void switchToResultView();
}
