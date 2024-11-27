package data_access;

import java.util.ArrayList;

import use_case.ingredient_substitutions.SubstitutesDataAccessInterface;

/**
 * The data access object for the ingredient substitutions use case.
 */
public class SubstitutesDataAccessObject implements SubstitutesDataAccessInterface {

    @Override
    public ArrayList<String> getIngredientSubstitutes(String ingredientName) {
        final ArrayList<String> ingredientSubstitutes = IngredientNameToSubstitutes.ingredientNameToSubstitutes(ingredientName);
        return new ArrayList<>(ingredientSubstitutes);
    }
}
