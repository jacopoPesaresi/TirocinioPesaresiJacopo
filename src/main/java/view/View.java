package view;


import selector.ControllerObserver;
import utilities.Pair;
import utilities.Value;

/**
 * Define the set of method for show result after input of this game.
 */
public interface View {

    /**
     * Starts the game view creating a new window.
     */
    void startView();

    /**
     * Initializes the view.
     * @param ctrl the controller that will communicate with the view
     */
    void init(ControllerObserver ctrl);

    boolean uploadImage(Pair<String, Value> image);

}
