package use_case.ingredient_search;

public class IngredientSearchInteractor implements IngredientSearchInputBoundary {
    private final IngredientSearchDataAccessInterface ingredientSearchDataAccessObject;
    private final IngredientSearchOutputBoundary ingredientSearchPresenter;

    public IngredientSearchInteractor(IngredientSearchDataAccessInterface ingredientSearchDataAccessObject,
                                      IngredientSearchOutputBoundary ingredientSearchOutputBoundary) {

        this.ingredientSearchDataAccessObject = ingredientSearchDataAccessObject;
        this.ingredientSearchPresenter = ingredientSearchOutputBoundary;
    }

    @Override
    public void execute(IngredientSearchInputData ingredientSearchInputData) {
        final String ingredient1 = ingredientSearchInputData.getIngredient1();
        final String ingredient2 = ingredientSearchInputData.getIngredient2();
        final String ingredient3 = ingredientSearchInputData.getIngredient3();

        ingredientSearchPresenter.prepareResultView(ingredient1, ingredient2, ingredient3);
        }
}
