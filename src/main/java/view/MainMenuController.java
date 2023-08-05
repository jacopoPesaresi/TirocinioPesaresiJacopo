package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utilities.Pair;
import utilities.Value;

public class MainMenuController {

    private final static String PATH = "TOSELECT";
    private final static String SEP = System.getProperty("file.separator");

    @FXML
    private ImageView imageView;
    @FXML
    private Slider grower;
    @FXML
    private Label value;


    public MainMenuController() { 

    }

    public void updateImage(Pair<String, Value> name) {
        this.imageView.setImage(new Image(ClassLoader.getSystemResource(
                PATH + SEP + name.getX()).toString()));
                System.out.println(grower.getValue());
        this.value.setText(name.getY().toString());
    }

    @FXML
    private void changeSize() {
        System.out.println(grower.getValue());
        imageView.setScaleX(grower.getValue()/100);
        imageView.setScaleY(grower.getValue()/100);
    }
}
