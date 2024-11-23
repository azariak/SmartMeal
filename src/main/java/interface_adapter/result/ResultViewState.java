package interface_adapter.result;

import entity.GenericResult;

/**
 * The state for the result view.
 */
public class ResultViewState {

    private GenericResult result;

    public ResultViewState() {
    }

    public GenericResult getResult() {
        return result;
    }

    public void setResult(GenericResult result) {
        this.result = result;
    }
}
