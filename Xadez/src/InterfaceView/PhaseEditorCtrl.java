package InterfaceView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    @FXML
    ImageView peonImg;
    @FXML
    ImageView horseImg;
    @FXML
    ImageView bishopImg;
    @FXML
    ImageView kingImg;
    @FXML
    ImageView queenImg;
    @FXML
    ImageView towerImg;
    @FXML
    Button saveBtn;
    
    Image[] heroImages = new Image[5]; 
    ImageView[] piecesImg = new ImageView[6];
    String phaseName;
    
    ImageView selectedPiece;
    Thread heroChange = new Thread("HeroChanging");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int width = 60, heigth = 50;
        heroImages[0] = new Image("InterfaceView/Personagens/huehuebr-01.png", width, heigth, false, false);
        heroImages[1] = new Image("InterfaceView/Personagens/lapa-01.png", width, heigth, false, false);
        heroImages[2] = new Image("InterfaceView/Personagens/lenin-01.png", width, heigth, false, false);
        heroImages[3] = new Image("InterfaceView/Personagens/omago-01.png", width, heigth, false, false);
        heroImages[4] = new Image("InterfaceView/Personagens/pistoleiro-01.png", width, heigth, false, false);
        
        piecesImg[0] = peonImg;
        piecesImg[1] = towerImg;
        piecesImg[2] = horseImg;
        piecesImg[3] = bishopImg;
        piecesImg[4] = queenImg;
        piecesImg[5] = kingImg;
        
        p1Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                p1Image.setImage(heroImages[(int)p1Slider.getValue() - 1]);
            }
        });
        
        p2Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                p2Image.setImage(heroImages[(int)p2Slider.getValue() - 1]);
            }
        });
        
        saveBtn.addEventHandler(ActionEvent.ANY, (ActionEvent e) -> {
            try {
                String tempPath = System.getProperty("java.io.tmpdir");
                File fase = new File(tempPath, nameInput.getText() + ".txt");
                FileWriter fw = new FileWriter(fase);
                fw.write((int) p1Slider.getValue() + " " + (int)p2Slider.getValue());
                System.out.println(fase.getCanonicalPath());
                fw.close();
            } catch(Exception es) {
                es.printStackTrace();
            } 
            
        });
        
        for(ImageView img : piecesImg) {
            img.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
                selectedPiece = img;
            });
        }
    }    
    
}
