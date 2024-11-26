package view;

import interface_adapter.Ranked.RankedViewModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RankedView extends JPanel implements PropertyChangeListener {

    private final RankedViewModel viewModel;
    private final Color recipeBoxBackground = new Color(240, 240, 255);
    private final Color lineBorder = new Color(8, 40, 156);
    private final int fontSize = 12;
    private final int ten = 10;
    private final int twenty = 20;

    public RankedView(RankedViewModel rankedViewModel) {
        this.viewModel = rankedViewModel;
        this.viewModel.addPropertyChangeListener(this);

        // Title and subtitle
        final JLabel title = new JLabel("<html><h1><font color=#fcba03>Ranked Recipes</font></h1></html>");
        final JLabel subTitle = new JLabel("<html><h3><font color=#1F4529>Use this "
                + "view to find the recipes you've ranked or to add new rankings!</font></h3></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);

        final JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(title);

        final JPanel subTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        subTitlePanel.add(subTitle);

        // Edit button
        final JButton editButton = new JButton("<html><font color=#08289c>Edit Rankings</font></html>");

        // Back button
        final JButton backButton = new JButton("<html><font color=#08289c>Back</font></html>");
        backButton.addActionListener(back -> {
            final Container parent = this.getParent();
            if (parent instanceof JPanel) {
                final CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "Main");
            }
        });

        // Panel for edit and back buttons
        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.add(editButton);
        buttonPanel.add(backButton);

        // Layout settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adding components
        this.add(titlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(subTitlePanel);
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        // Create ranking boxes dynamically and add them to the panel
        for (String ranking : viewModel.getRankings()) {
            final JPanel box = createRankingBox(ranking);
            this.add(box);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(buttonPanel);
    }


    private JPanel createRankingBox(String ranking) {
        final JLabel label = new JLabel("<html><font color=#08289c>" + ranking + "</font></html>");
        label.setHorizontalAlignment(SwingConstants.LEFT);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(lineBorder),
                "Recipe Ranking",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, fontSize),
                lineBorder
        ));
        panel.setBackground(recipeBoxBackground);
        return panel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("ranking".equals(evt.getPropertyName())) {
            this.removeAll();
            for (String ranking : viewModel.getRankings()) {
                this.add(createRankingBox(ranking));
            }
            this.revalidate();
            this.repaint();
        }
    }

    public String getViewName() {
        return "Ranked Recipes View";
    }
}
