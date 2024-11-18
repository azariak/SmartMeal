package entity;

/**
 * The advanced recipe entity.
 */
public class AdvancedRecipe extends GenericRecipe implements AdvancedRecipeInterface {
    private String id;
    private String name;

    public AdvancedRecipe(String id, String name) {
        super(name, id);
    }

    @Override
    public String getingredients() {
        return "";
    }

    @Override
    public String getnutrition() {
        return "";
    }

    @Override
    public String getrecipename() {
        return "";
    }

    @Override
    public int getcooktime() {
        return 0;
    }

    @Override
    public String getsimilarrecipe() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getId() {
        return "";
    }
}
