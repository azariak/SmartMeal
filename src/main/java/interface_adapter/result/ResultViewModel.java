package interface_adapter.result;

import interface_adapter.ViewModel;

public class ResultViewModel extends ViewModel<ResultViewState> {
    public ResultViewModel() {
        super("Result");
        setState(new ResultViewState());
    }
}