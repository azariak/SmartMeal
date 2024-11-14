package interface_adapter.result;

import interface_adapter.ViewModel;

public class ResultViewModel extends ViewModel<ResultViewState> {
    public ResultViewModel() {
        // super("Result");
        // TODO: line below is for demo.
        super("Demo Result View");
        setState(new ResultViewState());
    }
}