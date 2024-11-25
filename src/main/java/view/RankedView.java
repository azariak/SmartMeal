package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class RankedView extends JPanel implements PropertyChangeListener {

    private final String viewName = "Ranked Recipes View";
    private final HashMap<Integer, String> stars = new HashMap<>();

    private final String testRanking;
    private final String testRanking2;
    private final String testRanking3;
    private final String testRanking4;
    private final String testRanking5;


    public <RankedViewModel> RankedView(RankedViewModel rankedViewModel) {
        // Initialize stars map
        initializeStars();

        // Initialize ranking strings
        testRanking = "Sample recipe 1: " + stars.get(1);
        testRanking2 = "Sample recipe 2: " + stars.get(2);
        testRanking3 = "Sample recipe 1: " + stars.get(3);
        testRanking4 = "Sample recipe 2: " + stars.get(4);
        testRanking5 = "Sample recipe 1: " + stars.get(5);

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

        // Boxes for the rankings
        JPanel box1 = createRankingBox(testRanking);
        JPanel box2 = createRankingBox(testRanking2);
        JPanel box3 = createRankingBox(testRanking3);
        JPanel box4 = createRankingBox(testRanking4);
        JPanel box5 = createRankingBox(testRanking5);

        // Edit button
        final JButton editButton = new JButton("<html><font color=#08289c>Edit Rankings</font></html>");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(editButton);

        // Layout settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 20, 20, 20)); // Padding around the entire panel

        // Adding components
        this.add(titlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Space between title and subtitle
        this.add(subTitlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 20))); // Space between subtitle and rankings
        // Create ranking boxes dynamically and add them to the panel
        for (int i = 1; i <= 5; i++) {
            JPanel box = createRankingBox("Sample recipe " + i + ": " + stars.get(i));
            this.add(box);
            if (i < 5) { // Add spacing only between boxes, not after the last one
                this.add(Box.createRigidArea(new Dimension(0, 10))); // Space between ranking boxes
            }
        }
        this.add(Box.createRigidArea(new Dimension(0, 20))); // Space between rankings and button
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
                BorderFactory.createLineBorder(new Color(8, 40, 156)), // Border color
                "Recipe Ranking", // Title
                TitledBorder.CENTER, // Title alignment
                TitledBorder.TOP, // Title position
                new Font("Arial", Font.BOLD, 12), // Title font
                new Color(8, 40, 156) // Title color
        ));

        panel.setBackground(new Color(240, 240, 255)); // Light background
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
