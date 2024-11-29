package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A representation of a Generic Preference in our program.
 */
public class GenericPreferences implements Preferences {

    private final List<String> dietaryRestrictions;
    private final Map<String, List<String>> preferredSubstitutes;

    public GenericPreferences(List<String> dietaryRestrictions, Map<String, List<String>> preferredSubstitutes) {
        this.dietaryRestrictions = dietaryRestrictions;
        this.preferredSubstitutes = preferredSubstitutes;
    }

    public GenericPreferences() {
        this.dietaryRestrictions = new ArrayList<>();
        this.preferredSubstitutes = new HashMap<>();
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * A function that returns the users preferred substitutes for each ingredient.
     * @return the users preferred substitutes for each ingredient.
     */
    public Map<String, List<String>> getPreferredSubstitutes() {
        return preferredSubstitutes;
    }

    /**
     * A function that returns the users preferred substitutes for a given ingredient name.
     * @param ingredientName is the name of the ingredient.
     * @return the users preferred substitutes for a given ingredient name.
     */
    public List<String> getPreferredSubstitutes(String ingredientName) {
        return preferredSubstitutes.get(ingredientName);
    }

    /**
     * A method to add a dietary restriction.
     * @param restriction is the dietary restriction you want to add.
     */
    public void addrestriction(String restriction) {
        dietaryRestrictions.add(restriction);
    }

    /**
     * A method to remove a dietary restriction.
     * @param restriction is the restriction you want to remove
     */
    public void removerestriction(String restriction) {
        dietaryRestrictions.remove(restriction);
    }

    /**
     * A method to add a preferred substitute ingredient.
     * @param ingredientName is the name of the ingredient you have a preferred substitute for.
     * @param preferredSubstitute is the name of the ingredient which is the preferred substitute you want to add.
     */
    public void addpreferredsubstitute(String ingredientName, String preferredSubstitute) {
        if (!preferredSubstitutes.containsKey(ingredientName)) {
            this.preferredSubstitutes.put(ingredientName, new ArrayList<>());
        }
        this.preferredSubstitutes.get(ingredientName).add(preferredSubstitute);
    }

    /**
     * A method to remove a preferred substitute ingredient.
     * @param ingredientName is the name of the ingredient you have a preferred substitute for.
     * @param preferredSubstitute is the name of the ingredient which is the preferred substitute you want to remove.
     */
    public void removepreferredsubstitute(String ingredientName, String preferredSubstitute) {
        if (preferredSubstitutes.containsKey(ingredientName)) {
            final List<String> substitutes = preferredSubstitutes.get(ingredientName);

            if (substitutes.remove(preferredSubstitute)) {
                if (substitutes.isEmpty()) {
                    preferredSubstitutes.remove(ingredientName);
                }
            }
        }
    }
}

