package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.GenericRecipe;
import interface_adapter.result.ResultViewModel;

/**
 * The result view.
 */
public class ResultView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final Integer MAXIMUM_RECIPE_TO_DISPLAY = 10;
    private static final Integer MINIMUM_RECIPE_TO_DISPLAY = 0;

    private final String viewName = "Result View";
    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
        final JLabel title = new JLabel("Results");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        final JButton showResult = new JButton("Show Results");
        showResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        showResult.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(showResult)) {
                            addRecipeButtons();
                            showResult.setVisible(false);
                        }

                    }
                }
        );
        this.add(showResult);

    }

    /**
     * Add the recipe buttons.
     */
    public void addRecipeButtons() {

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        final ArrayList<GenericRecipe> recipeArrayList = resultViewModel.getState().getResult().getRecipes();

        if (recipeArrayList.size() == MINIMUM_RECIPE_TO_DISPLAY) {
            final JLabel zeroRecipeErrorMessage = new JLabel("No Recipe Found");
            this.add(zeroRecipeErrorMessage);
        }
        else if (recipeArrayList.size() <= MAXIMUM_RECIPE_TO_DISPLAY) {
            for (GenericRecipe genericRecipe : recipeArrayList) {
                buttons.add(new JButton(genericRecipe.getName()));
            }
        }
        else {
            for (int i = 0; i < MAXIMUM_RECIPE_TO_DISPLAY; i++) {
                buttons.add(new JButton(recipeArrayList.get(i).getName()));
            }
        }
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

}

