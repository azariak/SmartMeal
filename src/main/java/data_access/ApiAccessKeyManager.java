package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The api access key manager.
 */
public class ApiAccessKeyManager implements ApiAccessKeyManagerInterface {

    // A map that stores the api keys and a boolean that records if they are still valid (have not reached limit).
    private final Map<String, Boolean> apiKeyMap;

    public ApiAccessKeyManager() {
        this.apiKeyMap = new HashMap<>();
    }

    @Override
    public void addApiKeys(ArrayList<String> apiKeys) {
        for (String apiKey : apiKeys) {
            this.apiKeyMap.put(apiKey, true);
            System.out.println("Valid Api Key: " + apiKey + " added to manager");
        }
    }

    @Override
    public String getValidApiKey() {
        // If all keys are not valid, return the default api access key.
        String result = "e171f919be014c5aab8977a975d27931";
        for (String apiKey : apiKeyMap.keySet()) {
            if (apiKeyMap.get(apiKey)) {
                result = apiKey;
            }
        }
        System.out.println("Valid Api Key: " + result + " Provided to Api DAO");
        return result;
    }

    @Override
    public void setKeyInvalid(String apiKey) {
        apiKeyMap.put(apiKey, false);
        System.out.println(apiKey + " is not valid");
    }
}
