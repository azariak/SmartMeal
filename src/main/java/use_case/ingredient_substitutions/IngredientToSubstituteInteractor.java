package use_case.ingredient_substitutions;

// import use_case.ingredient_substitutions.IngredientToSubstituteDataAccessInterface;

import java.io.IOException;

/**
 * Interactor for retrieving ingredient substitutes.
 */
public class IngredientToSubstituteInteractor implements IngredientToSubstituteInputBoundary {
    private final IngredientToSubstituteDataAccessInterface dataAccess;
    private final IngredientToSubstituteOutputBoundary outputBoundary;

    public IngredientToSubstituteInteractor(IngredientToSubstituteDataAccessInterface dataAccess,
                                            IngredientToSubstituteOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getSubstitute(IngredientToSubstituteInputData inputData) {
        try {
            // Retrieve substitutes from the data access layer
            final String substitutesJson = dataAccess.getIngredientSubstitutes(inputData.getIngredientName());

            // Create output data and pass it to the output boundary
            final IngredientToSubstituteOutputData outputData = new IngredientToSubstituteOutputData(substitutesJson);
            outputBoundary.presentSubstitute(outputData);
        }
        catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
            // Handle errors or pass error info to the output boundary as needed
        }
    }
}
