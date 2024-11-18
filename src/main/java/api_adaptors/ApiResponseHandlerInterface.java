package api_adaptors;

import java.util.ArrayList;

public interface ApiResponseHandlerInterface {

    /**
     * Return arraylist of IdSearchResponseResultObjects.
     * @return
     */
    ArrayList<IdSearchResponseResultObject> responseOutput();
}
