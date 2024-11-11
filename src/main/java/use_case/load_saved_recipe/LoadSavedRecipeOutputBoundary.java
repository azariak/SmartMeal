package use_case.load_saved_recipe;

import use_case.login.LoginOutputData;

/**
 * The output boundary for the Load Saved Recipe Use Case.
 */
public interface LoadSavedRecipeOutputBoundary {

    /**
     * Prepares the success view for the Load Saved Recipe Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(LoadSavedRecipeOutputData outputData);

    /**
     * Prepares the failure view for the Load Saved Recipe Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
