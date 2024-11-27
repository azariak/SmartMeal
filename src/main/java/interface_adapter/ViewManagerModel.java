package interface_adapter;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class ViewManagerModel extends ViewModel<String> {

    public ViewManagerModel() {
        super("view manager");
        this.setState("");
    }

    /**
     * Switch to view.
     * @param view view.
     */
    public void switchView(String view) {
        this.setPreviousViewName(this.getState());
        this.setState(view);
    }
}
