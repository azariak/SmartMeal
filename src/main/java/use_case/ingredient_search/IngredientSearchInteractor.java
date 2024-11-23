package use_case.ingredient_search;

import api_adaptors.ApiSearchInputAdaptor;
import api_adaptors.IngredientSearchInputAdaptor;
import data_access.ApiSearchDataAccessObject;
import entity.*;
import use_case.signup.SignupOutputData;

import java.util.HashMap;
import java.util.Map;

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
    private final ApiSearchDataAccessObject apiSearchDataAccessObject;

    public IngredientSearchInteractor(IngredientSearchDataAccessInterface ingredientSearchDataAccessObject,
                                      IngredientSearchOutputBoundary ingredientSearchOutputBoundary,
                                      ResultFactoryInterface resultFactory,
                                      GenericRecipeFactoryInterface genericRecipeFactory,
                                      ApiSearchDataAccessObject apiSearchDataAccessObject) {

        this.ingredientSearchPresenter = ingredientSearchOutputBoundary;
        this.genericRecipeFactory = genericRecipeFactory;
        this.apiSearchDataAccessObject = apiSearchDataAccessObject;
        this.resultFactory = resultFactory;
    }

    @Override
    public void execute(IngredientSearchInputData ingredientSearchInputData) {
        final Map<String, String> response =
                apiSearchDataAccessObject.excuteSearch(ingredientSearchInputData.getIngredients());

        for (key : response.keySet()) {
            final GenericRecipe recipe = genericRecipeFactory.createGenericRecipe(key, response.get(key));
        }


        final GenericRecipe recipe = genericRecipeFactory.createGenericRecipe(, );
        userDataAccessObject.save(user);

        final SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
        userPresenter.prepareSuccessView(signupOutputData);
    }

    @Override
    public void switchToResultView() {
        ingredientSearchPresenter.switchToDemoResultView();
    }
}
