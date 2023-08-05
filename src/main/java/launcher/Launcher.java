package launcher;



import selector.ControllerObserver;
import selector.ControllerImpl;

/**
 * Class entry-point of the project.
 */
public final class Launcher {

    private Launcher() {
    }

    /**
     * Entry point.
     * @param args some parameter... typically not used in this project
     */
    public static void main(final String[] args) {
        final ControllerObserver ctrl = new ControllerImpl();
        ctrl.init();
        ctrl.start();
    }
}
