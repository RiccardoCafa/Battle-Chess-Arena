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
    private Image myImage;
    private ImageView myImageView;
    private int count = 0;
    private Image[] perso = new Image[5];
    private String[] heroNames = new String[5];
    private String name;
    
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

    public void onClickButton(MouseEvent e){
        switch(count){
            case 0:
                name = "Hue";
                break;
            case 1:
                name = "Lapa";
                break;
            case 2:
                name = "Czar";
                break;
            case 3:
                name = "Mago";
                break;
            case 4:
                name = "Pistoleiro";
                break;
        }
        //funcao para pegar o player
    }
    public String getName(){
        return name;
    }
}
