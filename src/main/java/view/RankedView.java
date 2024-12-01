package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import interface_adapter.ranked.RankedController;
import interface_adapter.ranked.RankedViewModel;

/**
 * This class represents the Ranked View for displaying and editing ranked recipes.
 * It allows users to view the rankings of their recipes and edit the ratings in edit mode.
 */
public class RankedView extends JPanel implements ActionListener, PropertyChangeListener {

    private final RankedViewModel viewModel;
    private final Color recipeBoxBackground = new Color(240, 240, 255);
    private final Color lineBorder = new Color(8, 40, 156);
    private final Color starColor = new Color(255, 215, 0);
    private boolean isEditMode;

    private RankedController rankedController;
    private JPanel rankingsPanel;

    public RankedView(RankedViewModel rankedViewModel) {
        this.viewModel = rankedViewModel;
        this.viewModel.addPropertyChangeListener(this);

        initializeView();
    }

    private void initializeView() {
        final int panelHeight = 600;
        final int panelWidth = 100;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        // Title and subtitle
        final JLabel title = new JLabel("<html><h1><font color=#fcba03>Ranked Recipes</font></h1></html>");
        final JLabel subTitle = new JLabel("<html><h3><font color=#1F4529>Use this "
                + "view to find the recipes you've ranked or to add new rankings!</font></h3></html>");
        final JLabel editText = new JLabel("<html><h3><font color=#a1150b>Edit mode: Click on stars "
                + "to change rating</font></h3></html>");

        title.setHorizontalAlignment(SwingConstants.CENTER);
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);

        final JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(title);

        final JPanel subTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        subTitlePanel.add(subTitle);

        final JPanel editTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        editTextPanel.add(editText);
        editTextPanel.setVisible(false);

        // Edit button
        final JButton editButton = new JButton("<html><font color=#08289c>Edit Rankings</font></html>");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                isEditMode = !isEditMode;
                editTextPanel.setVisible(isEditMode);
                updateRankingsDisplay();
                revalidate();
                repaint();
            }
        });

        // Back button
        final JButton backButton = new JButton("<html><font color=#08289c>Back</font></html>");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rankedController.backToLastView();
            }
        });

        // Panel for edit and back buttons
        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.add(editButton);
        buttonPanel.add(backButton);

        // Layout settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final int twenty = 20;
        this.setBorder(BorderFactory.createEmptyBorder(twenty, twenty, twenty, twenty));

        // Rankings panel
        rankingsPanel = new JPanel();
        rankingsPanel.setLayout(new BoxLayout(rankingsPanel, BoxLayout.Y_AXIS));
        updateRankingsDisplay();

        // Adding components
        this.add(titlePanel);
        final int ten = 10;
        this.add(Box.createRigidArea(new Dimension(0, ten)));
        this.add(subTitlePanel);
        this.add(Box.createRigidArea(new Dimension(0, twenty)));
        this.add(rankingsPanel);
        this.add(editTextPanel);
        this.add(Box.createRigidArea(new Dimension(0, 0)));
        this.add(buttonPanel);
    }

    private void updateRankingsDisplay() {
        rankingsPanel.removeAll();
        final String[] rankings = viewModel.getRankings();

        if (rankings.length == 0) {
            // Display a message when no recipes are ranked
            final JLabel noRecipesLabel = new JLabel("<html><h2><font color=#a1150b>No recipes have "
                    + "been ranked yet.</font></h2></html>");
            noRecipesLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noRecipesLabel.setVerticalAlignment(SwingConstants.CENTER);
            noRecipesLabel.setFont(new Font("Arial", Font.BOLD, 20));
            rankingsPanel.setLayout(new BorderLayout());
            rankingsPanel.add(noRecipesLabel, BorderLayout.CENTER);
        }

        else {
            for (int i = 0; i < rankings.length; i++) {
                final int recipeIndex = i;
                final JPanel recipePanel = new JPanel(new BorderLayout());

                // Extract recipe name and current stars
                final String[] parts = rankings[i].split(": ");
                final String recipeName = parts[0];
                final String currentStars = parts[1];
                final int currentStarCount = currentStars.length() - currentStars.replace("★", "").length();

                // Recipe name label
                final JLabel nameLabel = new JLabel("<html><font color=#08289c>" + recipeName + "</font></html>");

                // Star panel
                final JPanel starPanel = new JPanel(new GridLayout(1, 5));
                final int numStars = 5;
                for (int j = 1; j <= numStars; j++) {
                    final int starCount = j;

                    final JButton starButton;
                    if (j <= currentStarCount) {
                        starButton = new JButton("★");
                    }
                    else {
                        starButton = new JButton("☆");
                    }
                    starButton.setOpaque(true);
                    starButton.setBackground(recipeBoxBackground);
                    final int twenty = 20;
                    starButton.setFont(new Font("Dialog", Font.BOLD, twenty));
                    starButton.setForeground(starColor);
                    starButton.setBorder(BorderFactory.createEmptyBorder());
                    starButton.setContentAreaFilled(false);

                    if (isEditMode) {
                        starButton.addActionListener(e -> {
                            viewModel.updateStarRating(recipeIndex, starCount);
                        });
                    }

                    starPanel.add(starButton);
                    starPanel.setBackground(recipeBoxBackground);
                }

                recipePanel.add(nameLabel, BorderLayout.WEST);
                recipePanel.add(starPanel, BorderLayout.EAST);

                final int twelve = 12;
                recipePanel.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(lineBorder),
                        "Recipe Ranking",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, twelve),
                        lineBorder
                ));
                recipePanel.setBackground(recipeBoxBackground);

                rankingsPanel.add(recipePanel);
                final int ten = 10;
                rankingsPanel.add(Box.createRigidArea(new Dimension(0, ten)));
            }
        }

        revalidate();
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("rankings".equals(evt.getPropertyName())) {
            updateRankingsDisplay();
        }
    }

    public String getViewName() {
        return "Ranked Recipes View";
    }

    public void setRankedController(RankedController rankedController) {
        this.rankedController = rankedController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
