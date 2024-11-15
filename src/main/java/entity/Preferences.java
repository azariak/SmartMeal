package entity;

/**
 * The representation of Preferences in our program.
 */
public interface Preferences {

    /**
     * A method to add a dietary restriction.
     * @param restriction is the dietary restriction you want to add.
     */
    void addrestriction(String restriction);

    /**
     * A method to remove a dietary restriction.
     * @param restriction is the restriction you want to remove
     */
    void removerestriction(String restriction);

    /**
     * A method to add a preferred substitute ingredient.
     * @param ingredientName is the name of the ingredient you have a preferred substitute for.
     * @param preferredSubstitute is the name of the ingredient which is the preferred substitute you want to add.
     */
    void addpreferredsubstitute(String ingredientName, String preferredSubstitute);

    /**
     * A method to remove a preferred substitute ingredient.
     * @param ingredientName is the name of the ingredient you have a preferred substitute for.
     * @param preferredSubstitute is the name of the ingredient which is the preferred substitute you want to remove.
     */
    void removepreferredsubstitute(String ingredientName, String preferredSubstitute);
}
