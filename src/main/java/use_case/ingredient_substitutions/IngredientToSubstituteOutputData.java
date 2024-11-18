package use_case.ingredient_substitutions;

/**
 * Output data class for presenting ingredient substitutes.
 * Encapsulates the retrieved substitutes as a JSON string.
 */
public class IngredientToSubstituteOutputData {

    /** The JSON string containing the ingredient substitutes. */
    private final String substitutesJson;

    /**
     * Constructs an instance of the output data with the specified substitutes JSON.
     *
     * @param substitutesJson The JSON string containing substitutes.
     */
    public IngredientToSubstituteOutputData(String substitutesJson) {
        this.substitutesJson = substitutesJson;
    }

    /**
     * Retrieves the JSON string containing the ingredient substitutes.
     *
     * @return The substitutes JSON as a string.
     */
    public String getSubstitutesJson() {
        return substitutesJson;
    }
}
