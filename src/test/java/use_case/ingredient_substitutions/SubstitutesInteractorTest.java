package use_case.ingredient_substitutions;

import data_access.SubstitutesDataAccessObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class SubstitutesInteractorTest {

    private SubstitutesInteractor interactor;
    private SubstitutesOutputBoundary mockPresenter;
    private SubstitutesDataAccessObject mockDataAccess;
    private SubstitutesInputData mockInputData;

    @BeforeEach
    void setUp() {
        mockPresenter = mock(SubstitutesOutputBoundary.class);
        mockDataAccess = mock(SubstitutesDataAccessObject.class);
        interactor = new SubstitutesInteractor(mockPresenter, mockDataAccess);
        mockInputData = mock(SubstitutesInputData.class);

        when(mockInputData.getIngredientName()).thenReturn("Sugar");
    }

    @AfterEach
    void tearDown() {
        interactor = null;
        mockPresenter = null;
        mockDataAccess = null;
        mockInputData = null;
    }

    @Test
    void execute() {
        ArrayList<String> substitutes = new ArrayList<>();
        substitutes.add("Honey");
        substitutes.add("Maple Syrup");

        when(mockDataAccess.getIngredientSubstitutes("Sugar")).thenReturn(substitutes);

        interactor.execute(mockInputData);

        SubstitutesOutputData expectedOutputData = new SubstitutesOutputData("Sugar", substitutes, false);
        verify(mockPresenter).prepareSuccessView(refEq(expectedOutputData));
    }

    @Test
    void backToLastView() {
        interactor.backToLastView();
        verify(mockPresenter).backToLastView();
    }
}
