package interface_adapter.ingredient_substitutions;
import interface_adapter.ViewManagerModel;
import use_case.ingredient_substitutions.SubstitutesOutputBoundary;
import use_case.ingredient_substitutions.SubstitutesOutputData;

public class SubstitutesPresenter implements SubstitutesOutputBoundary {

    private final SubstitutesViewModel substitutesViewModel;
    private final ViewManagerModel viewManagerModel;

    public SubstitutesPresenter(SubstitutesViewModel substitutesViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.substitutesViewModel = substitutesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SubstitutesOutputData substitutesOutputData) {
        final SubstitutesState substitutesState = substitutesViewModel.getState();
        substitutesState.setIngredientSubstitutes(substitutesOutputData.getIngredientSubstitutes());
    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
