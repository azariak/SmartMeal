package use_case.api_tests;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import use_case.login.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import data_access.IngredientsToRecipeID;
import java.util.HashMap;
import java.util.Map;

class IngredientsToRecipeIDTest {
    @Test
    void successTest() {
        Map<String, Integer> recipes = IngredientsToRecipeID.ingredientsToRecipeID("tomato,cheese,basil");
        System.out.println(recipes);
    }
}


