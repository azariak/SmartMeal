package data_access;

import java.util.ArrayList;

/**
 * The interface for api access key manager.
 * The manager stores api keys for the data access objects.
 */
public interface ApiAccessKeyManagerInterface {
    /**
     * Add api keys to the manager.
     * @param apiKeys Api access keys stored in arraylist as strings.
     */
    void addApiKeys(ArrayList<String> apiKeys);

    /**
     * Retrieve an api key from the manager that is valid (have not reached quota cap).
     * @return An api access key.
     */
    String getValidApiKey();

    /**
     * Set a specific key to be invalid.
     * If the key is not already stored in the manager, store it then mark as invalid.
     * @param apiKey An api key that is invalid.
     */
    void setKeyInvalid(String apiKey);

    /**
     * Check if all keys stored in key manager are invalid.
     * @return Return true if all keys are invalid.
     */
    boolean allKeyInvalid();
}
