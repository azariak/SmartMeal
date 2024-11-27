package interface_adapter;

import java.util.ArrayList;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class ViewManagerModel extends ViewModel<String> {
    private final ArrayList<String> viewHistory = new ArrayList<>();

    public ViewManagerModel() {
        super("view manager");
        this.setState("");
    }

    /**
     * Switch to view.
     * @param view view.
     */
    public void switchView(String view) {
        this.addViewHistory(this.getState());
        this.setState(view);
    }

    /**
     * Retrieve the name of the last view and remove it from the history.
     * @return the name of the last view.
     */
    public String getPreviousViewName() {
        String result = "";
        if (!this.viewHistory.isEmpty()) {
            result = this.viewHistory.get(viewHistory.size() - 1);
            viewHistory.remove(viewHistory.size() - 1);
        }
        return result;
    }

    /**
     * Add View name to view history.
     * @param name view name.
     */
    public void addViewHistory(String name) {
        this.viewHistory.add(name);

    }
}
