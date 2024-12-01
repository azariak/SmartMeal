package data_access;

import java.util.ArrayList;

import use_case.ingredient_substitutions.SubstitutesDataAccessInterface;

/**
 * The data access object for the ingredient substitutions use case.
 */
public class SubstitutesDataAccessObject implements SubstitutesDataAccessInterface {
    private final ApiAccessKeyManagerInterface keyManager;

    public SubstitutesDataAccessObject(ApiAccessKeyManagerInterface keyManager) {
        this.keyManager = keyManager;
    }

    @Override
    public ArrayList<String> getIngredientSubstitutes(String ingredientName) {
        final ArrayList<String> ingredientSubstitutes =
                IngredientNameToSubstitutes.ingredientNameToSubstitutes(ingredientName, keyManager);
        return new ArrayList<>(ingredientSubstitutes);
    }
}
