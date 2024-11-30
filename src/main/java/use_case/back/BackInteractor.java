package use_case.back;

/**
 * The interactor for the back use case.
 */
public class BackInteractor implements BackInputBoundary {
    private final BackOutputBoundary backPresenter;

    public BackInteractor(BackOutputBoundary backPresenter) {
        this.backPresenter = backPresenter;
    }

    @Override
    public void backToLastView() {
        backPresenter.backToLastView();
    }
}
