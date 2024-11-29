package interface_adapter.result;

import entity.GenericResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewStateTest {
    private final ResultViewState resultViewState = new ResultViewState();
    private final GenericResult genericResult = new GenericResult();

    @BeforeEach
    void setUp() {
        resultViewState.setResult(genericResult);
    }

    @AfterEach
    void tearDown() {
        resultViewState.setResult(genericResult);
    }

    @Test
    void getResult() {
        assertEquals(genericResult, resultViewState.getResult());
    }

    @Test
    void setResult() {
        GenericResult temp = new GenericResult();
        resultViewState.setResult(temp);
        assertEquals(temp, resultViewState.getResult());
        assertNotEquals(genericResult, resultViewState.getResult());
    }
}