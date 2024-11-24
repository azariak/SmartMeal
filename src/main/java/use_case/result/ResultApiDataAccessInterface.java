package use_case.result;

/**
 * Data access interface for result use case.
 */
public interface ResultApiDataAccessInterface {

    /**
     * Excute the api call for recipe details.
     * @param id the id of the recipe.
     */
    void execute(String id);

}
