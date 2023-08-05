package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import selector.ControllerObserver;
import utilities.Pair;
import utilities.Value;

import java.io.IOException;

/**
 * This class is used to see which entities have changed their position or,
 * which are the new entities that will then be printed on the screen.
 */
public class FXMLMainView extends Application implements View {

    //private static final String ICONPATH = "file:src/main/resources/it/unibo/ruscodc/view/racoon.png";
    //private static final String TITLE = "Rusco DC";
    private static final double ASPECT_RATIO = 3 / 4.;
    //private static final double MIN_WIDTH_SCALE = 0.4;
    private static final double MIN_WIDTH = 800;
    private static final double MIN_HEIGHT = 600;
    private ControllerObserver controller;

    //private Controller gameView;
    private MainMenuController menuController;

    //private final List<Entity> printedEntity = new ArrayList<>();
    private Stage stage;

    //private boolean isPrintingInfo;

    /** {@inheritDoc} */
    @Override
    public void startView() {
        if (this.controller == null) {
            throw new IllegalStateException(
                    "Error in ViewJFX: The controller has not been initialized."
                            + " Please initialize the controller before starting the view."
            );
        }

        Platform.startup(() -> {
            this.stage = new Stage();
            stage.setMinWidth(MIN_WIDTH);
            stage.setMinHeight(MIN_HEIGHT);
            this.start(stage);
        });
    }

    /** {@inheritDoc} */
    @Override
    public void init(final ControllerObserver ctrl) {
        this.controller = ctrl;
    }

    /**
     * Init a new game.
     * @param filename the name of the file where the saves will take place
     */
    public void startNewGame(final String filename) {
        Scene scene;
        try {
            scene = this.loadMainMenu();
        } catch (IOException e) {
            return;
        }
        stage.setScene(scene);
    }

    private void showMainMenu() {
        Scene scene;
        try {
            scene = this.loadMainMenu();
        } catch (IOException e) {
            return;
        }

        this.handleEvents(stage);

        stage.setScene(scene);
        stage.setUserData(this.controller);

        stage.show();
        //this.menuController.setLayout();
    }

    /** {@inheritDoc} */
    @Override
    public void start(final Stage stage) {
        this.stage = Collections.nCopies(1, stage).get(0);
        showMainMenu();
    }

    private Scene loadMainMenu() throws IOException {
        final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        final double scale = 2 / 3.;
        final double width = screenSize.getWidth() * scale;
        final FXMLLoader fxmlLoader = new FXMLLoader(FXMLMainView.class.getResource("simple-selector.fxml"));

        final Scene scene = new Scene(fxmlLoader.load(), width, width * ASPECT_RATIO);
        
        this.menuController = (MainMenuController) fxmlLoader.getController();
        this.handleUserInputs(scene);
        //this.menuController.init(this);
        return scene;
    }

    // private Scene loadGameView() throws IOException {
    //     // final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    //     // final double scale = 2 / 3.;
    //     // final double width = screenSize.getWidth() * scale;
    //     // final FXMLLoader fxmlLoader = new FXMLLoader(FXMLMainView.class.getResource("game-view.fxml"));

    //     // final Scene scene = new Scene(fxmlLoader.load(), width, width * ASPECT_RATIO);

    //     // this.gameView = (GameViewController) fxmlLoader.getController();
    //     // this.gameView.init(this);
    //     // this.handleUserInputs(scene);
    //     // //this.gameView.updateEntities(this.printedEntity);
    //     // //this.gameView.update();
    //     // this.gameView.clearInfoPalyodToScreen();
    //     return null;
    // }

    // private Scene loadGameOver(final boolean isOver) throws IOException {
    //     // final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    //     // final double scale = 2 / 3.;
    //     // final double width = screenSize.getWidth() * scale;
    //     // final FXMLLoader fxmlLoader = new FXMLLoader(FXMLMainView.class.getResource("game-over.fxml"));
    //     // final Scene scene = new Scene(fxmlLoader.load(), width, width * ASPECT_RATIO);
    //     // final GameOverController gameOverController = (GameOverController) fxmlLoader.getController();
    //     // gameOverController.init(this);
    //     // gameOverController.backToMenu();
    //     // gameOverController.setTitle(isOver);
    //     return null;
    // }

    /**
     * @param stage
     */
    private void handleEvents(final Stage stage) {
        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }



    private void handleUserInputs(final Scene scene) {
        scene.setOnKeyPressed((KeyEvent key) -> {
            controller.computeInput(getInput(key));
            /**
             * redirigi input al controller-model
             */
        });
    }

    private Value getInput(final KeyEvent e) {
        System.out.println(e.getCode());
        
        return switch (e.getCode()) {
            case NUMPAD0 -> Value.ZERO;
            case NUMPAD1 -> Value.ONE;
            case NUMPAD2 -> Value.TWO;
            case NUMPAD3 -> Value.THREE;
            case NUMPAD4 -> Value.FOUR;
            case NUMPAD5 -> Value.FIVE;
            case NUMPAD6 -> Value.SIX;
            case NUMPAD7 -> Value.SEVEN;
            case NUMPAD8 -> Value.EIGHT;
            case NUMPAD9 -> Value.NINE;

            case DIGIT0 -> Value.ZERO;
            case DIGIT1 -> Value.ONE;
            case DIGIT2 -> Value.TWO;
            case DIGIT3 -> Value.THREE;
            case DIGIT4 -> Value.FOUR;
            case DIGIT5 -> Value.FIVE;
            case DIGIT6 -> Value.SIX;
            case DIGIT7 -> Value.SEVEN;
            case DIGIT8 -> Value.EIGHT;
            case DIGIT9 -> Value.NINE;

            case A -> Value.GOBACK;
            case C -> Value.CLOSE;
            case S -> Value.GO;
            
            default -> Value.UNCLASSIFIED;
        };
    }

    @Override
    public boolean uploadImage(Pair<String, Value> image) {
        menuController.updateImage(image);
        return true;
    }

    // private void loadOverInterface(final boolean isOver, final String suppMess) {
    //     Scene scene;
    //     // try {
    //     //     scene = this.loadGameOver(isOver);
    //     // } catch (IOException e) {
    //     //     this.printInfo(new InfoPayloadImpl(
    //     //             GLOBAL_ERR_TITLE,
    //     //             suppMess));
    //     //     return;
    //     // }
    //     //stage.setScene(scene);
    // }

    

}
