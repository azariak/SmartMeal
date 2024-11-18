package entity;

/**
 * A generic recipe entity with basic information of a recipe.
 */
public class GenericRecipe implements GenericRecipeInterface {
    private final String name;
    private final String id;

    public GenericRecipe(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
