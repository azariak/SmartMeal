package use_case.ingredient_substitutions;

import java.util.ArrayList;

import data_access.SubstitutesDataAccessObject;

/**
 * The interactor for the ingredient substitutes use case.
 */
public class SubstitutesInteractor implements SubstitutesInputBoundary {

    private final SubstitutesDataAccessObject substitutesDataAccessObject;
    private final SubstitutesOutputBoundary substitutesPresenter;

    public SubstitutesInteractor(SubstitutesOutputBoundary substitutesOutputBoundary,
                                 SubstitutesDataAccessObject substitutesDataAccessObject) {
        this.substitutesDataAccessObject = substitutesDataAccessObject;
        this.substitutesPresenter = substitutesOutputBoundary;
    }

    @Override
    public void execute(SubstitutesInputData substitutesInputData) {
        final String ingredientName = substitutesInputData.getIngredientName();
        final ArrayList<String> ingredientSubstitutes = substitutesDataAccessObject.getSubstitutes(ingredientName);
        System.out.println(ingredientSubstitutes.toString());
        final SubstitutesOutputData substitutesOutputData =
                new SubstitutesOutputData(ingredientName, ingredientSubstitutes, false);
        substitutesPresenter.prepareSuccessView(substitutesOutputData);
    }

    @Override
    public void backToLastView() {
        substitutesPresenter.backToLastView();
    }
}
