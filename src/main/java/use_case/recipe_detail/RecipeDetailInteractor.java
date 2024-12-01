package use_case.recipe_detail;

import java.io.IOException;
import java.util.ArrayList;

import data_access.RecipeDetailDataAccessObject;
import entity.*;

/**
 * The interactor for the Recipe Detail use case.
 */
public class RecipeDetailInteractor implements RecipeDetailInputBoundary {

    private final RecipeDetailDataAccessInterface recipeDetailDataAccessObject;
    private final RecipeDetailOutputBoundary recipeDetailPresenter;
    private final GenericRecipeFactoryInterface genericRecipeFactory;

    public RecipeDetailInteractor(RecipeDetailOutputBoundary recipeDetailOutputBoundary,
                                  GenericRecipeFactoryInterface genericRecipeFactory,
                                  RecipeDetailDataAccessObject recipeDetailDataAccessObject) {
        this.recipeDetailDataAccessObject = recipeDetailDataAccessObject;
        this.recipeDetailPresenter = recipeDetailOutputBoundary;
        this.genericRecipeFactory = genericRecipeFactory;
    }

    @Override
    public void execute(RecipeDetailInputData recipeDetailInputData) throws IOException {
        final GenericRecipeInterface genericRecipe = recipeDetailInputData.getGenericRecipe();
        final ArrayList<Integer> ingredientIds = recipeDetailDataAccessObject.getIngredientIds(genericRecipe);

        final String recipeName = genericRecipe.getName();
        final String recipeId = genericRecipe.getId();
        final ArrayList<String> ingredientNames = recipeDetailDataAccessObject.getIngredientsNames(ingredientIds);
        final ArrayList<String> ingredientQuantities = recipeDetailDataAccessObject.getQuantities(genericRecipe);
        final String instructions = recipeDetailDataAccessObject.getInstructions(genericRecipe);

        final AdvancedRecipeInterface advancedRecipeInterface = genericRecipeFactory.createAdvancedRecipe(
                recipeName,
                recipeId,
                ingredientNames,
                ingredientQuantities,
                instructions);
        final RecipeDetailOutputData recipeDetailOutputData = new RecipeDetailOutputData(advancedRecipeInterface);

        recipeDetailPresenter.prepareSuccessView(recipeDetailOutputData);
    }

    @Override
    public void backToLastView() {
        recipeDetailPresenter.backToLastView();
    }

    @Override
    public void goToGroceryView() { }
}
