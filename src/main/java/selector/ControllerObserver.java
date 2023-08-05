package selector;

import utilities.Value;

public interface ControllerObserver {
    
    /**
     * Initialize the view with the controller.
     */
    void init();

    /**
     * Start the view and the game.
     */
    void start();

   /**
     * Compute the input and execute an action.
     * @param input to compute
     */
    void computeInput(Value input);

}
