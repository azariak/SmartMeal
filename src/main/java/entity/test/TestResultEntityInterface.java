package entity.test;

import java.util.ArrayList;

/**
 * The interface for test result entity.
 */
public interface TestResultEntityInterface {

    /**
     * Get recipe names.
     * @return array list of recipe names in strings.
     */
    ArrayList<String> getRecipeNames();

    /**
     * Get recipe id from recipe name.
     * @param recipeName recipe name
     * @return recipe id
     */
    String getRecipeId(String recipeName);

}
