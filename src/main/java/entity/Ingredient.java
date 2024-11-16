package entity;

/**
 * A representation of an Ingredient in our program.
 */
public interface Ingredient {

    /**
     * A method that updates the quantity of an ingredient.
     * @param newQuantity is the new quantity you want to update it with.
     */
    void updateQuantity(String newQuantity);

    /**
     * A method that gets the ingredient information for a given ingredient.
     * @return the relevant ingredient information.
     */
    Object[] getIngredientInfo();
}
