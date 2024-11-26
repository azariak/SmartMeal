package use_case.recipe_detail;

import java.util.ArrayList;

import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.TemporaryAdvancedRecipe;

/**
 * The Recipe Detail Interactor.
 */
public class RecipeDetailInteractor implements RecipeDetailInputBoundary {

    private final RecipeDetailDataAccessInterface recipeDetailDataAccessObject;
    private final RecipeDetailOutputBoundary recipeDetailPresenter;
    private final GenericRecipeFactoryInterface genericRecipeFactory;

    public RecipeDetailInteractor(RecipeDetailDataAccessInterface recipeDetailDataAccessInterface,
                                  RecipeDetailOutputBoundary recipeDetailOutputBoundary,
                                  GenericRecipeFactoryInterface genericRecipeFactory) {
        this.recipeDetailDataAccessObject = recipeDetailDataAccessInterface;
        this.recipeDetailPresenter = recipeDetailOutputBoundary;
        this.genericRecipeFactory = genericRecipeFactory;
    }

    @Override
    public void execute(RecipeDetailInputData recipeDetailInputData) {
        final GenericRecipe genericRecipe = recipeDetailInputData.getGenericRecipe();
        final ArrayList<Integer> ingredientIds = recipeDetailDataAccessObject.getIngredientIds(genericRecipe);

        final String recipeName = genericRecipe.getName();
        final ArrayList<String> ingredientNames = recipeDetailDataAccessObject.getIngredientsNames(ingredientIds);
        final ArrayList<String> ingredientQuantities = recipeDetailDataAccessObject.getQuantities(genericRecipe);
        final String instructions = recipeDetailDataAccessObject.getInstructions(genericRecipe);

        final TemporaryAdvancedRecipe temporaryAdvancedRecipe = genericRecipeFactory.createTemporaryAdvancedRecipe(
                recipeName,
                ingredientNames,
                ingredientQuantities,
                instructions);
        final RecipeDetailOutputData recipeDetailOutputData = new RecipeDetailOutputData(temporaryAdvancedRecipe,
                false);

        recipeDetailPresenter.prepareSuccessView(recipeDetailOutputData);
    }
}
