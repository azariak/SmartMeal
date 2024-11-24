package interface_adapter.result;

import interface_adapter.ViewModel;

/**
 * The view model for the result view.
 */
public class ResultViewModel extends ViewModel<ResultViewState> {
    public ResultViewModel() {
        super("Result View");
        setState(new ResultViewState());
    }

}
