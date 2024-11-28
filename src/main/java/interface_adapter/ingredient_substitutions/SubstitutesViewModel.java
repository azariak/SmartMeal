package interface_adapter.ingredient_substitutions;

import interface_adapter.ViewModel;

/**
 * View Model for ingredient substitutions Use Case.
 */
public class SubstitutesViewModel extends ViewModel<SubstitutesState> {
    public SubstitutesViewModel() {
        super("Substitutes");
        setState(new SubstitutesState());
    }
}
