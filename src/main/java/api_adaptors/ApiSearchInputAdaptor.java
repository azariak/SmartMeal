package api_adaptors;

import java.util.ArrayList;

/**
 * The Boundary for ingredient search output.
 */
public interface ApiSearchInputAdaptor {

    /**
     * Convert the ingredient search queries to api call.
     *
     * @param ingredients an arraylist of ingredients in strings
     */
    void inputToApiCall(ArrayList<String> ingredients);

    /**
     * Excutes the api call and then pass the result to result api adaptor.
     * @param ingredients ingredients
     */
    void excuteApiCall(String ingredients);
}