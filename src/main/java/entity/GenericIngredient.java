package entity;

/**
 * Represents an ingredient with its name, quantity, and whether it is substitutable.
 */
public class GenericIngredient implements Ingredient {

    private final String name;
    private String quantity;
    private final boolean isSubstitutable;

    /**
     * Constructs an Ingredient object with the specified name, quantity, and substitutability.
     *
     * @param name              The name of the ingredient.
     * @param quantity          The quantity of the ingredient.
     * @param isSubstitutable  Whether the ingredient can be substituted.
     */
    public GenericIngredient(String name, String quantity, boolean isSubstitutable) {
        this.name = name;
        this.quantity = quantity;
        this.isSubstitutable = isSubstitutable;
    }

    /**
     * Updates the quantity of the ingredient.
     *
     * @param newQuantity The new quantity of the ingredient with the new quantity.
     */
    public void updateQuantity(String newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Retrieves the information about the ingredient.
     * This includes the name, quantity, and whether it is substitutable.
     *
     * @return An array of objects containing the ingredient's name, quantity, and substitutability status.
     */
    public Object[] getIngredientInfo() {
        return new Object[]{this.name, this.quantity, this.isSubstitutable};
    }
}
