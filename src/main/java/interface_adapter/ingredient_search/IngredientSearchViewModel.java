package interface_adapter.ingredient_search;

import interface_adapter.ViewModel;

public class IngredientSearchViewModel extends ViewModel<IngredientSearchState> {
    public IngredientSearchViewModel() {
        super("Ingredient Search");
        setState(new IngredientSearchState());
    }
}
