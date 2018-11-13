package InterfaceView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ChooseCharacterController implements Initializable {

    @FXML
    Button setaEsq;
    @FXML
    Button setaDir;
    @FXML
    Button characterSelection;
    @FXML
    Text heroName;
    Image myImage;
    ImageView myImageView;
    int count = 0;
    Image[] perso = new Image[5];
    String[] heroNames = new String[5];
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
        int resX = 446;
        int resY = 336;
        perso[0] = new Image("InterfaceView/huehuebr-01.png",resX, resY, false, false);
        heroNames[0] = "Huehue br";
        perso[1] = new Image("InterfaceView/lapa-01.png",resX, resY, false, false);
        heroNames[1] = "Lapa";
        perso[2] = new Image("InterfaceView/lenin-01.png",resX, resY, false, false);
        heroNames[2] = "Czar Nicolau II";
        perso[3] = new Image("InterfaceView/omago-01.png", resX, resY, false, false);
        heroNames[3] = "The Wizard";
        perso[4] = new Image("InterfaceView/pistoleiro-01.png",resX, resY, false, false);
        heroNames[4] = "Gunslinger";
        myImage = new Image("InterfaceView/setaesq.png");
        myImageView = new ImageView(myImage);
        setaEsq.setGraphic(myImageView);
        myImage = new Image("InterfaceView/setadir.png");
        myImageView = new ImageView(myImage);
        setaDir.setGraphic(myImageView);
        characterSelection.setGraphic(new ImageView(perso[0]));
        
    }
      @FXML
    public void onSetaClickEsq(MouseEvent event) {
        if(count == 0){
            count = 4;
        }else{
            count--;
        }
        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onSetaClickDir(MouseEvent event){
        if(count == 4){
            count = 0;
        }else{
            count++;
        }
        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onClickButton(MouseEvent event){
        
    }
    
}
