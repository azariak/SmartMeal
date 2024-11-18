package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

public class RankedView extends JPanel implements PropertyChangeListener {

    private final String viewName = "Ranked Recipes View";

    public <RankedViewModel> RankedView(RankedViewModel rankedViewModel) {

        final JLabel title = new JLabel(viewName);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
