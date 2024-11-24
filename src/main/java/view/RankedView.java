package view;

import java.awt.Component;
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
        final JLabel test = new JLabel(testRanking);
        final JLabel test2 = new JLabel(testRanking2);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(test);
        this.add(test2);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
