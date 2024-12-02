package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The api access key manager.
 */
public class ApiAccessKeyManager implements ApiAccessKeyManagerInterface {
    public static final String ENV_API_KEY = System.getenv("API_KEY");
    public static final Integer ENV_API_MAX = 100;

    // A map that stores the api keys and a boolean that records if they are still valid (have not reached limit).
    private final Map<String, Boolean> apiKeyMap;
    private Boolean allInvalid = false;

    public ApiAccessKeyManager() {
        this.apiKeyMap = new HashMap<>();
    }

    @Override
    public void addApiKeys(ArrayList<String> apiKeys) {
        for (String apiKey : apiKeys) {
            this.apiKeyMap.put(apiKey, true);
            System.out.println("Api Access Key Manager: Valid Api Key: " + apiKey + " added to manager");
        }
    }

    @Override
    public String getValidApiKey() {
        // If all keys are not valid, return the default api access key.

        String result = "";
        for (String apiKey : apiKeyMap.keySet()) {
            if (apiKeyMap.get(apiKey)) {
                result = apiKey;
                System.out.println("Api Access Key Manager: Valid Api Key: " + result + " Provided to Api DAO");
                break;
            }
        }
        // If no valid keys are found, return the key in environment and set allInvalid to true.
        if (result.isEmpty()) {
            allInvalid = true;
            System.out.println("Api Access Key Manager: Error: All Api key are invalid, returning environment Api key");
            System.out.println("Api Access Key Manager: Environment Api key: " + ENV_API_KEY + " Provided to Api DAO");
            result = ENV_API_KEY;
        }

        return result;
    }

    @Override
    public void setKeyInvalid(String apiKey) {
        apiKeyMap.put(apiKey, false);
        System.out.println("Api Access Key Manager: " + apiKey + " is not valid");
    }

    @Override
    public boolean allKeyInvalid() {
        return allInvalid;
    }

    @Override
    public void addApiKeysToApiKeyManager() {
        final ArrayList<String> apiKeys = new ArrayList<>();

        for (int i = 1; i < ENV_API_MAX; i++) {

            final String apiKey = System.getenv("API_KEY" + i);
            if (apiKey != null) {
                apiKeys.add(apiKey);
            }
            else {
                break;
            }

        }

        addApiKeys(apiKeys);
    }
}
