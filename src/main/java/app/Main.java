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
        // TODO: add the Logout Use Case to the app using the appBuilder DONE
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addChangePasswordUseCase()
                                            .addLogoutUseCase()
                                            // added this line above
                                            .addIngredientSearchView()
                                            .addIngredientSearchUseCase()
                                            .addLoadSavedRecipeView()
                                            .addLoadSavedRecipeUseCase()
                                            .addResultView()
                                            .build();

        application.pack();
        application.setVisible(true);
    }
}
