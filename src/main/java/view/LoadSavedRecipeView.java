
package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import data_access.FileRecipeSaver;
import interface_adapter.load_saved_recipe.LoadSavedRecipeController;
import interface_adapter.load_saved_recipe.LoadSavedRecipeState;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;

/**
 * Represents the view component for loading saved recipes within the application.
 */
public class LoadSavedRecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Saved Recipes";
    private LoadSavedRecipeViewModel loadSavedRecipeViewModel;
    private LoadSavedRecipeController loadSavedRecipeController;
    private JList<String> recipeList;

    private final JButton loadButton;
    private final JButton cancelButton;
    private final JButton deleteButton;

    public LoadSavedRecipeView(LoadSavedRecipeViewModel loadSavedRecipeViewModel) {
        this.loadSavedRecipeViewModel = loadSavedRecipeViewModel;
        final JLabel title = new JLabel("Saved Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JPanel buttons = new JPanel();
        final JPanel recipesPanel = new JPanel();
        final String[] recipe = new String[]{"Lasagna:4 cups shredded mozzarella cheese divided, ½ cup shredded Parmesan cheese shredded and divided...", "Beef Noodles: 200g / 7oz beef mince (ground beef) (Note 3), 1 1/4 cups (315 ml) water, plus more as needed...", "Chicken Noodle Soup: ½ teaspoon freshly ground black pepper , to taste, 1/8 teaspoon dried rosemary ,or more, to taste,...", "Shrimp Salad:2 pounds shrimp, peeled and deveined,2 tablespoons finely chopped red onion,¼ teaspoon kosher salt...", "Pasta:Start by shredding both blocks of sharp cheddar cheese and set the cheese to the side, Bring a large pot of salted water to a boil. Boil the macaroni for 4 minutes, then drain it in a colander. Briefly rinse the pasta with cool water to cool it off....", "Shrimp Udon:1 pack (200g) udon noodles preferably vacuum-packed, \n" +
                "8 white mushrooms sliced, approx 120g...", "Tomato Soup:2 cups chicken stock,1/4 cup chopped fresh basil, plus more to serve,1/2 cup heavy whipping cream, or to taste to combat acidity..."};
        final JList<String> recipeList = new JList<>(recipe);
        final int num = 15;
        recipeList.setFont(new Font("Times New Roman", Font.PLAIN, num));
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane scrollPane = new JScrollPane(recipeList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        final int dim = 300;
        scrollPane.setPreferredSize(new Dimension(dim, dim));
        loadButton = new JButton("load");
        buttons.add(loadButton);
        cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);
        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);
        loadButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(loadButton)) {
                            final LoadSavedRecipeState currentState = loadSavedRecipeViewModel.getState();

                            loadSavedRecipeController.execute(
                                    currentState.getRecipe1(),
                                    currentState.getRecipe2(),
                                    currentState.getRecipe3()
                            );
                        }
                    }
                }
        );
        final JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loadSavedRecipeController.backToLastView();
            }
        });
        buttons.add(backButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancelButton)) {
                    recipeList.clearSelection();
                    JOptionPane.showMessageDialog(
                            LoadSavedRecipeView.this,
                            "Selection canceled.",
                            "Info",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(loadButton)) {
                    final LoadSavedRecipeState currentState = loadSavedRecipeViewModel.getState();
                    loadSavedRecipeController.loadRecipes(
                            currentState.getRecipe1(),
                            currentState.getRecipe2(),
                            currentState.getRecipe3()
                    );
                }
            }

        });

        this.cancelButton.addActionListener(this);
        deleteButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(recipesPanel);
        this.add(scrollPane);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadSavedRecipeController(LoadSavedRecipeController loadSavedRecipeController) {
        this.loadSavedRecipeController = loadSavedRecipeController;
    }

    public void initializeRecipeList() {
        final List<String> recipeNames = loadSavedRecipeController.getAllSavedRecipeNames();
        final DefaultListModel<String> model = new DefaultListModel<>();
        for (String name : recipeNames) {
            model.addElement(name);
        }
        recipeList.setModel(model);
    }

    private void refreshRecipeList() {
        final List<String> recipes = loadSavedRecipeViewModel.getRecipeList();
        final DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String recipe : recipes) {
            listModel.addElement(recipe);
        }
        recipeList.setModel(listModel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}