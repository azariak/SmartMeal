package use_case.back;

import org.junit.jupiter.api.Test;

class BackInteractorTest {

    @Test
    void backToLastView() {

        BackOutputBoundary backPresenter = new BackOutputBoundary() {
            @Override
            public void backToLastView() {
                assert true;
            }
        };
        BackInputBoundary backInteractor = new BackInteractor(backPresenter);
        backInteractor.backToLastView();

    }
}