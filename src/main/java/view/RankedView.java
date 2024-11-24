package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

public class RankedView extends JPanel implements PropertyChangeListener {

    private final String viewName = "Ranked Recipes View";
    private final String testRanking = "Sample recipe 1: ★★★☆☆";
    private final String testRanking2 = "Sample recipe 2: ★★☆☆☆";


    public <RankedViewModel> RankedView(RankedViewModel rankedViewModel) {

        final JLabel title = new JLabel("<html><center><h1><font color=#fcba03>Ranked Recipes");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        final JLabel subTitle = new JLabel("<html><center><h3><font color=#1F4529>Use this view t" +
                "o find the recipes you've ranked or to add new rankings!");
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);


        final JLabel test = new JLabel("<html>" + testRanking + "<font color=#08289c> <p> ");
        final JLabel test2 = new JLabel(testRanking2);

        final JButton editButton = new JButton("<html><font color=#08289c> <p> Edit Rankings");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(subTitle);
        this.add(Box.createRigidArea(new Dimension(0, 10)));

        this.add(test);
        this.add(test2);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(editButton);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
