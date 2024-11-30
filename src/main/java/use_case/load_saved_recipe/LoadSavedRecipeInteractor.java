package use_case.load_saved_recipe;

import data_access.InMemoryUserDataAccessObject;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;
import data_access.FileRecipeSaver;
import entity.GenericRecipe;

import java.awt.*;
import java.util.stream.Collectors;

/**
 * The Load saved recipe Interactor.
 */
public class LoadSavedRecipeInteractor implements LoadSavedRecipeInputBoundary {

    private final InMemoryUserDataAccessObject loadSavedRecipeDataAccessObject;
    private final LoadSavedRecipeOutputBoundary loadSavedRecipePresenter;
//    private final FileRecipeSaver recipeSaver;

    public LoadSavedRecipeInteractor(InMemoryUserDataAccessObject loadSavedRecipeDataAccessObject,
                                     LoadSavedRecipeOutputBoundary loadSavedRecipeOutputBoundary) {

        this.loadSavedRecipeDataAccessObject = loadSavedRecipeDataAccessObject;
        this.loadSavedRecipePresenter = loadSavedRecipeOutputBoundary;
//        this.recipeSaver = recipeSaver;
    }

    @Override
    public void execute(LoadSavedRecipeInputData loadsavedrecipeInputData) {
        final String recipe1 = loadsavedrecipeInputData.getRecipe1();
        final String recipe2 = loadsavedrecipeInputData.getRecipe2();
        final String recipe3 = loadsavedrecipeInputData.getRecipe3();
        loadSavedRecipePresenter.prepareResultView(recipe1, recipe2, recipe3);
    }

    @Override
    public void switchToResultView() {
        loadSavedRecipePresenter.switchToResultView();
    }

    @Override
    public void backToLastView() {
        loadSavedRecipePresenter.backToLastView();
    }

//    @Override
//    public List getAllSavedRecipes() {
//        return recipeSaver.loadAll().stream()
//                .map(GenericRecipe::getName)
//                .collect(Collectors.toList());
//    }

    @Override
    public LoadSavedRecipeViewModel getViewModel() {
        return null;
    }
}
