package interface_adapter.ranked;

import entity.GenericRecipeInterface;
import use_case.ranked.RankedInputBoundary;
import use_case.ranked.RankedInputData;

/**
 * The controller for ranked use case.
 */
public class RankedController {
    private final RankedInputBoundary rankedUseCaseInteractor;

    public RankedController(RankedInputBoundary rankedUseCaseInteractor) {
        this.rankedUseCaseInteractor = rankedUseCaseInteractor;
    }

    /**
     * Executes ranking for a recipe.
     * @param recipe the recipe to search.
     */
    public void execute(GenericRecipeInterface recipe) {
        final RankedInputData resultInputData = new RankedInputData(recipe);
        rankedUseCaseInteractor.execute(resultInputData);
    }

    /**
     * Back to last view.
     */
    public void backToLastView() {
        rankedUseCaseInteractor.backToLastView();
    }

    /**
     * Updates the star rating for a recipe.
     * @param recipeId the ID of the recipe
     * @param starRating the new star rating
     */
    public void updateStarRating(String recipeId, int starRating) {
        rankedUseCaseInteractor.updateStarRating(recipeId, starRating);
    }
}
