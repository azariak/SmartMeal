package interface_adapter.Ranked;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

/**
 * The ViewModel for the Ranked View.
 */
public class RankedViewModel extends ViewModel<RankedViewState> {

    public RankedViewModel() {
        super("Ranked Recipes View");
        setState(new RankedViewState());
    }

}
