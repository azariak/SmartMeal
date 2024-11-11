package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultView extends JPanel {
    // Temp implementation for debug only
    // TODO: figure a way to implement this.
    private final String viewName = "Demo Result View";
    private final String tempRecipeResult;
    private final String tempRecipeName;
    private final String tempRecipeDescription;
    private final String tempRecipeSteps;
    private final ArrayList<String> tempIngredients;

    public ResultView(String tempRecipeResult) throws HeadlessException {
        this.tempRecipeResult = "debug result";
        this.tempRecipeName = "Beef flavoured Ramen";
        this.tempRecipeDescription = "Beef flavoured Ramen";
        this.tempRecipeSteps = "Put the ramen in boiled water for 5 minutes, then add flavour pack";
        this.tempIngredients = new ArrayList<String>();
        this.tempIngredients.add("A pack of beef ramen");

        final JLabel title = new JLabel(tempRecipeResult);
        final JLabel name = new JLabel(tempRecipeName);
        final JLabel description = new JLabel(tempRecipeDescription);
        final JLabel steps = new JLabel(tempRecipeSteps);
        final JLabel ingredients = new JLabel("A pack of beef ramen");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(name);
        this.add(description);
        this.add(ingredients);
        this.add(steps);
    }

    public String getViewName() {
        return viewName;
    }

}
