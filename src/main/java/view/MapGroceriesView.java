package view;

import interface_adapter.back.BackController;
import interface_adapter.map_groceries.MapGroceriesController;
import interface_adapter.map_groceries.MapGroceriesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The view for when the user opens the grocery list for a recipe.
 */
public class MapGroceriesView extends JPanel implements PropertyChangeListener {

    private final String viewName = "Grocery List";
    private final MapGroceriesViewModel mapGroceriesViewModel;
    private MapGroceriesController mapGroceriesController;
    private BackController backController;

    private JPanel groceryList;

    public MapGroceriesView(MapGroceriesViewModel mapGroceriesViewModel) {

        this.mapGroceriesViewModel = mapGroceriesViewModel;
        this.mapGroceriesViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title Label
        final JLabel title = new JLabel(viewName);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // Detail Message
        final JLabel detailMessage = new JLabel("Here is a list of grocery items you can use for the recipe!");
        detailMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(detailMessage);

        addBackButton();
        this.add(addGroceryInfoPanel());

    }

    private void addBackButton() {
        final JPanel backButtonPanel = new JPanel();
        final JButton back = new JButton("Back");
        back.addActionListener(evt -> backController.backToLastView());
        backButtonPanel.add(back);
        this.add(backButtonPanel);
    }

    private JPanel addGroceryInfoPanel() {
        this.groceryList = new JPanel();
        groceryList.setBorder(BorderFactory.createTitledBorder("Grocery List"));
        groceryList.setLayout(new BoxLayout(groceryList, BoxLayout.Y_AXIS));

        final ArrayList<Map<String, Object>> groceries = mapGroceriesViewModel.getState().getGroceries();
        for (Map<String, Object> item : groceries) {
            groceryList.add(new JLabel(item.toString()));
        }
        return groceryList;
    }

    /**
     * Remove grocery view.
     */
    private void removeGroceryList() {
        groceryList.removeAll();
    }

    public void setMapGroceriesController(MapGroceriesController mapGroceriesController) {
        this.mapGroceriesController = mapGroceriesController;
    }

    public void setBackController(BackController backController) {
        this.backController = backController;
    }

    public String getViewName() {
        return this.viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            try {
                mapGroceriesController.execute(mapGroceriesViewModel.getState().getRecipeID());
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
