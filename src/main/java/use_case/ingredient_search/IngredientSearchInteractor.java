package use_case.ingredient_search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import data_access.IngredientSearchDataAccessObject;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.Result;
import entity.ResultFactoryInterface;

/**
 * Handles the core logic for searching recipes by ingredients.
 *
 * <p>
 * The IngredientSearchInteractor class implements the ingredient search use case. It processes
 * the input data, performs the search logic, and coordinates with necessary components such as
 * data repositories and output boundaries to produce results. This class is part of the business
 * logic layer and ensures the application logic for ingredient-based recipe searches is executed.
 * </p>
 */

public class IngredientSearchInteractor implements IngredientSearchInputBoundary {

    private final IngredientSearchOutputBoundary ingredientSearchPresenter;
    private final ResultFactoryInterface resultFactory;
    private final GenericRecipeFactoryInterface genericRecipeFactory;
    private final IngredientSearchDataAccessObject ingredientSearchDataAccessObject;

    public IngredientSearchInteractor(IngredientSearchOutputBoundary ingredientSearchOutputBoundary,
                                      ResultFactoryInterface resultFactory,
                                      GenericRecipeFactoryInterface genericRecipeFactory,
                                      IngredientSearchDataAccessObject ingredientSearchDataAccessObject) {

        this.ingredientSearchPresenter = ingredientSearchOutputBoundary;
        this.genericRecipeFactory = genericRecipeFactory;
        this.ingredientSearchDataAccessObject = ingredientSearchDataAccessObject;
        this.resultFactory = resultFactory;
    }

    @Override
    public void execute(IngredientSearchInputData ingredientSearchInputData) throws IOException {
        // recipe title and id
        final Map<String, String> response =
                ingredientSearchDataAccessObject.excuteSearch(ingredientSearchInputData.getIngredients());
        final ArrayList<GenericRecipe> recipeArrayList = new ArrayList<>();

        for (String key : response.keySet()) {
            final GenericRecipe recipe = genericRecipeFactory.createGenericRecipe(key, response.get(key));
            // add generic recipe to list
            recipeArrayList.add(recipe);
        }
        // contains array list of generic recipes
        final Result result = resultFactory.createResult(recipeArrayList);
        final IngredientSearchOutputData ingredientSearchOutputData =
                new IngredientSearchOutputData(result, false);
        ingredientSearchPresenter.prepareSuccessView(ingredientSearchOutputData);
    }

}
