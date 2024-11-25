package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Public class RankedView.
 */
public class RankedView extends JPanel implements PropertyChangeListener {

    private final String viewName = "Ranked Recipes View";
    private final HashMap<Integer, String> stars = new HashMap<>();
    private final Integer numRecipes = 5;

    private final String[] testRankings = new String[numRecipes];

    private final Integer fontSize = 12;

    private final Color recipeBoxBackground = new Color(240, 240, 255);

    public <RankedViewModel> RankedView(RankedViewModel rankedViewModel) {
        // Initialize stars map
        initializeStars();

        // Initialize ranking strings
        // Initialize ranking strings
        for (int i = 0; i < testRankings.length; i++) {
            testRankings[i] = "Sample recipe " + (i + 1) + ": " + stars.get(i + 1);
        }

        // Title and subtitle
        final JLabel title = new JLabel("<html><h1><font color=#fcba03>Ranked Recipes</font></h1></html>");
        final JLabel subTitle = new JLabel("<html><h3><font color=#1F4529>Use this view to find the recipes you've ranked or to add new rankings!</font></h3></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // Wrapping title and subtitle in FlowLayout panels for perfect centering
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(title);

        JPanel subTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        subTitlePanel.add(subTitle);

        // Edit button
        final JButton editButton = new JButton("<html><font color=#08289c>Edit Rankings</font></html>");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(editButton);

        // Layout settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Adding components
        this.add(titlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(subTitlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        // Create ranking boxes dynamically and add them to the panel
        for (int i = 1; i <= numRecipes; i++) {
            JPanel box = createRankingBox("Sample recipe " + i + ": " + stars.get(i));
            this.add(box);
            if (i < numRecipes) {
                this.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(buttonPanel);
    }

    /**
     * Initializes the stars HashMap with star ratings.
     */
    private void initializeStars() {
        stars.put(1, "★☆☆☆☆");
        stars.put(2, "★★☆☆☆");
        stars.put(3, "★★★☆☆");
        stars.put(4, "★★★★☆");
        stars.put(5, "★★★★★");
    }

    /**
     * Creates a styled box for a given ranking.
     *
     * @param ranking The text to display inside the box.
     * @return A JPanel containing the styled ranking.
     */
    private JPanel createRankingBox(String ranking) {
        JLabel label = new JLabel("<html><font color=#08289c>" + ranking + "</font></html>");
        label.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(8, 40, 156)),
                "Recipe Ranking",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                // Title font
                new Font("Arial", Font.BOLD, fontSize),
                new Color(8, 40, 156)
        ));

        panel.setBackground(recipeBoxBackground);
        // Light background
        return panel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change events
    }

    public String getViewName() {
        return viewName;
    }
}
