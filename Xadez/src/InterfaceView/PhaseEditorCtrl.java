package InterfaceView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PhaseEditorCtrl implements Initializable {

    @FXML
    TextField nameInput;
    @FXML
    ImageView p1Image;
    @FXML
    ImageView p2Image;
    @FXML
    Slider p1Slider;
    @FXML
    Slider p2Slider;
    @FXML
    GridPane tabGrid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
