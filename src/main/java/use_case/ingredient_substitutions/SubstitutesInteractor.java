package use_case.ingredient_substitutions;

import data_access.SubstitutesDataAccessObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The Substitutes interactor.
 */
public class SubstitutesInteractor implements SubstitutesInputBoundary {

    private final SubstitutesDataAccessInterface substitutesDataAccessObject;
    private final SubstitutesOutputBoundary substitutesPresenter;

    public SubstitutesInteractor(SubstitutesOutputBoundary substitutesOutputBoundary,
                                 SubstitutesDataAccessObject substitutesDataAccessObject) {
        this.substitutesDataAccessObject = substitutesDataAccessObject;
        this.substitutesPresenter = substitutesOutputBoundary;
    }

    @Override
    public void execute(SubstitutesInputData substitutesInputData) {
        final String ingredientName = substitutesInputData.getIngredientName();
        final ArrayList<String> ingredientSubstitutes = substitutesDataAccessObject.getIngredientSubstitutes(ingredientName);
        final SubstitutesOutputData substitutesOutputData = new SubstitutesOutputData(ingredientSubstitutes, false);
        substitutesPresenter.prepareSuccessView(substitutesOutputData);
    }

    @Override
    public void backToLastView() {
        substitutesPresenter.backToLastView();
    }
}
