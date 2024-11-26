package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addChangePasswordUseCase()
                                            .addLogoutUseCase()
                                            .addRankedView()
                                            // added this line above
                                            .addResultView()
                                            .addResultUseCase()
                                            .addIngredientSearchView()
                                            .addIngredientSearchUseCase()
                                            .addRecipeDetailView()
                                            .addRecipeDetailUseCase()
                                            .addLoadSavedRecipeView()
                                            .addLoadSavedRecipeUseCase()
                                            .addMainMenuView()
                                            .addMainMenuUseCase()
                                            .build();

        application.pack();
        application.setVisible(true);
    }
}
